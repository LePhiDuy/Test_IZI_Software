package com.example.test.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "thanh_vien")
public class ThanhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_tv")
    private Long maTV;
    @Column(name = "ho_ten")
    private String hoTen;
    @Column(name = "gioi_tinh")
    private boolean gioiTinh;
    @Column(name = "ngay_sinh")
    private Date ngaySinh;
    @Column(name = "email")
    private String email;
    @Column(name = "so_dien_thoai")
    private String soDienThoai;
    @OneToMany(mappedBy = "thanhVien")
    @JsonIgnore
    private List<HoatDong> hoatDongList;
    @OneToMany(mappedBy = "thanhVien", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ThamGia> thamGiaList;
}
