import {Component, OnInit} from '@angular/core';
import {PessoaService} from '../../service/pessoa.service';
import {Router} from '@angular/router';
import {Pessoa} from '../../model/pessoa';
import {MatDialog, MatTableDataSource} from '@angular/material';
import {Pessoafilter} from '../../model/pessoafilter';

@Component({
  selector: 'app-pessoa-query',
  templateUrl: './pessoa-query.component.html',
  styleUrls: ['./pessoa-query.component.css']
})
export class PessoaQueryComponent implements OnInit {

  displayedColumns = ['id', 'dsNome', 'cpf', 'dtNascimento', 'email', 'foto', 'actions'];

  dataSource: MatTableDataSource<Pessoa>;

  pessoas: Pessoa[];

  panelOpenState = false;

  filter: Pessoafilter = new Pessoafilter();

  constructor(private service: PessoaService, private router: Router, private dialog: MatDialog) {
  }

  ngOnInit() {

    this.load();
  }

  load() {

    this.service.findAll(this.filter).subscribe(data => {

      this.filter.totalElements = data.totalElements;

      this.dataSource = new MatTableDataSource(data.content);

    });
  }

  onCLickAlterar = (pessoa: Pessoa) => this.router.navigate([`/pessoa/${pessoa.id}`]);

  onCLickExcluir(pessoa: Pessoa) {

    this.service.delete(pessoa.id).subscribe(res => {

      this.load();
    });
  }

  loadPage(event) {

    this.filter.page = event.pageIndex;

    this.load();
  }
}
