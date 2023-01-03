package com.example.test.reporitory;

import com.example.test.dto.Statistic;
import com.example.test.model.HoatDong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IHoatDongRepository extends JpaRepository<HoatDong, Long> {
    @Query(value = "select hd.ma_tv, tv.ho_ten, avg(diem_truong_doan) as diem_trung_binh  from thanh_vien as tv \n" +
            "join hoat_dong as hd on tv.ma_tv = hd.ma_tv\n" +
            "join tham_gia as tg on hd.ma_hd = tg.ma_hd\n" +
            "group by tv.ma_tv", nativeQuery = true)
    List<Statistic> statistic();
}
