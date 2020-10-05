import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Pessoa} from '../model/pessoa';
import {API, httpHeader, userLang} from '../../common';
import {Page} from '../model/page';
import {Pessoafilter} from '../model/pessoafilter';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  constructor(private http: HttpClient) { }

  private URL: string = `${API}/pessoa`;
  private language: string = `language=${userLang}`;

  findAll(filter: Pessoafilter): Observable<Page<Pessoa>>  {

    return this.http.get<Page<any>>(`${this.URL}${filter.build()}`);
  }

  delete(id: number): Observable<number> {

    return this.http.delete<number>(`${this.URL}/${id}?${this.language}`);
  }

  findById(id: number): Observable<any> {

    return this.http.get<any>(`${this.URL}/${id}?${this.language}`);
  }

  insert(pessoa: Pessoa): Observable<Pessoa> {

    return this.http.post<Pessoa>(`${this.URL}/?${this.language}`, pessoa, httpHeader);
  }

  update(pessoa: Pessoa): Observable<Pessoa> {

    return this.http.put<Pessoa>(`${this.URL}/${pessoa.id}?${this.language}`, pessoa, httpHeader);
  }
}
