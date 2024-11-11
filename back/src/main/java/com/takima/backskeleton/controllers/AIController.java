package com.takima.backskeleton.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.takima.backskeleton.models.Project;
import com.takima.backskeleton.models.Task;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.management.monitor.StringMonitor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
class   AIController {

    private final ChatClient chatClient;

    public AIController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping("/ai")
    public Project generateProgram(@RequestParam(value = "project") String req) {
       Project project= Project.createFromJson(req);
        String userText = """
                Using the project details below, generate a structured list of tasks in JSON format. Each task should be well-defined to support completion of the project, with accurate descriptions, priority levels, and deadlines that lead up to the project end date. Format the JSON output exactly as described to be compatible with a Java interface.
                        
                Each task should include:
                        
                title_task: a concise title for the task.
                description_task: a clear, specific description of the task.
                priority_task: an integer priority level (e.g., 1 for high, 2 for medium).
                deadline_task: a date for the task deadline, leading up to""" + project.getDate_project()+"."+
                """
                achieved_task: always set to false.
                Project Details:
                        
                Project Name:"""+ project.getName_project()+
                "Project End Date:" +project.getDate_project()+
                "Return the response as a JSON array where each object represents a task and do not write the ```json.";
        Message userMessage = new UserMessage(userText);

        Prompt prompt = new Prompt(userMessage);
        var aiAnswer = chatClient.prompt(prompt).call().chatResponse();
        project.setTasks(parseTasks(aiAnswer.getResult().getOutput().getContent(),project));
        return project;
    }
    private List<Task> parseTasks(String aiAnswer, Project project) {
        List<Task> tasks = new ArrayList<>();

        // Initialize ObjectMapper with date format
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        aiAnswer = aiAnswer.replace("```json", "").replace("```", "").trim();
        try {
            // Deserialize JSON array string into a list of Task objects
            Task[] taskArray = objectMapper.readValue(aiAnswer, Task[].class);

            // Set project and id for each task
            for (int i = 0; i < taskArray.length; i++) {
                Task task = taskArray[i];
                task.setId_task((long) i);
                task.setProject(project);
                tasks.add(task);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing tasks JSON", e);
        }
        return tasks;
    }
}
