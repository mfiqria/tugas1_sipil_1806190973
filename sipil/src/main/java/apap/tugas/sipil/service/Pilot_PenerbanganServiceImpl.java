package apap.tugas.sipil.service;

import apap.tugas.sipil.model.Pilot_PenerbanganModel;
import apap.tugas.sipil.repository.Pilot_PenerbanganDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Pilot_PenerbanganServiceImpl implements Pilot_PenerbanganService{
    @Autowired
    Pilot_PenerbanganDb pilot_PenerbanganDb;

    @Override
    public Pilot_PenerbanganModel getPilot_PenerbanganByIdPilot_Penerbangan(Long idPilot_Penerbangan) {
        return pilot_PenerbanganDb.findById(idPilot_Penerbangan).get();
    }

}
