package com.takima.backskeleton.controllers;


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
import java.util.List;
import java.util.Map;

@RestController
class   AIController {

    private final ChatClient chatClient;

    public AIController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping("/ai")
    public Project generateProgram(@RequestParam(value = "project") Project project) {
        String userText = "Generate a list of tasks to complete the project with the following details (Note that project_Name is the goal of the project): " +
                "Project Name: " + project.getName_project() + ", " +
                "Project end_Date: " + project.getDate_project() + ". " +
                "The tasks should be detailed and compatible with the Task interface.    " +
                "    private String title_task;"+
                "    private String description_task;" +
                "    private int priority_task;" +
                "    private Date deadline_task;" +
                "    private boolean achieved_task;";
        Message userMessage = new UserMessage(userText);

        String systemText = """
  You are a helpful AI assistant that helps people plan and manage projects,
  you also are very knowledgeable on how to plan to achieve sports goals.
  You should generate a list of tasks to complete the project based on the provided project details.
  Each task should be detailed and compatible with the Task interface.
  """;

        Message systemMessage = new SystemMessage(systemText);

        Prompt prompt = new Prompt(List.of(userMessage, systemMessage));
        var aiAnswer = chatClient.prompt(prompt).call().chatResponse();
        //project.setTasks(trim(aiAnswer.getMetadata().get));
        return project;
    }
    private List<Task> trim(String AIAnswer) {

    }
}
