package com.jdk.GameUp.Controller;

import com.jdk.GameUp.Entity.Genere;
import com.jdk.GameUp.Entity.Gioco;
import com.jdk.GameUp.Service.GiocoService;
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
    public List<Gioco> trovaTutti(){
        return giocoService.trovaTutti();
    }

    @GetMapping("/{genere}")
    @PreAuthorize("hasRole('USER')")
    public List<Gioco> trovaPerGenere(@PathVariable Genere genere){
        return giocoService.trovaPerGenere(genere);
    }

    @PostMapping("/salva")
    @PreAuthorize("hasRole('ADMIN')")
    public Gioco salva(@RequestBody Gioco gioco){
        return giocoService.salvaGioco(gioco);
    }

    @GetMapping("/trovaid/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Gioco trovaPerId(@PathVariable Long id){
        return giocoService.trovaPerId(id);
    }

    @GetMapping("/trova/{nome}")
    @PreAuthorize("hasRole('USER')")
    public List<Gioco> trovaPerNome(@PathVariable String nome){
        return giocoService.trovaPerNome(nome);
    }

    @DeleteMapping("/cancella/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void cancella(@PathVariable Long id){
        giocoService.cancellaPerId(id);
    }
}
