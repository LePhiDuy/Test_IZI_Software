package com.example.test.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tham_gia")
public class ThamGia {
    @EmbeddedId
    private ThamGiaKey thamGiaKey;
    @Column(name = "ngay_gio_DK")
    private Date ngayGioDK;
    @Column(name = "diem_truong_doan")
    private double diemTruongDoan;
    @Column(name = "diem_tieu_chi1")
    private double diemTieuChi1;
    @Column(name = "diem_tieu_chi2")
    private double diemTieuChi2;
    @Column(name = "diem_tieu_chi3")
    private double diemTieuChi3;
    @Column(name = "nhan_xet_khac")
    private String nhanXetKhac;
    @ManyToOne
    @MapsId("maTV")
    @JoinColumn(name = "ma_tv")
    private ThanhVien thanhVien;

    @ManyToOne
    @MapsId("maHD")
    @JoinColumn(name = "ma_hd")
    private HoatDong hoatDong;
}
