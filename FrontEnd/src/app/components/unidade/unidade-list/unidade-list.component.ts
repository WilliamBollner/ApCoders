import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable, Subject } from 'rxjs';
import { Unidade } from 'src/app/models/unidade';
import { UnidadeService } from 'src/app/services/unidade.service';

@Component({
  selector: 'app-unidade-list',
  templateUrl: './unidade-list.component.html',
  styleUrls: ['./unidade-list.component.scss']
})
export class UnidadeListComponent implements OnInit {

  
  listUnidades$ = new Observable<Unidade[]>();
  unidade = new Unidade({});

  unidadeAction = new Unidade({});

  monitoraStatusAction$ = new Subject<boolean>();

  constructor(private unidadeService: UnidadeService) {} 

  ngOnInit(): void {
    this.getList();


    this.monitoraStatusAction$ 
      .subscribe(
        (resp) => {
          this.unidadeAction = new Unidade({});
          this.getList();
        }
      )
  }

  confirmAction(unidade: Unidade){
    if(unidade){
      this.unidadeAction = unidade;
    }
  }

  getList(){
    this.listUnidades$ = this.unidadeService.getListUnidades();
  }

  getById(){
      let id = this.unidade.id;
      this.unidadeService.getUnidadeById(id || 0).subscribe((unidade) => {
        console.log(unidade);
        this.unidade = unidade;
      })
    }

 



}
