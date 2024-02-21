package forum.forum.Service;

import forum.forum.Controller.DTO.ThreadDTO;
import forum.forum.Controller.DTO.UserDTO;
import forum.forum.Exeption.ThreadNotFound;
import forum.forum.Exeption.UserNotFound;
import forum.forum.Modello.Thread;
import forum.forum.Modello.User;
import forum.forum.Repository.ThreadRepo;
import forum.forum.Repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepo userRepo;


    /**
     * Metodo per ottenere tutti gli utenti
     * @return List<UserDTO>
     */

    public List<UserDTO> getAllUser(){
        List<User> userList= userRepo.findAll();
        List<UserDTO> userDTOList= new ArrayList<>();
        for(User user:userList){
            userDTOList.add(trasformazioneUserinUserDTO(user));
        }
        return userDTOList;
    }

    /**
     * Metodo per trovare user per ID
     * @param id : identifica user che si sta puntando
     * @return UserDTO
     */
    public UserDTO findUserByID(int id) {
        User user= userRepo.findById(id).orElseThrow(UserNotFound::new);
        return trasformazioneUserinUserDTO(user);
    }

    /**
     * Metodo per aggiungere un nuovo User
     * @param userDTO : contiene le informazioni per l'inserimento del'User
     * @return UserDTO
     */
    public UserDTO postUser(UserDTO userDTO) {
        User user = new User(userDTO.getUsername(),userDTO.getNomeCompleto());
        user=userRepo.save(user);
        return trasformazioneUserinUserDTO(user);
    }

    /**
     * Metodo per modificare dell'user esistente
     * @param id : identifica l'user che si sta puntando
     * @param userDTO : contiene le informazioni per la modifica dell'user
     * @return boolean viene ritornato true quando il metodo viene eseguito altrimenti ritorna false
     */
    public boolean modificaUser(int id, UserDTO userDTO) {
        User user = userRepo.findById(id).orElseThrow(UserNotFound::new);
        user.setUsername(userDTO.getUsername());
        user.setNomeCompleto(userDTO.getNomeCompleto());
        return true;
    }


    /** Metodo per eliminare un user per ID
     *
     * @param id l'id dell'utente da cancellare
     * @return un booleano che vale true se la cancellazione è avvenuta, false nel caso contrario
     */
    public boolean deleteUser(int id) {
        User user = userRepo.findById(id).orElseThrow(UserNotFound::new);
        userRepo.deleteById(id);
        return true;
    }


    public UserDTO trasformazioneUserinUserDTO(User user){
        UserDTO userDTO= new UserDTO(user.getId(),user.getUsername(),user.getNomeCompleto());
        return userDTO;
    }


}
