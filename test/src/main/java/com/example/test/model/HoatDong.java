package com.example.test.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "hoat_dong")
public class HoatDong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hd")
    private Long maHD;
    @Column(name = "ten_hd")
    private String tenHD;
    @Column(name = "mo_ta_hd")
    private String moTaHD;
    @Column(name = "ngay_gio_bd")
    private Date ngayGioBD;
    @Column(name = "ngay_gio_kt")
    private Date ngayGioKT;
    @Column(name = "sl_toi_thieu_yc")
    private int slToiThieuYC;
    @Column(name = "sl_toi_da_yc")
    private int slToiDaYC;
    @Column(name = "thoi_han_dk")
    private Date thoiHanDK;
    @Column(name = "trang_thai")
    private String trangThai;
    @ManyToOne
    @JoinColumn(name = "ma_tv", referencedColumnName = "ma_tv")
    private ThanhVien thanhVien;
    @Column(name = "ly_do_huy_hd")
    private String lyDoHuyHD;

    @OneToMany(mappedBy = "hoatDong", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ThamGia> thamGiaList;
}
