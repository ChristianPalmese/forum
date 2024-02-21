package forum.forum.Controller;

import forum.forum.Controller.DTO.MessageDTO;
import forum.forum.Service.MessageService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class MessageController {
    /*5 comandi base via rest:
    1 getAll
    2 getById
    3 create creazione nuova entita
    4 modifica di un entita gia esistente
    5 cancellazione di una entita
     */

    @Autowired
    MessageService messageService;

    @GetMapping("/message")
    @ResponseBody
    public List<MessageDTO> getAllMessage(){
        log.info("è stato richiesto il comando getAllMessage");
        return messageService.getAllMessage();
    }

    @GetMapping("/message/{id}")
    @ResponseBody
    public MessageDTO findMessageByID(@PathVariable(required = true) int id){
        log.info("è stato richiesto il comando findMessageByID");
        return messageService.findMessageByID(id);
    }

    @PostMapping("/message")
    @ResponseBody
    public MessageDTO postMessage(@RequestBody @Valid MessageDTO messageDTO){
        log.info("è stato richiesto il comando postMassage");
        return messageService.postMessage(messageDTO);
    }


    @PutMapping("/message/{id}")
    @ResponseBody
    public boolean modificaMessage(@PathVariable int id, @RequestBody @Valid MessageDTO messageDTO){
        log.info("è stata richiesta la modifica del message con id {} ",id);
        Boolean aBoolean= messageService.modificaMessage(id,messageDTO);
        log.info("la modifica è avvenuta : {} ", aBoolean);
        return aBoolean;
    }

    @DeleteMapping("/message/{id}")
    @ResponseBody
    public boolean deletMessage(@PathVariable int id){
        log.info("è stata richiesta la cancellasione del message con id {} ", id);
        Boolean aBoolean=messageService.deleteMessage(id);
        log.info("la cancellazione è avvenuta : {} ", aBoolean);
        return aBoolean;

    }

    @PutMapping("/message/like/{id}")
    @ResponseBody
    public boolean modificaLikes(@PathVariable int id, @RequestBody @Valid MessageDTO messageDTO){
        log.info("è stata richiesta la modifica dei like con id {} ",id);
        Boolean aBoolean= messageService.modificaLikes(id,messageDTO);
        log.info("la modifica è avvenuta : {} ", aBoolean);
        return aBoolean;
    }







}
