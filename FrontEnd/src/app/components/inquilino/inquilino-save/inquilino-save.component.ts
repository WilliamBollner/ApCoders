import { Component, Input, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { Inquilino } from 'src/app/models/inquilino';
import { InquilinoService } from 'src/app/services/inquilino.service';

@Component({
  selector: 'app-inquilino-save',
  templateUrl: './inquilino-save.component.html',
  styleUrls: ['./inquilino-save.component.scss']
})
export class InquilinoSaveComponent implements OnInit {

  @Input()
  status = new Subject<boolean>();

  @Input()
  formInquilino: Inquilino = new Inquilino({});

  msgRetorno = new Subject<boolean>();

  constructor(private service: InquilinoService) { }

  ngOnInit(): void {
  }

  save(){
    this.service.addInquilino(this.formInquilino)
    .subscribe(
      (Inquilino) => {
        if(Inquilino.id){
          this.formInquilino = Inquilino;
          this.msgRetorno.next(true);
        }
      }
    )
  }

}
