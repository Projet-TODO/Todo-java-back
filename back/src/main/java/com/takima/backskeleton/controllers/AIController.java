package com.takima.backskeleton.controllers;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AIController {

    private final ChatClient chatClient;

    public AIController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping("/ai")
    public ChatResponse generateText(@RequestParam(value = "message") String message) {
        var prompt = new Prompt(message);
        return chatClient.prompt(prompt).call().chatResponse();
    }
}
