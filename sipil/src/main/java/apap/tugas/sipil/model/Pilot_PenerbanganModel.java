package apap.tugas.sipil.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "pilot_penerbangan")
public class Pilot_PenerbanganModel implements Serializable{
    @Id
    @Column(name = "id", nullable = false)
    @Size(max = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPilot_Penerbangan;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_penugasan", nullable = false)
    private Date tanggalPenugasan;

    @ManyToOne(fetch = FetchType.EAGER, optional = false , targetEntity = PilotModel.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "id_pilot", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PilotModel pilotModel;

    @ManyToOne(fetch = FetchType.EAGER, optional = false , targetEntity = PenerbanganModel.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "id_penerbangan", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PenerbanganModel penerbanganModel;

    public Long getIdPilot_Penerbangan() {
        return idPilot_Penerbangan;
    }

    public void setIdPilot_Penerbangan(Long idPilot_Penerbangan) {
        this.idPilot_Penerbangan = idPilot_Penerbangan;
    }

    public Date getTanggalPenugasan() {
        return tanggalPenugasan;
    }

    public void setTanggalPenugasan(Date tanggalPenugasan) {
        this.tanggalPenugasan = tanggalPenugasan;
    }

    public PilotModel getPilotModel() {
        return pilotModel;
    }

    public void setPilotModel(PilotModel pilotModel) {
        this.pilotModel = pilotModel;
    }

    public PenerbanganModel getPenerbanganModel() {
        return penerbanganModel;
    }

    public void setPenerbanganModel(PenerbanganModel penerbanganModel) {
        this.penerbanganModel = penerbanganModel;
    }
}
