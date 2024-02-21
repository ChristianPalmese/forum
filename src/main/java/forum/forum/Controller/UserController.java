package forum.forum.Controller;

import forum.forum.Controller.DTO.ThreadDTO;
import forum.forum.Controller.DTO.UserDTO;
import forum.forum.Service.ThreadService;
import forum.forum.Service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class UserController {
    /*5 comandi base via rest:
    1 getAll
    2 getById
    3 create creazione nuova entita
    4 modifica di un entita gia esistente
    5 cancellazione di una entita
     */

    @Autowired
    UserService userService;
    @GetMapping("/user")
    @ResponseBody
    public List<UserDTO> getAllUser(){
        log.info("è stato richiesto il comando getAllUser");
        return userService.getAllUser();
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public UserDTO findUserByID(@PathVariable(required = true) int id){
        log.info("è stato richiesto il comando findUserByID");
        return userService.findUserByID(id);
    }

    @PostMapping("/user")
    @ResponseBody
    public UserDTO postUser(@RequestBody @Valid UserDTO userDTO){
        log.info("è stato richiesto il comando postUser");
        return userService.postUser(userDTO);
    }
    @PutMapping("/user/{id}")
    @ResponseBody
    public boolean modificaUser(@PathVariable int id, @RequestBody @Valid UserDTO userDTO){
        log.info("è stata richiesta la modifica dell'user con id {} ",id);
        Boolean aBoolean=userService.modificaUser(id,userDTO);
        log.info("la modifica è avvenuta : {} ", aBoolean);
        return aBoolean;
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public boolean deletUser(@PathVariable int id){
        log.info("è stata richiesta la cancellasione dell'user con id {} ", id);
        Boolean aBoolean=userService.deleteUser(id);
        log.info("la cancellazione è avvenuta : {} ", aBoolean);
        return aBoolean;

    }




}
