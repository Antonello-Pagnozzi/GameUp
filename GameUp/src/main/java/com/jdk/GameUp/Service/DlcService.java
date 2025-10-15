package com.jdk.GameUp.Service;

import com.jdk.GameUp.Entity.Dlc;
import com.jdk.GameUp.Entity.DlcDto;
import com.jdk.GameUp.Entity.Gioco;
import com.jdk.GameUp.Repository.DlcRepository;
import com.jdk.GameUp.Repository.GiocoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DlcService {

    private DlcRepository dlcRepository;
    private GiocoRepository giocoRepository;

    public DlcService(DlcRepository dlcRepository, GiocoRepository giocoRepository){
        this.dlcRepository = dlcRepository;
        this.giocoRepository = giocoRepository;
    }

    public List<Dlc> trovaTutti(){
        return dlcRepository.findAll();
    }

    public Dlc trovaPerID(Long id) throws EntityNotFoundException {
        Optional<Dlc> risultato = dlcRepository.findById(id);
        if (risultato.isEmpty()){
            throw new EntityNotFoundException("ERRORE! Nessun DLC con questo ID!");
        }
        return risultato.get();
    }

    //public Dlc salvaDLC(Dlc dlc){return dlcRepository.save(dlc);}

    public void cancellaDLCperId(Long id){
        dlcRepository.deleteById(id);
    }

    public boolean esistePerId(Long id) {
        return dlcRepository.existsById(id);
    }

    public Dlc salvaDlc(DlcDto dto, Long giocoId){
        Dlc dlc = new Dlc();
        dlc.setNomeDlc(dto.getNomeDlc());
        dlc.setAnnoUscita(dto.getAnnoUscita());
        Optional<Gioco> gioco = giocoRepository.findById(giocoId);
        if (gioco.isEmpty()){
            throw new EntityNotFoundException("Non è possibile assegnare il DLC al gioco con ID "+ giocoId);
        }
        Gioco giocoDlc = gioco.get();
        dlc.setGiocoDiRiferimento(giocoDlc);
        return dlcRepository.save(dlc);
    }

}
