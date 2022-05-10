import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Inquilino } from 'src/app/models/inquilino';
import { InquilinoService } from 'src/app/services/inquilino.service';

@Component({
  selector: 'app-inquilino-list',
  templateUrl: './inquilino-list.component.html',
  styleUrls: ['./inquilino-list.component.scss']
})
export class InquilinoListComponent implements OnInit {

  listInquilinos$ = new Observable<Inquilino[]>();

  inquilinoAction = new Inquilino({});

  monitoraStatusAction$ = new Subject<boolean>();

  constructor(private service: InquilinoService) { }


  ngOnInit(): void {
    this.getList();
    this.monitoraStatusAction$ 
    .subscribe(
      (resp) => {
        this.inquilinoAction = new Inquilino({});
        this.getList();
      }
    )
}

confirmAction(inquilino: Inquilino){
  if(inquilino){
    this.inquilinoAction = inquilino;
  }
}
  getList(){
    this.listInquilinos$ = this.service.getListInquilinos();
  }

}
