package NhanVien.repository;

import NhanVien.Models.DuAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDuAnRepo extends JpaRepository<DuAn,Integer> {
}
