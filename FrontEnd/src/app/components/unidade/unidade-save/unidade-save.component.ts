import { Component, Input, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { Unidade } from 'src/app/models/unidade';
import { UnidadeService } from 'src/app/services/unidade.service';

@Component({
  selector: 'app-unidade-save',
  templateUrl: './unidade-save.component.html',
  styleUrls: ['./unidade-save.component.scss']
})
export class UnidadeSaveComponent implements OnInit {

  @Input()
  status = new Subject<boolean>();

  @Input()
  formUnidade: Unidade = new Unidade({});

  msgRetorno = new Subject<boolean>();

  constructor(private service: UnidadeService) { }

  ngOnInit(): void {
  }

  save(){
    this.service.addUnidade(this.formUnidade)
    .subscribe(
      (unidade) => {
        if(unidade.id){
          this.formUnidade = unidade;
          this.msgRetorno.next(true);
        }
      }
    )
  }

}
