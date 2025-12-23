package com.genAi.ChatClient;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MultiModelChatClientApplication {
//	@Bean
//	public ChatClient openaiClient(OpenAiChatModel openAiChatModel) {
//		return ChatClient.builder(openAiChatModel).build();
//	}
//
//	@Bean
//	public ChatClient ollamaClient(OllamaChatModel ollamaChatModel) {
//		return ChatClient.builder(ollamaChatModel).build();
//
//	}

	public static void main(String[] args) {
		SpringApplication.run(MultiModelChatClientApplication.class, args);
	}

}
