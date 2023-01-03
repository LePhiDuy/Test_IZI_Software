package com.example.test.model;

import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class ThamGiaKey implements Serializable {
    @Column(name = "ma_tv")
    private Long maTV;

    @Column(name = "ma_hd")
    private Long maHD;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThamGiaKey that = (ThamGiaKey) o;
        return Objects.equals(maTV, that.maTV) && Objects.equals(maHD, that.maHD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maTV, maHD);
    }
}