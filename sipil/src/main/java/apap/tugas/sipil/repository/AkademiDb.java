package apap.tugas.sipil.repository;

import apap.tugas.sipil.model.AkademiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface AkademiDb extends JpaRepository<AkademiModel, Long> {
    Optional<AkademiModel> findById(Long idAkademi);
}
