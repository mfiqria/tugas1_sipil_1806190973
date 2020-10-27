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
public class PilotController {
    @Qualifier("pilotServiceImpl")
    @Autowired
    private PilotService pilotService;

    @Autowired
    private MaskapaiService maskapaiService;
    private AkademiService akademiService;
    private PenerbanganService penerbanganService;
    private Pilot_PenerbanganService pilot_penerbanganService;

    @GetMapping("/")
    private String home(){
        return "home";
    }

}