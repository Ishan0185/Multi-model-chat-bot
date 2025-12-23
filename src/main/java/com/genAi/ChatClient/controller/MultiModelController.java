package com.genAi.ChatClient.controller;

import com.genAi.ChatClient.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class MultiModelController {

private final ChatService chatService;

public MultiModelController(ChatService chatService){
    this.chatService = chatService;
}

    @GetMapping("/ollama")
    public String chatWithOllama(@RequestParam String prompt) {
        return chatService.chatWithOllama(prompt);
    }

    @GetMapping("/openai")
    public String chatWithOpenAI(@RequestParam String prompt) {
        return chatService.chatWithOpenAI(prompt);
    }
}