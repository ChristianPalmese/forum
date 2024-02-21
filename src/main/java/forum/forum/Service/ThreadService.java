package forum.forum.Service;

import forum.forum.Controller.DTO.MessageDTO;
import forum.forum.Controller.DTO.StatisticheArgomentiDTO;
import forum.forum.Controller.DTO.ThreadDTO;
import forum.forum.Exeption.ThreadNotFound;
import forum.forum.Modello.Message;
import forum.forum.Modello.Thread;
import forum.forum.Repository.MessageRepo;
import forum.forum.Repository.ThreadRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class ThreadService {
    @Autowired
    ThreadRepo threadRepo;

    @Autowired
    MessageRepo messageRepo;


    /**
     * Metodo per ottenere tutti i thread
     * @return List<ThreadDTO>
     */

    public List<ThreadDTO> getAllThread(){
        List<Thread> threadList= threadRepo.findAll();
        List<ThreadDTO> threadDTOList= new ArrayList<>();
        for(Thread thread:threadList){
            threadDTOList.add(trasformaThreadInThreadDTO(thread));
        }
        return threadDTOList;
    }

    /**
     * Metodo per trovare thread per ID
     * @param id : identifica thread che si sta puntando
     * @return ThreadDTO
     */
    public ThreadDTO findThreadByID(int id) {
        Thread thread= threadRepo.findById(id).orElseThrow(ThreadNotFound::new);
        return trasformaThreadInThreadDTO(thread);
    }

    /**
     * Metodo per aggiungere un nuovo thread
     * @param threadDTO : contiene le informazioni per l'inserimento del thread
     * @return ThreadDTO
     */
    public ThreadDTO postThread(ThreadDTO threadDTO) {
        Thread thread = new Thread(threadDTO.getTitolo(),threadDTO.getDataCreazione(),threadDTO.getArgomento());
        thread=threadRepo.save(thread);
        return trasformaThreadInThreadDTO(thread);
    }

    /**
     * Metodo per modificare un thread esistente
     * @param id : identifica il thread che si sta puntando
     * @param threadDTO : contiene le informazioni per la modifica del thread
     * @return boolean viene ritornato true quando il metodo viene eseguito altrimenti ritorna false
     */
    public boolean modificaThread(int id, ThreadDTO threadDTO) {
        Thread thread = threadRepo.findById(id).orElseThrow(ThreadNotFound::new);
        thread.setTitolo(threadDTO.getTitolo());
        thread.setArgomento(threadDTO.getArgomento());
        thread.setDataCreazione(threadDTO.getDataCreazione());
        return true;
    }


    /** Metodo per eliminare un thread per ID
     *
     * @param id l'id dell'utente da cancellare
     * @return un booleano che vale true se la cancellazione è avvenuta, false nel caso contrario
     */
    public boolean deleteThread(int id) {
       Thread thread = threadRepo.findById(id).orElseThrow(ThreadNotFound::new);
        threadRepo.deleteById(id);
        return true;
    }


    /** Metodo per trovare Thread per argomento
     * @param nomeArgomento identifica l'argomento che si sta puntando
     * @return List<ThreadDTO> : la lista contiene tutti i thread che hanno nomeArgomento
     */

    public List<ThreadDTO> findAllThreadByArgomento (String nomeArgomento){
        List<Thread> threadList = threadRepo.findAllByArgomentoOrderByDataCreazioneDesc(nomeArgomento);
        List<ThreadDTO> threadDTOList= new ArrayList<>();
        for(Thread thread:threadList){
            threadDTOList.add(trasformaThreadInThreadDTO(thread));
        }
        return threadDTOList;
    }

    public List<MessageDTO> findThreadMessageByID(int id){
        List<Message> messageList=messageRepo.findAllByThreadAppartenenza(id);
        List<MessageDTO> messageDTOS= new ArrayList<>();
        for(Message message:messageList){
            messageDTOS.add(trasformazioneMessageInMessageDTO(message));
        }
        return messageDTOS;
    }


    /** Metodo per trovare le statistiche per argomento
     * @return StatisticheArgomentiDTO: continete un hashMap con chiave il nome dell'argomento
     * e il valore che è il numero delle volte che persiste
     */
    public StatisticheArgomentiDTO findStatisticheArgomento(){
            List<Thread> listaThread = threadRepo.findAll();
            HashMap<String, Integer> conteggio = new HashMap<>();
            for (Thread thread : listaThread) {
                String argomento = thread.getArgomento();
                conteggio.put(argomento, conteggio.getOrDefault(argomento, 0) + 1);
            }
            StatisticheArgomentiDTO statisticheArgomentiDTO = new StatisticheArgomentiDTO();
            statisticheArgomentiDTO.setHashMap(conteggio);
            return statisticheArgomentiDTO;
    }







    public MessageDTO trasformazioneMessageInMessageDTO(Message message){
        MessageDTO messageDTO= new MessageDTO(message.getId(), message.getTesto(), message.getDataInvio(), message.getNumeroLikeRicevuti());
        return messageDTO;
    }

    public ThreadDTO trasformaThreadInThreadDTO(Thread thread){
        ThreadDTO threadDTO= new ThreadDTO(thread.getId(),thread.getTitolo(),thread.getDataCreazione(),thread.getArgomento());
        return threadDTO;
    }
}
