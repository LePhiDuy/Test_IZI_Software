import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {HoatDongService} from "../service/hoat-dong.service";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  formCreate: FormGroup;
  constructor(private hoatDongService: HoatDongService, private activatedRoute: ActivatedRoute,
              private formBuilder: FormBuilder, private router: Router) {
  }

  ngOnInit(): void {
    this.formCreate = this.formBuilder.group({
      maHD: [],
      tenHD: ['', [Validators.required]],
      moTaHD: ['', [Validators.required]],
      ngayGioBD: ['', [Validators.required]],
      ngayGioKT: ['', [Validators.required]],
      slToiThieuYC: ['', [Validators.required]],
      slToiDaYC: ['', [Validators.required]],
      thoiHanDK: ['', [Validators.required]],
      maTV: ['', [Validators.required]]
    });
  }

  onSubmit() {
    const hoatDong = this.formCreate.value;
    console.log(hoatDong);
    if (this.formCreate.valid) {
      this.hoatDongService.create(hoatDong).subscribe(() => {
        alert('Thêm thành công');
        this.router.navigateByUrl('');
      }, error => {
        alert('Loi');
      });
    } else {
      alert("Dữ liệu không hợp lệ");
    }
  }

  get maHD() {
    return this.formCreate.get('maHD');
  }

  get tenHD() {
    return this.formCreate.get('tenHD');
  }

  get moTaHD() {
    return this.formCreate.get('moTaHD');
  }

  get ngayGioBD() {
    return this.formCreate.get('ngayGioBD');
  }

  get ngayGioKT() {
    return this.formCreate.get('ngayGioKT');
  }

  get slToiThieuYC() {
    return this.formCreate.get('slToiThieuYC');
  }

  get slToiDaYC() {
    return this.formCreate.get('slToiDaYC');
  }

  get thoiHanDK() {
    return this.formCreate.get('thoiHanDK');
  }

  get maTV() {
    return this.formCreate.get('maTV');
  }
}
