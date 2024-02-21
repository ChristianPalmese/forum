package forum.forum.Service;

import forum.forum.Controller.DTO.MessageDTO;
import forum.forum.Exeption.MessageNotFound;
import forum.forum.Modello.Message;
import forum.forum.Repository.MessageRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MessageService {
    @Autowired
    MessageRepo messageRepo;

    /**
     * Metodo per ottenere tutti i message
     * @return List<MessageDTO>
     */

    public List<MessageDTO> getAllMessage(){
        List<Message> messageList=messageRepo.findAll();
        List<MessageDTO> messageDTOS= new ArrayList<>();
        for(Message message:messageList){
            messageDTOS.add(trasformazioneMessageInMessageDTO(message));
        }
        return messageDTOS;
    }

    /**
     * Metodo per trovare message per ID
     * @param id : identifica message che si sta puntando
     * @return MessageDTO
     */
    public MessageDTO findMessageByID(int id) {
        // Cerca un message nel repository tramite ID
        Message message= messageRepo.findById(id).orElseThrow(MessageNotFound::new);
        return trasformazioneMessageInMessageDTO(message);
    }

    /**
     * Metodo per aggiungere un nuovo message
     * @param messageDTO : contiene le informazioni per l'inserimento del message
     * @return MessageDTO
     */
    public MessageDTO postMessage(MessageDTO messageDTO) {
        Message message = new Message(messageDTO.getTesto(),messageDTO.getDataInvio(), messageDTO.getLike());
        message=messageRepo.save(message);
        return trasformazioneMessageInMessageDTO(message);
    }

    /**
     * Metodo per modificare un message esistente
     * @param id : identifica il message che si sta puntando
     * @return boolean viene ritornato true quando il metodo viene eseguito altrimenti ritorna false
     */
    public boolean modificaMessage(int id, MessageDTO messageDTO) {
           Message message= messageRepo.findById(id).orElseThrow(MessageNotFound::new);
           message.setTesto(messageDTO.getTesto());
           message.setDataInvio(message.getDataInvio());
           message.setNumeroLikeRicevuti(messageDTO.getLike());

            return true;
        }


    /** Metodo per eliminare un message per ID
     *
     * @param id l'id dell'utente da cancellare
     * @return un booleano che vale true se la cancellazione è avvenuta, false nel caso contrario
     */
    public boolean deleteMessage(int id) {
        Message message = messageRepo.findById(id).orElseThrow(MessageNotFound::new);
        messageRepo.deleteById(id);
        return true;
    }


    /** Metodo per modificare un message per ID
     *
     * @param id l'id dei like che si sta puntando
     * @return un booleano che vale true se la modifica è avvenuta, false nel caso contrario
     */
    public boolean modificaLikes(int id, MessageDTO messageDTO) {
        Message message= messageRepo.findById(id).orElseThrow(MessageNotFound::new);
        message.setNumeroLikeRicevuti(messageDTO.getLike());
        return true;
    }














    public MessageDTO trasformazioneMessageInMessageDTO(Message message){
        MessageDTO messageDTO= new MessageDTO(message.getId(), message.getTesto(), message.getDataInvio(), message.getNumeroLikeRicevuti());
        return messageDTO;
    }
}
