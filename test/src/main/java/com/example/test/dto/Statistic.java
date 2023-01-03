package com.example.test.dto;

import org.springframework.beans.factory.annotation.Value;

public interface Statistic {
    @Value("#{target=ma_tv}")
    Long getMaTV();
    @Value("#{target=ho_ten}")
    String getHoTen();
    @Value("#{target=diem_trung_binh}")
    Double getDiemTrungBinh();
}
