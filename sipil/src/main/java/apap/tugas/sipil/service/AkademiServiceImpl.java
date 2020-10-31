package apap.tugas.sipil.service;

import apap.tugas.sipil.model.*;
import apap.tugas.sipil.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class AkademiServiceImpl implements AkademiService {
    @Autowired
    AkademiDb akademiDb;

    @Override
    public List<AkademiModel> getAkademiList() {
        return akademiDb.findAll();
    }

    @Override
    public AkademiModel getAkademiByIdAkademi(Long idAkademi) {
        return akademiDb.findById(idAkademi).get();

    }


}
