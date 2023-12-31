package NhanVien.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "nhanviens")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nhanVienId;

    @Column(name = "hoten")
    @Size(min = 2, max = 20, message = "ho ten khong duoc qua 20 ky tu, co it nhat 2 tu")
    private String hoTen;
    @Column(name = "phonenumber")
    private String phoneNumber;
    @Column(name = "diachi")
    private String diaChi;
    @Column(name = "email")
    private String email;
    @Column(name = "hesoluong")
    private int heSoLuong;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "nhanVien")
    @JsonIgnoreProperties(value = "nhanVien")
    private Set<PhanCong> phanCongs;

    public int getNhanVienId() {
        return nhanVienId;
    }

    public void setNhanVienId(int nhanVienId) {
        this.nhanVienId = nhanVienId;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return phoneNumber;
    }

    public void setSdt(String sdt) {
        this.phoneNumber = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(int heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public Set<PhanCong> getPhanCongs() {
        return phanCongs;
    }

    public void setPhanCongs(Set<PhanCong> phanCongs) {
        this.phanCongs = phanCongs;
    }
}
