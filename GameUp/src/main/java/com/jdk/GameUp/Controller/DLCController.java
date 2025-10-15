package com.jdk.GameUp.Controller;

import com.jdk.GameUp.Entity.DLC;
import com.jdk.GameUp.Service.DLCService;
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
    public List<DLC> trovaTutti(){
        return dlcService.trovaTutti();
    }

    @GetMapping("/trova/{id}")
    public DLC trovaPerId(@PathVariable Long id){
        return dlcService.trovaPerID(id);
    }

    @PostMapping("/salva")
    public DLC salva(@RequestBody DLC dlc){
        return dlcService.salvaDLC(dlc);
    }

    @DeleteMapping("/cancella/{id}")
    public String cancella(@PathVariable long id){
        dlcService.cancellaDLCperId(id);
        return "DLC Cancellato correttamente!";
    }
}
