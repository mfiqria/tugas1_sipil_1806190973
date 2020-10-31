package apap.tugas.sipil.service;

import apap.tugas.sipil.model.AkademiModel;

import java.util.List;

public interface AkademiService {
    AkademiModel getAkademiByIdAkademi(Long idAkademi);

    List<AkademiModel> getAkademiList();

}
