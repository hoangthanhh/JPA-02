package NhanVien.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Set;


@Entity
@Table(name = "duan")
public class DuAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int duAnId;
    @Column(name = "tenduan")
    @Size(max = 10, message = "ten du an khong duoc qua 10 ky tu")
    private String tenDuAn;
    @Column(name = "mota")
    private String moTa;
    @Column(name = "ghichu")
    private String ghiChu;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "duAn")
    @JsonIgnoreProperties(value = "duAn")
    private Set<PhanCong> phanCongs;

    public int getDuAnId() {
        return duAnId;
    }

    public void setDuAnId(int duAnId) {
        this.duAnId = duAnId;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Set<PhanCong> getPhanCongs() {
        return phanCongs;
    }

    public void setPhanCongs(Set<PhanCong> phanCongs) {
        this.phanCongs = phanCongs;
    }
}

