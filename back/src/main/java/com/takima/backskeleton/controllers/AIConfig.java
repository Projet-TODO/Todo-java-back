package com.takima.backskeleton.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfig {

    @Bean
    ChatClient chatClient(ChatClient.Builder builder) {
        return builder.defaultSystem(" You are a helpful AI assistant that helps people plan and manage projects,\n" +
                        "  you also are very knowledgeable on how to plan to achieve sports goals.\n" +
                        "  You should generate a list of tasks to complete the project based on the provided project details.\n" +
                        "  Each task should be detailed and compatible with the Task interface.\n" +
                        "  \"\"\";")
                .build();
    }

}

