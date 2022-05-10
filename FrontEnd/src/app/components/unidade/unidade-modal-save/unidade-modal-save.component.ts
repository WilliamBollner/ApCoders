import { Component, Input, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { Unidade } from 'src/app/models/unidade';

@Component({
  selector: 'app-unidade-modal-save',
  templateUrl: './unidade-modal-save.component.html',
  styleUrls: ['./unidade-modal-save.component.scss']
})
export class UnidadeModalSaveComponent implements OnInit {

  @Input()
  statusSave$ = new Subject<boolean>();

  @Input()
  unidadeSave = new Unidade({});

  constructor() { }

  ngOnInit(): void {
    this.statusSave$
    .subscribe(resp =>
      {
        if(!resp){
          document.getElementById('btnModalSaveNotaCancel')?.click();
        }
      })
  }

  updateStatus(status: boolean) {
    this.unidadeSave = new Unidade({});
    this.statusSave$.next(false);
  }

}

