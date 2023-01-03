import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {HoatDongService} from "../service/hoat-dong.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  id: number;
  formEdit: FormGroup;
  constructor(private hoatDongService: HoatDongService, private activatedRoute: ActivatedRoute,
              private formBuilder: FormBuilder, private router: Router) {
  }

  ngOnInit(): void {
    this.formEdit = this.formBuilder.group({
      maHD: [],
      tenHD: ['', [Validators.required]],
      moTaHD: ['', [Validators.required]],
      ngayGioBD: ['', [Validators.required]],
      ngayGioKT: ['', [Validators.required]],
      slToiThieuYC: ['', [Validators.required]],
      slToiDaYC: ['', [Validators.required]],
      thoiHanDK: ['', [Validators.required]],
      trangThai: ['', [Validators.required]]
    });
    this.id = parseInt(this.activatedRoute.snapshot.paramMap.get('maHD'));
    this.hoatDongService.findById(this.id).subscribe(data => {
      this.formEdit.patchValue(data);
    });
  }

  onSubmit(maHD: number) {
    const hoatDong = this.formEdit.value;
    console.log(hoatDong);
    if (this.formEdit.valid) {
      this.hoatDongService.update(maHD, hoatDong).subscribe(() => {
        alert('Chỉnh sửa thành công');
        this.router.navigateByUrl('');
      }, error => {
        alert('Loi');
      });
    } else {
      alert("Dữ liệu không hợp lệ");
    }
  }


  get maHD() {
    return this.formEdit.get('maHD');
  }

  get tenHD() {
    return this.formEdit.get('tenHD');
  }

  get moTaHD() {
    return this.formEdit.get('moTaHD');
  }

  get ngayGioBD() {
    return this.formEdit.get('ngayGioBD');
  }

  get ngayGioKT() {
    return this.formEdit.get('ngayGioKT');
  }

  get slToiThieuYC() {
    return this.formEdit.get('slToiThieuYC');
  }

  get slToiDaYC() {
    return this.formEdit.get('slToiDaYC');
  }

  get thoiHanDK() {
    return this.formEdit.get('thoiHanDK');
  }

  get trangThai() {
    return this.formEdit.get('trangThai');
  }

}
