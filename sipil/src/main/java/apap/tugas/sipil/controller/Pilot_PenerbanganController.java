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
public class Pilot_PenerbanganController {
    @Qualifier("pilot_PenerbanganServiceImpl")
    @Autowired
    private Pilot_PenerbanganService pilot_penerbanganService;

    @Autowired
    private PilotService pilotService;

    @Autowired
    private MaskapaiService maskapaiService;

    @Autowired
    private AkademiService akademiService;

    @Autowired
    private PenerbanganService penerbanganService;

    @PostMapping("/penerbangan/{idPenerbangan}/pilot/tambah")
    public String tambahPilotPadaPenerbangan(
            @ModelAttribute Pilot_PenerbanganModel pilot_penerbanganModel,
            Model model
    ) {
        Pilot_PenerbanganModel pilotpenerbangan = pilot_penerbanganService.getPilot_Penerbangan(
                pilot_penerbanganModel.getPilotModel(),
                pilot_penerbanganModel.getPenerbanganModel());
        PilotModel pilot = pilot_penerbanganModel.getPilotModel();
        PenerbanganModel penerbangan = pilot_penerbanganModel.getPenerbanganModel();
        if(pilotpenerbangan == null){
            pilot_penerbanganService.addPilot_Penerbangan(pilot_penerbanganModel);
            model.addAttribute("pilot", pilot);
            model.addAttribute("penerbangan", penerbangan);
            return "tambah-pilot-penerbangan";
        }
        else{
            return "home";
        }
    }

}