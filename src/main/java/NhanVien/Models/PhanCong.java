package NhanVien.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "phancong")
public class PhanCong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phancongid")
    private int phanCongId;
    @Column(name = "sogiolam")
    private int soGioLam;
    @ManyToOne
    @JoinColumn(name = "duanid")
    private DuAn duAn;
    @ManyToOne
    @JoinColumn(name = "nhanvienid")
    private NhanVien nhanVien;

    public int getPhanCongId() {
        return phanCongId;
    }

    public void setPhanCongId(int phanCongId) {
        this.phanCongId = phanCongId;
    }

    public int getSoGioLam() {
        return soGioLam;
    }

    public void setSoGioLam(int soGioLam) {
        this.soGioLam = soGioLam;
    }

    public DuAn getDuAn() {
        return duAn;
    }

    public void setDuAn(DuAn duAn) {
        this.duAn = duAn;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
}

