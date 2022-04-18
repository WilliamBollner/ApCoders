import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { UnidadeListComponent } from './components/unidade/unidade-list/unidade-list.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'unidades', component: UnidadeListComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
