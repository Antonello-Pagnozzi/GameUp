package com.jdk.GameUp.Controller;

import com.jdk.GameUp.Entity.Dlc;
import com.jdk.GameUp.Entity.DlcDto;
import com.jdk.GameUp.Service.DlcService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DLC")
public class DlcController {

    private DlcService dlcService;

    public DlcController(DlcService dlcService){
        this.dlcService = dlcService;
    }

    @GetMapping("/tutti")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Dlc>> trovaTutti(){
        List<Dlc> tutti = dlcService.trovaTutti();
        if (tutti.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tutti);
    }

    @GetMapping("/trova/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Dlc> trovaPerId(@PathVariable Long id){
        return ResponseEntity.ok(dlcService.trovaPerID(id));
    }

    @PostMapping("/salva/{giocoId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Dlc> salva(@RequestBody DlcDto dlc, @PathVariable Long giocoId){
        return ResponseEntity.ok(dlcService.salvaDlc(dlc, giocoId));
    }

    @DeleteMapping("/cancella/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> cancella(@PathVariable long id){
        boolean esiste = dlcService.esistePerId(id);
        if (!esiste) {
            return ResponseEntity.notFound().build();
        }
        dlcService.cancellaDLCperId(id);
        return ResponseEntity.noContent().build(); // HTTP 204
    }
}
