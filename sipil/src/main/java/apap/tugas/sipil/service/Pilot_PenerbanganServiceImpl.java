package apap.tugas.sipil.service;

import apap.tugas.sipil.model.PenerbanganModel;
import apap.tugas.sipil.model.PilotModel;
import apap.tugas.sipil.model.Pilot_PenerbanganModel;
import apap.tugas.sipil.repository.Pilot_PenerbanganDb;
import apap.tugas.sipil.repository.PilotDb;
import apap.tugas.sipil.repository.PenerbanganDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class Pilot_PenerbanganServiceImpl implements Pilot_PenerbanganService{
    @Autowired
    Pilot_PenerbanganDb pilot_PenerbanganDb;
    PilotDb pilotDb;
    PenerbanganDb penerbanganDb;

    @Override
    public Pilot_PenerbanganModel getPilot_PenerbanganByIdPilot_Penerbangan(Long idPilot_Penerbangan) {
        return pilot_PenerbanganDb.findById(idPilot_Penerbangan).get();
    }

    @Override
    public Pilot_PenerbanganModel getPilot_Penerbangan(PilotModel pilot, PenerbanganModel penerbangan) {
        return pilot_PenerbanganDb.findByPilotModelAndPenerbanganModel(pilot,penerbangan).get();
    }

    @Override
    public Pilot_PenerbanganModel addPilot_Penerbangan(Pilot_PenerbanganModel pilot_penerbangan) {
        return pilot_PenerbanganDb.save(pilot_penerbangan);
    }

    @Override
    public List<Pilot_PenerbanganModel> getPilot_PenerbanganByPenerbangan(PenerbanganModel penerbangan) {
        return pilot_PenerbanganDb.findAllByPenerbanganModel(penerbangan);
    }

    @Override
    public List<PilotModel> getDaftarPilot(PenerbanganModel penerbangan) {
        List<Pilot_PenerbanganModel> listPilot_Penerbangan = pilot_PenerbanganDb.findAllByPenerbanganModel(penerbangan);
        List<PilotModel> daftarPilot = new ArrayList<>();
        for (Pilot_PenerbanganModel pilot : listPilot_Penerbangan){
            PilotModel pilotModel = pilotDb.findByIdPilot(pilot.getPilotModel().getIdPilot()).get();
            daftarPilot.add(pilotModel);
        }
        return daftarPilot;
    }

    public List<PenerbanganModel> getDaftarPenerbangan(PilotModel pilot) {
        List<Pilot_PenerbanganModel> listPilot_Penerbangan = pilot_PenerbanganDb.findAllByPilotModel(pilot);
        List<PenerbanganModel> daftarPenerbangan = new ArrayList<>();
        for (Pilot_PenerbanganModel penerbangan : listPilot_Penerbangan){
            PenerbanganModel penerbanganModel = penerbanganDb.findByKode(penerbangan.getPenerbanganModel().getKode()).get();
            daftarPenerbangan.add(penerbanganModel);
        }
        return daftarPenerbangan;
    }
}
