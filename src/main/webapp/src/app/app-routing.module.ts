import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PessoaQueryComponent} from './pessoa/query/pessoa-query/pessoa-query.component';
import {PessoaCommandComponent} from './pessoa/command/pessoa-command/pessoa-command.component';

const routes: Routes = [
  { path: '', component: PessoaQueryComponent },
  { path: 'pessoas', component: PessoaQueryComponent },
  { path: 'pessoa', component: PessoaCommandComponent },
  { path: 'pessoa/:id', component: PessoaCommandComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
