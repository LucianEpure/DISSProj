package controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import converters.MessageConverter;
import dtos.MessageDto;
import entities.Message;
import entities.User;
import org.springframework.web.bind.annotation.*;
import services.MessageService;
import services.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {

    private MessageConverter messageConverter;
    private MessageService messageService;
    private UserService userService;

    public MessageController(MessageService messageService, UserService userService){
        this.messageConverter = new MessageConverter();
        this.messageService = messageService;
        this.userService = userService;
    }

    @JsonIgnore
    @GetMapping("/messages/{username}")
    public List<MessageDto> getAllMessagesForUser(@PathVariable String username) {
        List<Message> messages = messageService.getMessages(username);
        List<MessageDto> displayedMessages = new ArrayList<>();
        for(Message message: messages){
            displayedMessages.add(messageConverter.convertToDto(message));
        }
        return displayedMessages;
    }

//    @PostMapping("/sendNews")
//    public void sendNews(@RequestBody String username) {
//        System.out.println("User " + username);
////        Message message = messageService.createMessage(username, subject, content);
////        List<User> users = userService.getUsers();
////        List<User> receivers = new ArrayList<>();
////        message.setReceivers(receivers);
////        Message finalMessage = messageService.addReceiverToMessage(message, message.getAuthor());
////        if (users != null) {
////            for (User u:users) {
////                finalMessage = messageService.addReceiverToMessage(finalMessage,u);
////            }
////        }
////        messageService.sendMessage(finalMessage);
//    }
}
