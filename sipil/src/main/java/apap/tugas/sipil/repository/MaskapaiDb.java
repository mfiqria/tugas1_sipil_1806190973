package apap.tugas.sipil.repository;

import apap.tugas.sipil.model.MaskapaiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface MaskapaiDb extends JpaRepository<MaskapaiModel, Long> {
    Optional<MaskapaiModel> findById(Long idMaskapai);

    Optional<MaskapaiModel> findByNamaMaskapai(String namaMaskapai);

    Optional<MaskapaiModel> findByKode(String kode);
}
