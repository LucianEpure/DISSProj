package services;

import entities.Message;
import entities.User;
import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.stereotype.Service;
import repositories.MessageRepository;
import repositories.UserRepository;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    private MessageRepository messageRepository;
    private UserRepository userRepository;

    public MessageServiceImpl(MessageRepository messageRepository, UserRepository userRepository){

        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<Message> getMessages(String username) {

        User dbUser = userRepository.findByUsername(username);
        return dbUser.getMessages();
    }

    @Override
    public void sendMessage(Message message) {
        List<Message> messages;
        messageRepository.save(message);

        List<User> receivers = message.getReceivers();
        if (!receivers.isEmpty()){
            for(User user: receivers){
                User dbUser = userRepository.findByUsername(user.getUsername());
                messages = dbUser.getMessages();
                messages.add(message);
                dbUser.setMessages(messages);
                System.out.println("Added message "+ message.getTitle()+ " to user " + dbUser.getUsername());
                System.out.println("Messag "+ dbUser.getMessages().toString());
                userRepository.save(dbUser);
            }
        }
    }

    @Override
    public Message addReceiverToMessage(Message message, User user) {
        List<User> receivers = message.getReceivers();
        receivers.add(user);//
        message.setReceivers(receivers);

        return message;
    }

    @Override
    public Message createMessage(String username, String subject, String content) {
        User sender = userRepository.findByUsername(username);
        Message news = new Message();
        news.setAuthor(sender);
        news.setContent(content);
        news.setTitle(subject);
        news.setMessageDate(new Date());
        return news;
    }
}
