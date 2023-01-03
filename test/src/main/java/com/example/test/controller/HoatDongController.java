package com.example.test.controller;

import com.example.test.dto.HoatDongDTO;
import com.example.test.dto.Statistic;
import com.example.test.model.HoatDong;
import com.example.test.model.ThanhVien;
import com.example.test.service.IHoatDongService;
import com.example.test.service.IThanhVienService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/hoatdong")
public class HoatDongController {
    @Autowired
    private IHoatDongService hoatDongService;
    @Autowired
    private IThanhVienService thanhVienService;
    @GetMapping
    public ResponseEntity<List<HoatDong>> findAll() {
        if (hoatDongService.findAll().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(hoatDongService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HoatDong> create(@RequestBody @Valid HoatDongDTO hoatDongDTO) {
        HoatDong hoatDong = new HoatDong();
        BeanUtils.copyProperties(hoatDongDTO, hoatDong);
        Optional<ThanhVien> thanhVienOptional = thanhVienService.findByMaTV(hoatDongDTO.getMaTV());
        if (!thanhVienOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        hoatDong.setTrangThai("Đang mời đăng ký");
        hoatDong.setThanhVien(thanhVienOptional.get());
        return new ResponseEntity<>(hoatDongService.save(hoatDong), HttpStatus.CREATED);
    }

    @PutMapping("/{maHD}")
    public ResponseEntity<HoatDong> edit(@PathVariable Long maHD, @RequestBody @Valid HoatDongDTO hoatDongDTO, BindingResult bindingResult) {
        Optional<HoatDong> hoatDongOptional = hoatDongService.findByMaHD(maHD);
        if (!hoatDongOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        HoatDong hoatDong = new HoatDong();
        BeanUtils.copyProperties(hoatDongDTO, hoatDong);
        return new ResponseEntity<>(hoatDongService.save(hoatDong), HttpStatus.OK);
    }

    @DeleteMapping("/{maHD}")
    public ResponseEntity<HoatDong> delete(@PathVariable Long maHD) {
        Optional<HoatDong> hoatDongOptional = hoatDongService.findByMaHD(maHD);
        if (!hoatDongOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (hoatDongOptional.get().getTrangThai().equals("Đã kết thúc")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        hoatDongService.delete(maHD);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{maHD}")
    public ResponseEntity<HoatDong> findById(@PathVariable Long maHD) {
        Optional<HoatDong> hoatDongOptional = hoatDongService.findByMaHD(maHD);
        if (!hoatDongOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hoatDongOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/statistic")
    public ResponseEntity<List<Statistic>> statistic() {
        return new ResponseEntity<>(hoatDongService.statistic(), HttpStatus.OK);
    }
}
