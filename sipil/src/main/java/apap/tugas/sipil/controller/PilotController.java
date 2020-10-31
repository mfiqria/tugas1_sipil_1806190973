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

    @Autowired
    private AkademiService akademiService;

    @Autowired
    private PenerbanganService penerbanganService;

    @Autowired
    private Pilot_PenerbanganService pilot_penerbanganService;

    @GetMapping("/")
    private String home(){
        return "home";
    }

    @GetMapping("/pilot")
    public String listPilot(Model model){
        //  Mendapatkan semua PilotModel
        List<PilotModel> listPilot = pilotService.getPilotList();

        //  Add variabel semua PilotMode ke 'listPilot untuk dirender pada thymeleaf
        model.addAttribute("listPilot", listPilot);

        //  Return view template yang ingin digunakan
        return "viewall-pilot";
    }

    @GetMapping("/pilot/tambah")
    public String addPilotFormPage(
            Model model
    )  {
        List<AkademiModel> listAkademi = akademiService.getAkademiList();
        List<MaskapaiModel> listMaskapai = maskapaiService.getMaskapaiList();
        model.addAttribute("pilot", new PilotModel());
        model.addAttribute("akademiList", listAkademi);
        model.addAttribute("maskapaiList", listMaskapai);
        return "form-add-pilot";
    }

    @PostMapping("/pilot/tambah")
    public String addPilotSubmit(
            @ModelAttribute PilotModel pilot,
            Model model
    ) {
        pilotService.addPilot(pilot);
        model.addAttribute("nip", pilot.getNip());
        return "add-pilot";
    }

    @GetMapping("/pilot/{nip}")
    private String viewPilotDetail(
            @PathVariable String nip,
            Model model
    ) {
        if (nip != null) {
            PilotModel pilot = pilotService.getPilotByNip(nip);

            model.addAttribute("pilot", pilot);

            return "view-pilot";
        }

        return "error";
    }

    @GetMapping("/pilot/ubah/{nip}")
    private String changePilotFormPage(
            @PathVariable String nip,
            Model model
    ) {
        if (nip != null) {
            PilotModel pilot = pilotService.getPilotByNip(nip);

            List<AkademiModel> listAkademi = akademiService.getAkademiList();
            List<MaskapaiModel> listMaskapai = maskapaiService.getMaskapaiList();
            model.addAttribute("akademiList", listAkademi);
            model.addAttribute("maskapaiList", listMaskapai);
            model.addAttribute("pilot", pilot);

            return "form-update-pilot";
        }
        model.addAttribute("msg", "Pilot yang ingin di ubah Tidak Ada!");

        return "error";
    }
    @PostMapping("/pilot/ubah")
    private String changePilotFormSubmit(
            @ModelAttribute PilotModel pilot,
            Model model
    ) {
        PilotModel ubahPilot = pilotService.updatePilot(pilot);
        model.addAttribute("pilot", ubahPilot);
        return "update-pilot";
    }

    @GetMapping("/pilot/delete/{nip}")
    public String deletePilot(
            @PathVariable("nip") String nip,
            Model model
    ) {
        PilotModel pilot = pilotService.getPilotByNip(nip);

        PilotModel pilotDelete = pilotService.deletePilot(pilot);

        model.addAttribute("pilot", pilotDelete);
        return "delete-pilot";
    }

}