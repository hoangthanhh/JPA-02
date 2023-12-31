package NhanVien.Controller;

import NhanVien.Models.NhanVien;
import NhanVien.repository.INhanVienRepo;
import NhanVien.repository.IPhanCongRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/version1.0")
public class NhanVienController {
    @Autowired
    INhanVienRepo nhanVienRepo;

    @Autowired
    IPhanCongRepo phanCongRepo;

    @PostMapping(value = "/themnhanvien")
    public void themNhanVien(@RequestBody String nhanVien) {
        Gson gson = new Gson();
        NhanVien nvMoi = gson.fromJson(nhanVien,NhanVien.class);
        nhanVienRepo.save(nvMoi);

        nvMoi.getPhanCongs().forEach(x->{
            x.setNhanVien(nvMoi);
        });
        phanCongRepo.saveAll(nvMoi.getPhanCongs());
    }

    @DeleteMapping(value = "/xoanhanvien")
    public void xoaNhanVien(@RequestParam int nhanVienId) {
        nhanVienRepo.deleteById(nhanVienId);
    }

    @GetMapping(value = "/luongnhanvien")
    public int Get(@RequestParam String phoneNumber, @RequestParam String hoTen) {
        return nhanVienRepo.luongNhanVien(phoneNumber,hoTen) * 15 * nhanVienRepo.heSoLuong(phoneNumber,hoTen);
    }
}
