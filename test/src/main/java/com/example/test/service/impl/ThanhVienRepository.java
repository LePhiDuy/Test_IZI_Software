package com.example.test.service.impl;

import com.example.test.model.ThanhVien;
import com.example.test.reporitory.IThanhVienRepository;
import com.example.test.service.IThanhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ThanhVienRepository implements IThanhVienService {
    @Autowired
    private IThanhVienRepository thanhVienRepository;

    @Override
    public Optional<ThanhVien> findByMaTV(Long maTV) {
        return thanhVienRepository.findById(maTV);
    }
}
