package com.jdk.GameUp.Controller;

import com.jdk.GameUp.Entity.DLC;
import com.jdk.GameUp.Service.DLCService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DLC")
public class DLCController {

    private DLCService dlcService;

    public DLCController(DLCService dlcService){
        this.dlcService = dlcService;
    }

    @GetMapping("/tutti")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<DLC>> trovaTutti(){
        List<DLC> tutti = dlcService.trovaTutti();
        if (tutti.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tutti);
    }

    @GetMapping("/trova/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<DLC> trovaPerId(@PathVariable Long id){
        return ResponseEntity.ok(dlcService.trovaPerID(id));
    }

    @PostMapping("/salva")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DLC> salva(@RequestBody DLC dlc){
        return ResponseEntity.ok(dlcService.salvaDLC(dlc));
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
