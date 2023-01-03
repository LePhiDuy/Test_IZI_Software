package com.example.test.service.impl;

import com.example.test.dto.Statistic;
import com.example.test.model.HoatDong;
import com.example.test.reporitory.IHoatDongRepository;
import com.example.test.service.IHoatDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoatDongServiceImpl implements IHoatDongService {
    @Autowired
    private IHoatDongRepository hoatDongRepository;
    @Override
    public List<HoatDong> findAll() {
        return hoatDongRepository.findAll();
    }

    @Override
    public HoatDong save(HoatDong hoatDong) {
        return hoatDongRepository.save(hoatDong);
    }

    @Override
    public void delete(Long maHD) {
        hoatDongRepository.deleteById(maHD);
    }

    @Override
    public Optional<HoatDong> findByMaHD(Long maHD) {
        return hoatDongRepository.findById(maHD);
    }

    @Override
    public List<Statistic> statistic() {
        return hoatDongRepository.statistic();
    }
}
