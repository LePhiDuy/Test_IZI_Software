package com.example.test.service;

import com.example.test.model.ThanhVien;

import java.util.Optional;

public interface IThanhVienService {
    Optional<ThanhVien> findByMaTV(Long maTV);
}
