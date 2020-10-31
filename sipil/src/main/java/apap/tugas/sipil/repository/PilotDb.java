package apap.tugas.sipil.repository;

import apap.tugas.sipil.model.PilotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PilotDb extends JpaRepository<PilotModel, String> {
    Optional<PilotModel> findByNip(String nip);
    Optional<PilotModel> findByIdPilot(Long id);
}
