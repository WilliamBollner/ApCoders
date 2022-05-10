import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DespesaListComponent } from './components/despesa/despesa-list/despesa-list.component';
import { DespesaSaveComponent } from './components/despesa/despesa-save/despesa-save.component';
import { HomeComponent } from './components/home/home.component';
import { InquilinoListComponent } from './components/inquilino/inquilino-list/inquilino-list.component';
import { InquilinoSaveComponent } from './components/inquilino/inquilino-save/inquilino-save.component';
import { UnidadeListComponent } from './components/unidade/unidade-list/unidade-list.component';
import { UnidadeModalSaveComponent } from './components/unidade/unidade-modal-save/unidade-modal-save.component';
import { UnidadeSaveComponent } from './components/unidade/unidade-save/unidade-save.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'unidades', component: UnidadeListComponent},
  {path: 'unidade-save', component: UnidadeSaveComponent},
  {path: 'unidade-modal-save', component: UnidadeModalSaveComponent},
  {path: 'inquilinos', component: InquilinoListComponent},
  {path: 'inquilino-save', component: InquilinoSaveComponent},
  {path: 'despesas', component: DespesaListComponent},
  {path: 'despesa-save', component: DespesaSaveComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
