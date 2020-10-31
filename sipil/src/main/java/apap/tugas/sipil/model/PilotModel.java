package apap.tugas.sipil.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "pilot")
public class PilotModel implements Serializable{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPilot;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    private String namaPilot;

    @NotNull
    @Size(max = 13)
    @Column(name = "nip", nullable = false, unique = true)
    private String nip;

    @NotNull
    @Size(max = 255)
    @Column(name = "nik", nullable = false)
    private String nik;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "tanggal_lahir", nullable = false)
    private Date tanggalLahir;

    @NotNull
    @Size(max = 255)
    @Column(name = "tempat_lahir", nullable = false)
    private String tempatLahir;

    @NotNull
    @Column(name = "jenis_kelamin", nullable = false)
    private Integer jenisKelamin;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_maskapai", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private MaskapaiModel maskapaiModel;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_akademi", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private AkademiModel akademiModel;

    @OneToMany(mappedBy = "pilotModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pilot_PenerbanganModel> listPilot_Penerbangan;

    public Long getIdPilot() {
        return idPilot;
    }

    public void setIdPilot(Long idPilot) {
        this.idPilot = idPilot;
    }

    public String getNamaPilot() {
        return namaPilot;
    }

    public void setNamaPilot(String namaPilot) {
        this.namaPilot = namaPilot;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public Integer getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Integer jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public MaskapaiModel getMaskapaiModel() {
        return maskapaiModel;
    }

    public void setMaskapaiModel(MaskapaiModel maskapaiModel) {
        this.maskapaiModel = maskapaiModel;
    }

    public AkademiModel getAkademiModel() {
        return akademiModel;
    }

    public void setAkademiModel(AkademiModel akademiModel) {
        this.akademiModel = akademiModel;
    }

    public List<Pilot_PenerbanganModel> getListPilot_Penerbangan() {
        return listPilot_Penerbangan;
    }

    public void setListPilot_Penerbangan(List<Pilot_PenerbanganModel> listPilot_Penerbangan) {
        this.listPilot_Penerbangan = listPilot_Penerbangan;
    }


}
