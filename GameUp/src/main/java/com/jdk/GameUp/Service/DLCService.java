package com.jdk.GameUp.Service;

import com.jdk.GameUp.Entity.DLC;
import com.jdk.GameUp.Entity.Gioco;
import com.jdk.GameUp.Repository.DLCRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DLCService {

    private DLCRepository dlcRepository;

    public DLCService(DLCRepository dlcRepository){
        this.dlcRepository = dlcRepository;
    }

    public List<DLC> trovaTutti(){
        return dlcRepository.findAll();
    }

    public DLC trovaPerID(Long id) throws EntityNotFoundException {
        Optional<DLC> risultato = dlcRepository.findById(id);
        if (risultato.isEmpty()){
            throw new EntityNotFoundException("ERRORE! Nessun DLC con questo ID!");
        }
        return risultato.get();
    }

    public Set<DLC> trovaPerGioco(Gioco gioco){
        return gioco.getDlc();
    }

    public DLC salvaDLC(DLC dlc){
        return dlcRepository.save(dlc);
    }

    public void cancellaDLCperId(Long id){
        dlcRepository.deleteById(id);
    }

}
