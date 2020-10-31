package apap.tugas.sipil.service;

import apap.tugas.sipil.model.PilotModel;

import java.util.List;

public interface PilotService {
    PilotModel getPilotByNip(String nip);

    void addPilot(PilotModel pilot);

    String createNip(PilotModel pilot);

    List<PilotModel> getPilotList();

    PilotModel updatePilot(PilotModel pilot);

    PilotModel deletePilot(PilotModel pilot);

//    List<PilotModel> getPilotBulanIni(List<PilotModel> listPilot);

}
