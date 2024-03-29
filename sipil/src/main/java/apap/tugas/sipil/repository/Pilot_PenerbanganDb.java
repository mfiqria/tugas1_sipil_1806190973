package apap.tugas.sipil.repository;

import apap.tugas.sipil.model.PenerbanganModel;
import apap.tugas.sipil.model.PilotModel;
import apap.tugas.sipil.model.Pilot_PenerbanganModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface Pilot_PenerbanganDb extends JpaRepository<Pilot_PenerbanganModel, Long> {
    Optional<Pilot_PenerbanganModel> findById(Long idPilot_Penerbangan);
    Optional<Pilot_PenerbanganModel> findByPilotModelAndPenerbanganModel(PilotModel pilot,
                                                                         PenerbanganModel penerbangan);
    List<Pilot_PenerbanganModel> findAllByPenerbanganModel(PenerbanganModel penerbangan);
    List<Pilot_PenerbanganModel> findAllByPilotModel(PilotModel pilot);

}
