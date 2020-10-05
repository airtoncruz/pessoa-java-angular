import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import { PessoaQueryComponent } from './pessoa/query/pessoa-query/pessoa-query.component';
import { PessoaCommandComponent } from './pessoa/command/pessoa-command/pessoa-command.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {
  MatDialogModule,
  MatFormFieldModule,
  MatGridListModule,
  MatIconModule,
  MatListModule,
  MatTableModule,
  MatInputModule,
  MatButtonModule, MatExpansionModule, MatPaginatorModule
} from '@angular/material';
import { TextMaskModule } from 'angular2-text-mask';

@NgModule({
  declarations: [
    AppComponent,
    PessoaQueryComponent,
    PessoaCommandComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSliderModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatListModule,
    MatIconModule,
    MatGridListModule,
    MatTableModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    TextMaskModule,
    MatButtonModule,
    MatExpansionModule,
    FormsModule,
    MatPaginatorModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: []
})
export class AppModule { }
