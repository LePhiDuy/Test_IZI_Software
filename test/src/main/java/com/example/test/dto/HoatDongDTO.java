package com.example.test.dto;

import com.example.test.model.ThamGia;
import com.example.test.model.ThanhVien;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.List;

@Data
public class HoatDongDTO {
    private Long maHD;
    @NotNull
    @NotBlank
    private String tenHD;
    @NotNull
    @NotBlank
    private String moTaHD;
    @NotNull
    private Date ngayGioBD;
    @NotNull
    private Date ngayGioKT;
    @NotNull
    private int slToiThieuYC;
    @NotNull
    private int slToiDaYC;
    @NotNull
    private Date thoiHanDK;
    private String trangThai;
    private Long maTV;
    private String lyDoHuyHD;

    private List<ThamGia> thamGiaList;
}
