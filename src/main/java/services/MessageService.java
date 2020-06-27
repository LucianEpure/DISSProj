package services;

import entities.Message;
import entities.User;

import java.util.List;

public interface MessageService {

    public List<Message> getMessages(String username);

    public void sendMessage(Message message);

    public Message addReceiverToMessage(Message message, User user);

    public Message createMessage(String username, String subject, String content);
}
