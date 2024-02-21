package forum.forum.Controller;

import forum.forum.Controller.DTO.MessageDTO;
import forum.forum.Controller.DTO.StatisticheArgomentiDTO;
import forum.forum.Controller.DTO.ThreadDTO;
import forum.forum.Service.ThreadService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class ThreadController {
     /*5 comandi base via rest:
    1 getAll
    2 getById
    3 create creazione nuova entita
    4 modifica di un entita gia esistente
    5 cancellazione di una entita
     */

    @Autowired
    ThreadService threadService;
    @GetMapping("/thread")
    @ResponseBody
    public List<ThreadDTO> getAllThread(){
        log.info("è stato richiesto il comando getAllThread");
        return threadService.getAllThread();
    }

    @GetMapping("/thread/{id}")
    @ResponseBody
    public ThreadDTO findThreadByID(@PathVariable(required = true) int id){
        log.info("è stato richiesto il comando findThreadByID");
        return threadService.findThreadByID(id);
    }

    @PostMapping("/thread")
    @ResponseBody
    public ThreadDTO postThread(@RequestBody @Valid ThreadDTO threadDTO){
        log.info("è stato richiesto il comando postThread");
        return threadService.postThread(threadDTO);
    }
    @PutMapping("/thread/{id}")
    @ResponseBody
    public boolean modificaThread(@PathVariable int id, @RequestBody @Valid ThreadDTO threadDTO){
        log.info("è stata richiesta la modifica del thread con id {} ",id);
        Boolean aBoolean=threadService.modificaThread(id,threadDTO);
        log.info("la modifica è avvenuta : {} ", aBoolean);
        return aBoolean;
    }

    @DeleteMapping("/thread/{id}")
    @ResponseBody
    public boolean deletThread(@PathVariable int id){
        log.info("è stata richiesta la cancellasione del thread con id {} ", id);
        Boolean aBoolean=threadService.deleteThread(id);
        log.info("la cancellazione è avvenuta : {} ", aBoolean);
        return aBoolean;

    }

    @GetMapping("/thread/findByArgomento")
    @ResponseBody
    public List<ThreadDTO> findAllThreadByArgomento(@RequestParam(value = "nomeArgomento")String nomeArgomento){
        log.info("è stato richiesto il comando  findAllThreadByArgomento");
        return threadService.findAllThreadByArgomento(nomeArgomento);
    }

    @GetMapping("/thread/messaggio/{id}")
    @ResponseBody
    public List<MessageDTO> findThreadAndMessageByID(@PathVariable(required = true) int id){
        log.info("è stato richiesto il comando findThreadAndMessageByID");
        return threadService.findThreadMessageByID(id);
    }

    @GetMapping("/statistiche")
    @ResponseBody
    public StatisticheArgomentiDTO getAllStatistiche(){
        log.info("è stato richiesto il comando getAllStatistiche");
        return threadService.findStatisticheArgomento();
    }



}
