import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Pessoa} from '../model/pessoa';
import {API, httpHeader} from '../../common';
import {Page} from '../model/page';
import {Pessoafilter} from '../model/pessoafilter';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  constructor(private http: HttpClient) { }

  private URL: string = `${API}/pessoa`;

  findAll(filter: Pessoafilter): Observable<Page<Pessoa>>  {

    return this.http.get<Page<any>>(`${this.URL}${filter.build()}`);
  }

  delete(id: number): Observable<number> {

    return this.http.delete<number>(`${this.URL}/${id}`);
  }

  findById(id: number): Observable<any> {

    return this.http.get<any>(`${this.URL}/${id}`);
  }

  insert(pessoa: Pessoa): Observable<Pessoa> {

    return this.http.post<Pessoa>(`${this.URL}/`, pessoa, httpHeader);
  }

  update(pessoa: Pessoa): Observable<Pessoa> {

    return this.http.put<Pessoa>(`${this.URL}/${pessoa.id}`, pessoa, httpHeader);
  }
}
