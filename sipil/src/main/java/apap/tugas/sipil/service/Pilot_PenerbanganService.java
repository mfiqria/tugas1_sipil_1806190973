package apap.tugas.sipil.service;

import apap.tugas.sipil.model.PenerbanganModel;
import apap.tugas.sipil.model.PilotModel;
import apap.tugas.sipil.model.Pilot_PenerbanganModel;

import java.util.List;

public interface Pilot_PenerbanganService {
    Pilot_PenerbanganModel getPilot_PenerbanganByIdPilot_Penerbangan(Long idPilot_Penerbangan);

    Pilot_PenerbanganModel getPilot_Penerbangan(PilotModel pilot, PenerbanganModel penerbangan);

    Pilot_PenerbanganModel addPilot_Penerbangan(Pilot_PenerbanganModel pilot_penerbangan);

    List<Pilot_PenerbanganModel> getPilot_PenerbanganByPenerbangan(PenerbanganModel penerbangan);
    List<PilotModel> getDaftarPilot(PenerbanganModel penerbangan);
}
