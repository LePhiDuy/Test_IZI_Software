import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {HoatDong} from "../module/hoat-dong";

const API = environment.api
@Injectable({
  providedIn: 'root'
})
export class HoatDongService {

  constructor(private http: HttpClient) { }

  findAll(): Observable<any> {
    return this.http.get<any>(API);
  }

  create(hoatDong: HoatDong): Observable<any> {
    return this.http.post<any>(API, hoatDong);
  }

  delete(maHD: number): Observable<any> {
    return this.http.delete<any>(API + '/' + maHD);
  }

  update(maHD: number, hoatDong: HoatDong): Observable<HoatDong> {
    return this.http.put<HoatDong>(API + '/' + maHD, hoatDong);
  }

  findById(maHD: number): Observable<any> {
    return this.http.get<HoatDong>(API + '/' + maHD);
  }
}
