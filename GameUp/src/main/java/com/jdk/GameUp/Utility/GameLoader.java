package com.jdk.GameUp.Utility;

import com.jdk.GameUp.Entity.*;
import com.jdk.GameUp.Service.DlcService;
import com.jdk.GameUp.Service.GiocoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class GameLoader implements CommandLineRunner {

    private GiocoService giocoService;
    private DlcService dlcService;

    public GameLoader(GiocoService giocoService, DlcService dlcService){
        this.giocoService = giocoService;
        this.dlcService = dlcService;
    }

    @Override
    public void run(String... args) throws Exception {
        //crea gioco 1
        Set<Genere> strGeneri = new HashSet<>();
        strGeneri.add(Genere.PICCHIADURO);
        Set<Dlc> strDlc = new HashSet<>();
        Set<Piattaforma>strPiatt = new HashSet<>();
        strPiatt.add(Piattaforma.PC);
        strPiatt.add(Piattaforma.PLAYSTATION_5);
        strPiatt.add(Piattaforma.PLAYSTATION_4);
        strPiatt.add(Piattaforma.XBOX_SERIES_X);
        strPiatt.add(Piattaforma.XBOX_SERIES_S);
        strPiatt.add(Piattaforma.SWITCH);
        Gioco streetFighter = new Gioco("Street Fighter 5", 2021, "Capcom");
        streetFighter.setGenere(strGeneri);
        streetFighter.setDlc(strDlc);
        streetFighter.setPiattaforme(strPiatt);
        giocoService.salvaGiocoRunner(streetFighter);

        //crea gioco 2
        Set<Genere> bg3Generi = new HashSet<>();
        bg3Generi.add(Genere.GDR);
        Set<Dlc> bg3Dlc = new HashSet<>();
        Set<Piattaforma>bg3Piatt = new HashSet<>();
        bg3Piatt.add(Piattaforma.PC);
        bg3Piatt.add(Piattaforma.PLAYSTATION_5);
        bg3Piatt.add(Piattaforma.PLAYSTATION_4);
        bg3Piatt.add(Piattaforma.XBOX_SERIES_X);
        bg3Piatt.add(Piattaforma.XBOX_SERIES_S);
        Gioco baldursGate = new Gioco("Baldur's Gate 3", 2023, "Larian Studios");
        baldursGate.setGenere(bg3Generi);
        baldursGate.setDlc(bg3Dlc);
        baldursGate.setPiattaforme(bg3Piatt);
        giocoService.salvaGiocoRunner(baldursGate);

        //crea gioco 3
        Set<Genere> wowGeneri = new HashSet<>();
        wowGeneri.add(Genere.GDR);
        wowGeneri.add(Genere.MMO);
        Set<Dlc> wowDlc = new HashSet<>();
        Set<Piattaforma>wowPiatt = new HashSet<>();
        wowPiatt.add(Piattaforma.PC);
        Gioco warcraft = new Gioco("World of Warcraft", 2004, "Blizzard Entertainment");
        warcraft.setGenere(wowGeneri);
        warcraft.setDlc(wowDlc);
        warcraft.setPiattaforme(wowPiatt);
        giocoService.salvaGiocoRunner(warcraft);

        //crea dlc
        DlcDto dlc = new DlcDto();
        dlc.setNomeDlc("The Burning Crusade");
        dlc.setAnnoUscita(2006);
        dlcService.salvaDlc(dlc, 3L);
    }
}
