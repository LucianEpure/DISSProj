package converters;

import dtos.MessageDto;
import entities.Message;

public class MessageConverter {

    public MessageDto convertToDto(Message message){
        MessageDto messageDto = new MessageDto();
        messageDto.setTitle(message.getTitle());
        messageDto.setContent(message.getContent());
        return messageDto;
    }
}
