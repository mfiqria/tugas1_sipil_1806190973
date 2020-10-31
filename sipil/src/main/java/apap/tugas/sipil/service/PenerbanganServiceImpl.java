package apap.tugas.sipil.service;

import apap.tugas.sipil.model.PenerbanganModel;
import apap.tugas.sipil.model.PilotModel;
import apap.tugas.sipil.repository.PenerbanganDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PenerbanganServiceImpl implements PenerbanganService{
    @Autowired
    PenerbanganDb penerbanganDb;

    @Override
    public PenerbanganModel getPenerbanganByIdPenerbangan(Long idPenerbangan) {
        return penerbanganDb.findById(idPenerbangan).get();
    }

    @Override
    public void addPenerbangan(PenerbanganModel penerbangan) {
        penerbanganDb.save(penerbangan);
    }

    @Override
    public List<PenerbanganModel> getPenerbanganList() {return penerbanganDb.findAll();}

    @Override
    public PenerbanganModel updatePenerbangan(PenerbanganModel penerbangan){
        penerbanganDb.save(penerbangan);
        return penerbangan;
    }

    @Override
    public PenerbanganModel deletePenerbangan(PenerbanganModel penerbangan){
        if(penerbangan.getListPilot_Penerbangan().size() == 0){
            penerbanganDb.delete(penerbangan);
            return penerbangan;
        }
        else{
            return null;
        }
    }

}
