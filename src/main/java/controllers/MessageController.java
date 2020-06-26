package controllers;

import converters.MessageConverter;
import dtos.MessageDto;
import entities.Message;
import org.springframework.web.bind.annotation.*;
import services.MessageService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {

    private MessageConverter messageConverter;
    private MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageConverter = new MessageConverter();
        this.messageService = messageService;
    }

    @GetMapping("/messages/{username}")
    public List<MessageDto> getAllMessagesForUser(@PathVariable String username) {
        List<Message> messages = messageService.getMessages(username);
        List<MessageDto> displayedMessages = new ArrayList<>();
        for(Message message: messages){
            displayedMessages.add(messageConverter.convertToDto(message));
        }
        return displayedMessages;
    }
}
