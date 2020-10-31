package apap.tugas.sipil.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "akademi")
public class AkademiModel implements Serializable{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAkademi;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    private String namaAkademi;

    @NotNull
    @Size(max = 255)
    @Column(name = "lokasi", nullable = false)
    private String lokasi;

    @OneToMany(mappedBy = "akademiModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PilotModel> listPilot;

    public Long getIdAkademi() {
        return idAkademi;
    }

    public void setIdAkademi(Long idAkademi) {
        this.idAkademi = idAkademi;
    }

    public String getNamaAkademi() {
        return namaAkademi;
    }

    public void setNamaAkademi(String namaAkademi) {
        this.namaAkademi = namaAkademi;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public List<PilotModel> getListPilot() {
        return listPilot;
    }

    public void setListPilot(List<PilotModel> listPilot) {
        this.listPilot = listPilot;
    }
}
