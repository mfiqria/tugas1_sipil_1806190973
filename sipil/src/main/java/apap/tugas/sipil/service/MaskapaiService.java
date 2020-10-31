package apap.tugas.sipil.service;

import apap.tugas.sipil.model.MaskapaiModel;

import java.util.List;

public interface MaskapaiService {
    MaskapaiModel getMaskapaiByIdMaskapai(Long idMaskapai);

    List<MaskapaiModel> getMaskapaiList();

    MaskapaiModel getMaskapaiByKode(String kode);

    MaskapaiModel getMaskapaiByNama(String namaMaskapai);

    MaskapaiModel updateMaskapai(MaskapaiModel maskapai);
}
