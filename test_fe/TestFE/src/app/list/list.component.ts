import { Component, OnInit } from '@angular/core';
import {HoatDongService} from "../service/hoat-dong.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  hoatDongs: any;
  id: number;
  constructor(private hoatDongService: HoatDongService,
              private router: Router) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll() {
    this.hoatDongService.findAll().subscribe(
      data => {
        this.hoatDongs = data;
      },
      error => {
        console.log("Loi");
      }
    )
  }

  changeId(id) {
    this.id = id;
  }

  delete(id) {
    this.hoatDongService.delete(id).subscribe(
      data=> {
        alert("Xoa thanh cong");
        this.findAll();
      }, error => {
        alert("Xoa that bai");
      }
    )
  }
}
