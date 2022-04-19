import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Unidade } from '../models/unidade';

@Injectable({
  providedIn: 'root'
})
export class UnidadeService {

  constructor(private http: HttpClient) { }

  url = `${environment.urlApi}/unidades`;

  getListUnidades(){
    return this.http.get<Unidade[]>(this.url);
  }

  getUnidadeById(id: number){
    return this.http.get<Unidade>(`${this.url}/${id}`);
  }

  addUnidade(unidade: Unidade){
    return this.http.post<Unidade>(this.url, unidade);
  }
}
