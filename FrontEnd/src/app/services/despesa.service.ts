import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Despesa } from '../models/despesa';

@Injectable({
  providedIn: 'root'
})
export class DespesaService {

  constructor(private http: HttpClient) { }

  url = `${environment.urlApi}/Despesas`;

  getListDespesas(){
    return this.http.get<Despesa[]>(this.url);
  }

  getDespesaById(id: number){
    return this.http.get<Despesa>(`${this.url}/${id}`);
  }

  addDespesa(despesa: Despesa){
    return this.http.post<Despesa>(this.url, despesa);
  }

  deleteDespesa(id: number){
    return this.http.delete(`${this.url}/${id}`);
  }
}
