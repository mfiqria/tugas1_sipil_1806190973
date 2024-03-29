package apap.tugas.sipil.service;

import apap.tugas.sipil.model.MaskapaiModel;
import apap.tugas.sipil.repository.MaskapaiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaskapaiServiceImpl implements MaskapaiService{
    @Autowired
    MaskapaiDb maskapaiDb;

    @Override
    public MaskapaiModel getMaskapaiByIdMaskapai(Long idMaskapai) {
        return maskapaiDb.findById(idMaskapai).get();
    }

    @Override
    public List<MaskapaiModel> getMaskapaiList() {return maskapaiDb.findAll();}


    @Override
    public MaskapaiModel getMaskapaiByKode(String kode) {
        return maskapaiDb.findByKode(kode).get();
    }

    @Override
    public MaskapaiModel getMaskapaiByNama(String namaMaskapai) {
        return maskapaiDb.findByNamaMaskapai(namaMaskapai).get();
    }

    @Override
    public MaskapaiModel updateMaskapai(MaskapaiModel maskapai) {
        return null;
    }

}
