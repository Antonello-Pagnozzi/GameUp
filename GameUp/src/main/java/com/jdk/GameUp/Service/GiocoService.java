package com.jdk.GameUp.Service;

import com.jdk.GameUp.Entity.Genere;
import com.jdk.GameUp.Entity.Gioco;
import com.jdk.GameUp.Repository.GiocoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GiocoService {

    private final GiocoRepository giocoRepository;

    public GiocoService(GiocoRepository giocoRepository){
        this.giocoRepository = giocoRepository;
    }

    //metodi
    public List<Gioco> trovaTutti(){
        return giocoRepository.findAll();
    }

    public List<Gioco> trovaPerGenere(Genere genere){
        List<Gioco> tutti = giocoRepository.findAll();
        List<Gioco> risultato = new ArrayList<>();
        for(Gioco gioco : tutti){
            if (gioco.getGenere().contains(genere)){
                risultato.add(gioco);
            }
        }
        return risultato;
    }

    public Gioco salvaGioco(Gioco gioco){
        return giocoRepository.save(gioco);
    }

    public Gioco trovaPerId(Long id){
        Optional<Gioco> trova = giocoRepository.findById(id);
        if (trova.isEmpty()){
            throw new EntityNotFoundException("ERRORE! Nessun gioco con questo ID!");
        }
        return trova.get();
    }

    public List<Gioco> trovaPerNome(String nome){
        List<Gioco> tutti = giocoRepository.findAll();
        List<Gioco> risultato = new ArrayList<>();
        for (Gioco gioco: tutti){
            if (gioco.getNome().toUpperCase().contains(nome.toUpperCase())){
                risultato.add(gioco);
            }
        }
        return risultato;
    }

    public void cancellaPerId(Long id){
        giocoRepository.deleteById(id);
    }



    public boolean esistePerId(Long id) {
        return giocoRepository.existsById(id);
    }

}
