package apap.tugas.sipil.service;

import apap.tugas.sipil.model.PenerbanganModel;
import apap.tugas.sipil.model.PilotModel;

import java.util.List;

public interface PenerbanganService {
    PenerbanganModel getPenerbanganByIdPenerbangan(Long idPenerbangan);

    void addPenerbangan(PenerbanganModel penerbangan);

    List<PenerbanganModel> getPenerbanganList();

    PenerbanganModel updatePenerbangan(PenerbanganModel penerbangan);

    PenerbanganModel deletePenerbangan(PenerbanganModel penerbangan);
}
