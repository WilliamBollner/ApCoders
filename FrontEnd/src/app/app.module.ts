import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UnidadeListComponent } from './components/unidade/unidade-list/unidade-list.component';
import { UnidadeSaveComponent } from './components/unidade/unidade-save/unidade-save.component';
import { InquilinoSaveComponent } from './components/inquilino/inquilino-save/inquilino-save.component';
import { InquilinoListComponent } from './components/inquilino/inquilino-list/inquilino-list.component';
import { DespesaListComponent } from './components/despesa/despesa-list/despesa-list.component';
import { DespesaSaveComponent } from './components/despesa/despesa-save/despesa-save.component';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { HomeComponent } from './components/home/home.component';
import { FooterComponent } from './components/footer/footer.component';
import { UnidadeModalSaveComponent } from './components/unidade/unidade-modal-save/unidade-modal-save.component';
import { UnidadeModalDeleteComponent } from './components/unidade/unidade-modal-delete/unidade-modal-delete.component';

@NgModule({
  declarations: [
    AppComponent,
    UnidadeListComponent,
    UnidadeSaveComponent,
    InquilinoSaveComponent,
    InquilinoListComponent,
    DespesaListComponent,
    DespesaSaveComponent,
    SidebarComponent,
    HomeComponent,
    FooterComponent,
    UnidadeModalSaveComponent,
    UnidadeModalDeleteComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
