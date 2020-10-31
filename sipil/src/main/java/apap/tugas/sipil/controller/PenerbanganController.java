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
public class PenerbanganController {
    @Qualifier("penerbanganServiceImpl")
    @Autowired
    private PenerbanganService penerbanganService;

    @Autowired
    private MaskapaiService maskapaiService;

    @Autowired
    private AkademiService akademiService;

    @Autowired
    private PilotService pilotService;

    @Autowired
    private Pilot_PenerbanganService pilot_penerbanganService;

    @GetMapping("/penerbangan")
    public String listPenerbangan(Model model){
        //  Mendapatkan semua PenerbanganModel
        List<PenerbanganModel> listPenerbangan = penerbanganService.getPenerbanganList();

        model.addAttribute("listPenerbangan", listPenerbangan);

        //  Return view template yang ingin digunakan
        return "viewall-penerbangan";
    }

    @GetMapping("/penerbangan/detail/{idPenerbangan}")
    private String viewPenerbanganDetail(
            @PathVariable Long idPenerbangan,
            Model model
    ) {
        if (idPenerbangan != null) {
            PenerbanganModel penerbangan = penerbanganService.getPenerbanganByIdPenerbangan(idPenerbangan);
            List<PilotModel> listPilot = pilotService.getPilotList();
            List<Pilot_PenerbanganModel> listPilot_Penerbangan = pilot_penerbanganService.getPilot_PenerbanganByPenerbangan(penerbangan);
            List<PilotModel> pilot_PenerbanganList = pilot_penerbanganService.getDaftarPilot(penerbangan);
            model.addAttribute("pilotList", listPilot);
            model.addAttribute("pilot_PenerbanganList", pilot_PenerbanganList);
            model.addAttribute("listPilotPenerbanga", listPilot_Penerbangan);
            model.addAttribute("penerbangan", penerbangan);
            model.addAttribute("standardDate", new Date());

            return "view-penerbangan";
        }

        return "error";
    }

//    @PostMapping("/penerbangan/{idPenerbangan}/pilot/tambah/")
//    private String tambahPilotPadaPenerbangan(
//            @PathVariable Long idPenerbangan,
//            Model model, String nip
//    ) {
//        PenerbanganModel penerbangan = penerbanganService.getPenerbanganByIdPenerbangan(idPenerbangan);
////            List<PilotModel> listPilot = pilotService.getPilotList();
//        PilotModel pilot = pilotService.getPilotByNip(nip);
//        model.addAttribute("pilot", pilot);
//        model.addAttribute("penerbangan", penerbangan);
//
//        return "tambah-pilot-penerbangan";
//
//    }

    @GetMapping("/penerbangan/tambah")
    public String addPenerbanganFormPage(
            Model model
    )  {
        model.addAttribute("penerbangan", new PenerbanganModel());

        return "form-add-penerbangan";
    }

    @PostMapping("/penerbangan/tambah")
    public String addPenerbanganSubmit(
            @ModelAttribute PenerbanganModel penerbangan,
            Model model
    ) {
        penerbanganService.addPenerbangan(penerbangan);
        model.addAttribute("kotaTujuan", penerbangan.getKotaTujuan());
        model.addAttribute("kotaAsal", penerbangan.getKotaAsal());
        return "add-penerbangan";
    }

    @GetMapping("/penerbangan/ubah/{idPenerbangan}")
    private String changePenerbanganFormPage(
            @PathVariable Long idPenerbangan,
            Model model
    ) {
        if (idPenerbangan != null) {
            PenerbanganModel penerbangan = penerbanganService.getPenerbanganByIdPenerbangan(idPenerbangan);

            model.addAttribute("penerbangan", penerbangan);

            return "form-update-penerbangan";
        }
        model.addAttribute("msg", "Penerbangan yang ingin di ubah Tidak Ada!");

        return "error";
    }
    @PostMapping("/penerbangan/ubah")
    private String changePenerbanganFormSubmit(
            @ModelAttribute PenerbanganModel penerbangan,
            Model model
    ) {
        PenerbanganModel ubahPenerbangan = penerbanganService.updatePenerbangan(penerbangan);
        model.addAttribute("penerbangan", ubahPenerbangan);
        return "update-penerbangan";
    }

    @GetMapping("/penerbangan/hapus/{idPenerbangan}")
    public String deletePenerbangan(
            @PathVariable("idPenerbangan") Long idPenerbangan,
            Model model) {

        if (penerbanganService.getPenerbanganByIdPenerbangan(idPenerbangan) != null) {
            PenerbanganModel penerbangan = penerbanganService.getPenerbanganByIdPenerbangan(idPenerbangan);

            PenerbanganModel penerbanganDelete = penerbanganService.deletePenerbangan(penerbangan);
            model.addAttribute("penerbangan", penerbanganDelete);


            if (penerbanganDelete != null) {
                return "delete-penerbangan";
            } else {
                model.addAttribute("penerbangan", penerbanganDelete);
                return "delete-penerbangan-error";
            }
        } else {
            PenerbanganModel penerbangan = penerbanganService.getPenerbanganByIdPenerbangan(idPenerbangan);
            model.addAttribute("penerbangan", penerbangan);
            return "delete-penerbangan-error";
        }
    }

}