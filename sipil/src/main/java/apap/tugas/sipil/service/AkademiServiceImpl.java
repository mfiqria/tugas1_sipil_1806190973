package apap.tugas.sipil.service;

import apap.tugas.sipil.model.AkademiModel;
import apap.tugas.sipil.repository.AkademiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AkademiServiceImpl implements AkademiService{
    @Autowired
    AkademiDb akademiDb;

    @Override
    public AkademiModel getAkademiByIdAkademi(Long idAkademi) {
        return akademiDb.findById(idAkademi).get();
    }

}
