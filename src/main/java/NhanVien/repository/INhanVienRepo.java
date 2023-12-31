package NhanVien.repository;

import NhanVien.Models.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface INhanVienRepo extends JpaRepository<NhanVien,Integer> {
    @Query(value = "select sum(sogiolam) from phancong join nhanviens on nhanviens.nhan_vien_id = phancong.nhanvienid where phonenumber = :phoneNumber and hoten = :hoTen", nativeQuery = true)
    int luongNhanVien(@Param("phoneNumber") String phoneNumber, @Param("hoTen") String hoTen);

    @Query(value = "select hesoluong from nhanviens where phonenumber = :phoneNumber and hoten = :hoTen", nativeQuery = true)
    int heSoLuong (@Param("phoneNumber") String phoneNumber, @Param("hoTen") String hoTen);
}
