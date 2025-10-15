package com.jdk.GameUp.Controller;

import com.jdk.GameUp.Entity.Genere;
import com.jdk.GameUp.Entity.Gioco;
import com.jdk.GameUp.Service.GiocoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/giochi")
public class GiocoController {

    private GiocoService giocoService;

    public GiocoController(GiocoService giocoService){
        this.giocoService = giocoService;
    }

    @GetMapping("/tutti")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Gioco>> trovaTutti(){
        List<Gioco> tutti = giocoService.trovaTutti();
        if (tutti.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tutti);
    }

    @GetMapping("/{genere}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Gioco>> trovaPerGenere(@PathVariable Genere genere){
        List<Gioco> tutti = giocoService.trovaPerGenere(genere);
        if (tutti.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tutti);
    }

    @PostMapping("/salva")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Gioco> salva(@RequestBody Gioco gioco){
        return ResponseEntity.ok(giocoService.salvaGioco(gioco));
    }

    @GetMapping("/trovaid/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Gioco> trovaPerId(@PathVariable Long id){
        return ResponseEntity.ok(giocoService.trovaPerId(id));
    }

    @GetMapping("/trova/{nome}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Gioco>> trovaPerNome(@PathVariable String nome){
        List<Gioco> tutti = giocoService.trovaPerNome(nome);
        if (tutti.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tutti);
    }

    @DeleteMapping("/cancella/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> cancella(@PathVariable Long id) {
        boolean esiste = giocoService.esistePerId(id);
        if (!esiste) {
            return ResponseEntity.notFound().build();
        }
        giocoService.cancellaPerId(id);
        return ResponseEntity.noContent().build(); // HTTP 204
    }
}
