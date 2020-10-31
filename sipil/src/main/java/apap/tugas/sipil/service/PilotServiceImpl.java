package apap.tugas.sipil.service;

import apap.tugas.sipil.model.PilotModel;
import apap.tugas.sipil.repository.PilotDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class PilotServiceImpl implements PilotService{
    @Autowired
    PilotDb pilotDb;

    @Override
    public PilotModel getPilotByNip(String nip) {
        return pilotDb.findByNip(nip).get();
    }

//    @Override
//    public PilotModel getPilotByIdPilot(Long idPilot) {
//        return pilotDb.findByIdPilot(idPilot).get();
//    }

    public String capital() {
        Random random = new Random();
        Integer num1 = random.ints(65,90).findAny().getAsInt();
        Integer num2 = random.ints(65,90).findAny().getAsInt();
        String huruf = Character.toString(num1) + Character.toString(num2) + "";
        return huruf;
    }

    @Override
    public String createNip(PilotModel pilot){
        String nip = "";
        String gender = pilot.getJenisKelamin() + "";
        String tlahir = pilot.getTempatLahir().substring(0,2).toUpperCase() + "";
        String lname = pilot.getNamaPilot().substring(pilot.getNamaPilot().length()-1).toUpperCase() + "";
        DateFormat tanggal = new SimpleDateFormat("ddMM");
        DateFormat tahun = new SimpleDateFormat("yyyy");
        String bdate = tanggal.format(pilot.getTanggalLahir());
//        String year = "100";
        String year = Integer.parseInt(tahun.format(pilot.getTanggalLahir()))/10 + "";
        String rand = capital() + "";
        nip = nip + gender + tlahir + lname + bdate + year + rand;
        return nip;
    }

    @Override
    public void addPilot(PilotModel pilot) {
        pilot.setNip(createNip(pilot));
        pilotDb.save(pilot);
    }


    @Override
    public List<PilotModel> getPilotList() {return pilotDb.findAll();}

    @Override
    public PilotModel updatePilot(PilotModel pilot){
        pilot.setNip(createNip(pilot));
        pilotDb.save(pilot);
        return pilot;
    }

    @Override
    public PilotModel deletePilot(PilotModel pilot){
        pilotDb.delete(pilot);
        return pilot;
    }

}
