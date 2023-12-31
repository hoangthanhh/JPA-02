package NhanVien.Controller;

import NhanVien.Models.DuAn;
import NhanVien.repository.IDuAnRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = "api/version1.0")
public class DuAnController {
    @Autowired
    IDuAnRepo duAnRepo;

    @GetMapping(value = "/duan")
    public List<DuAn> Get(){
        return duAnRepo.findAll();
    }

    @PutMapping(value = "suaduan",produces = MediaType.APPLICATION_JSON_VALUE)
    public void suaDuAn(@RequestBody String duAn) {
        Gson gson = new Gson();
        DuAn duAnMoi = gson.fromJson(duAn, DuAn.class);
        DuAn duAnCurrent = duAnRepo.findById(duAnMoi.getDuAnId()).get();
        duAnCurrent.setTenDuAn(duAnMoi.getTenDuAn());
        duAnCurrent.setMoTa(duAnMoi.getMoTa());
        duAnCurrent.setGhiChu(duAnMoi.getGhiChu());
        duAnCurrent.setPhanCongs(duAnMoi.getPhanCongs());
        duAnRepo.save(duAnCurrent);
    }
}
