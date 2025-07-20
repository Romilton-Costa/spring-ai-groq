package code.programing.ai.controller;



import org.springframework.ai.chat.model.ChatModel;


import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/openai")
public class groqcontroller{
    private final ChatModel chatmodel;
    public groqcontroller(OpenAiChatModel chatmodel){
        this.chatmodel=chatmodel;
    }
     @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){
        String prompt = "voce é meu engenheiro de software ";
        String fullMessage = prompt + message; 


        String response = chatmodel.call(fullMessage);

        return ResponseEntity.ok(response);
    }

   
    
}