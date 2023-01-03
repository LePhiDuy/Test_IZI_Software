package com.example.test.service;

import com.example.test.dto.Statistic;
import com.example.test.model.HoatDong;

import java.util.List;
import java.util.Optional;

public interface IHoatDongService {
    List<HoatDong> findAll();
    HoatDong save(HoatDong hoatDong);
    void delete(Long maHD);
    Optional<HoatDong> findByMaHD(Long maHD);
    List<Statistic> statistic();
}
