import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Inquilino } from '../models/inquilino';

@Injectable({
  providedIn: 'root'
})
export class InquilinoService {

  constructor(private http: HttpClient) { }

  url = `${environment.urlApi}/inquilinos`;

  getListInquilinos(){
    return this.http.get<Inquilino[]>(this.url);
  }

  getInquilinoById(id: number){
    return this.http.get<Inquilino>(`${this.url}/${id}`);
  }

  addInquilino(inquilino: Inquilino){
    return this.http.post<Inquilino>(this.url, inquilino);
  }

  deleteInquilino(id: number){
    return this.http.delete(`${this.url}/${id}`);
  }
}
