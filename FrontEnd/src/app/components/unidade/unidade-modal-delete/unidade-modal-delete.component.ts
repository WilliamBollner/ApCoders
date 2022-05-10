import { Component, Input, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { Unidade } from 'src/app/models/unidade';
import { UnidadeService } from 'src/app/services/unidade.service';

@Component({
  selector: 'app-unidade-modal-delete',
  templateUrl: './unidade-modal-delete.component.html',
  styleUrls: ['./unidade-modal-delete.component.scss']
})
export class UnidadeModalDeleteComponent implements OnInit {

  @Input()
  unidadeDel = new Unidade({});

  @Input()
  statusDelete = new Subject<boolean>();

  constructor(private service: UnidadeService) {}

  ngOnInit(): void {
  }

  updateStatus(status: boolean){
    this.unidadeDel = new Unidade({});
    this.statusDelete.next(false);
  }

  delete(id?: number) {
    if(!id) {
      return;
    }

    this.service
        .deleteUnidade(id || 0)
        .subscribe(
          resp => {
            if(resp) {
              console.log('Registro excluído!');
              this.updateStatus(true);
            } else {
              this.updateStatus(false);
            }
          }
        );
  }

}
