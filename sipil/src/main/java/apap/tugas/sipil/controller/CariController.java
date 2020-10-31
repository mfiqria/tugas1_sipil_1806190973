package apap.tugas.sipil.controller;

import apap.tugas.sipil.model.PilotModel;
import apap.tugas.sipil.model.Pilot_PenerbanganModel;
import apap.tugas.sipil.model.PenerbanganModel;
import apap.tugas.sipil.model.MaskapaiModel;
import apap.tugas.sipil.model.AkademiModel;
import apap.tugas.sipil.service.PilotService;
import apap.tugas.sipil.service.Pilot_PenerbanganService;
import apap.tugas.sipil.service.PenerbanganService;
import apap.tugas.sipil.service.MaskapaiService;
import apap.tugas.sipil.service.AkademiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class CariController {
    @Qualifier("pilotServiceImpl")
    @Autowired
    private PilotService pilotService;

    @Autowired
    private MaskapaiService maskapaiService;

    @Autowired
    private AkademiService akademiService;

    @Autowired
    private PenerbanganService penerbanganService;

    @Autowired
    private Pilot_PenerbanganService pilot_penerbanganService;

    @GetMapping("/cari/pilot")
    public String cariPilot(
            Model model){
        long id = 0;
        model.addAttribute("id",id);
        int temp = 0;
        model.addAttribute("temp",temp);
        List<AkademiModel> listAkademi = akademiService.getAkademiList();
        List<MaskapaiModel> listMaskapai = maskapaiService.getMaskapaiList();
        model.addAttribute("listAkademi", listAkademi);
        model.addAttribute("listMaskapai", listMaskapai);
        return "cari-pilot";
    }

    @GetMapping("/cari/pilot/penerbangan-terbanyak")
    public String cariPilotPenerbanganTerbanyak(
            Model model){
        List<MaskapaiModel> listMaskapai = maskapaiService.getMaskapaiList();
        model.addAttribute("listMaskapai", listMaskapai);
        return "cari-pilot-penerbangan-terbanyak";
    }

}