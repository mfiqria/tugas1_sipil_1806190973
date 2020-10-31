package apap.tugas.sipil.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "penerbangan")
public class PenerbanganModel implements Serializable{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPenerbangan;

    @NotNull
    @Size(max = 16)
    @Column(name = "kode", nullable = false, unique = true)
    private String kode;

    @NotNull
    @Size(max = 255)
    @Column(name = "kota_asal", nullable = false)
    private String kotaAsal;

    @NotNull
    @Size(max = 255)
    @Column(name = "kota_tujuan", nullable = false)
    private String kotaTujuan;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "waktu", nullable = false)
    private Date waktu;

    @OneToMany(mappedBy = "penerbanganModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Pilot_PenerbanganModel> listPilot_Penerbangan;

    public Long getIdPenerbangan() {
        return idPenerbangan;
    }

    public void setIdPenerbangan(Long idPenerbangan) {
        this.idPenerbangan = idPenerbangan;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getKotaAsal() {
        return kotaAsal;
    }

    public void setKotaAsal(String kotaAsal) {
        this.kotaAsal = kotaAsal;
    }

    public String getKotaTujuan() {
        return kotaTujuan;
    }

    public void setKotaTujuan(String kotaTujuan) {
        this.kotaTujuan = kotaTujuan;
    }

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }

    public List<Pilot_PenerbanganModel> getListPilot_Penerbangan() {
        return listPilot_Penerbangan;
    }

    public void setListPilot_Penerbangan(List<Pilot_PenerbanganModel> listPilot_Penerbangan) {
        this.listPilot_Penerbangan = listPilot_Penerbangan;
    }
}
