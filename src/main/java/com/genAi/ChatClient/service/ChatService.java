package com.genAi.ChatClient.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient ollamaChatClient;
    private final ChatClient openaiChatClient;

    /*
    Since there are 2 beans of same type i.e. ChatClient.
    @Qualifier is used to address the ambiguity of which bean is to be used for each param.
    Beans are defined in a separate configuration file marked with @Configuration
     */

    public ChatService(
            @Qualifier("ollamaChatClient") ChatClient ollama,
            @Qualifier("openaiChatClient") ChatClient openAi) {
        this.ollamaChatClient = ollama;
        this.openaiChatClient = openAi;
    }

        /*
    or in the application class.

    public ChatService(
            @Qualifier("ollamaClient") ChatClient ollama,
            @Qualifier("openaiClient") ChatClient openAi) {
        this.ollamaChatClient = ollama;
        this.openaiChatClient = openAi;
    }
     */

    public String chatWithOllama(String prompt){
        return ollamaChatClient.prompt()
                .user(prompt)
                .call()
                .content()+" : ollama bro";
    }

    public String chatWithOpenAI(String prompt){
        return openaiChatClient.prompt()
                .user(prompt)
                .call()
                .content()+" : openai bro";
    }
}
