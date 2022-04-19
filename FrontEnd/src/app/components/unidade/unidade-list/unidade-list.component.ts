import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Unidade } from 'src/app/models/unidade';
import { UnidadeService } from 'src/app/services/unidade.service';

@Component({
  selector: 'app-unidade-list',
  templateUrl: './unidade-list.component.html',
  styleUrls: ['./unidade-list.component.scss']
})
export class UnidadeListComponent implements OnInit {

  
  listUnidades$ = new Observable<Unidade[]>();

  constructor(private route: ActivatedRoute, private unidadeService: UnidadeService) {} 

  ngOnInit(): void {
    this.listUnidades$ = this.unidadeService.getListUnidades();
  }

  delete(id?: number){
    //let ret = this.AlunoService.delete(id)
    console.log(id);
  }



}
