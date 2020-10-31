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
@Table(name = "maskapai")
public class MaskapaiModel implements Serializable{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaskapai;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    private String namaMaskapai;

    @NotNull
    @Size(max = 255)
    @Column(name = "kode", nullable = false)
    private String kode;

    @OneToMany(mappedBy = "maskapaiModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PilotModel> listPilot;

    public Long getIdMaskapai() {
        return idMaskapai;
    }

    public void setIdMaskapai(Long idMaskapai) {
        this.idMaskapai = idMaskapai;
    }

    public String getNamaMaskapai() {
        return namaMaskapai;
    }

    public void setNamaMaskapai(String namaMaskapai) {
        this.namaMaskapai = namaMaskapai;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public List<PilotModel> getListPilot() {
        return listPilot;
    }

    public void setListPilot(List<PilotModel> listPilot) {
        this.listPilot = listPilot;
    }
}
