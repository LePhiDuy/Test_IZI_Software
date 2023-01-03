package com.example.test.reporitory;

import com.example.test.model.ThanhVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IThanhVienRepository extends JpaRepository<ThanhVien, Long> {
}
