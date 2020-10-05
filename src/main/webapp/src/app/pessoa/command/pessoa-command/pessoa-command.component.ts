import { Component, OnInit } from '@angular/core';
import {Pessoa} from '../../model/pessoa';
import {ActivatedRoute, Router} from '@angular/router';
import {PessoaService} from '../../service/pessoa.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-pessoa-command',
  templateUrl: './pessoa-command.component.html',
  styleUrls: ['./pessoa-command.component.css']
})
export class PessoaCommandComponent implements OnInit {

  form: FormGroup;
  emailRegx = /^(([^<>+()\[\]\\.,;:\s@"-#$%&=]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,3}))$/;
  datemask = [/\d/, /\d/, '/', /\d/, /\d/, '/', /\d/, /\d/, /\d/, /\d/];

  pessoa: Pessoa = new Pessoa();

  constructor(private route: ActivatedRoute,
              private service: PessoaService,
              private formBuilder: FormBuilder,
              private router: Router,) { }

  ngOnInit() {

    this.form = this.formBuilder.group({
      dsNome: [null, [Validators.required, Validators.minLength(1), Validators.maxLength(150)]],
      cpf:[null, [Validators.required]],
      email: [null, [Validators.required, Validators.pattern(this.emailRegx), Validators.maxLength(400)]],
      dtNascimento: [null]
    });

    this.pessoa.id = +this.route.snapshot.paramMap.get('id');

    if (this.idValidation(this.pessoa.id)) {

      this.service.findById(this.pessoa.id).subscribe(data => {

        this.pessoa = data;
      });
    }
  }

  submit() {

    if (this.form.valid) {

      this.pessoa.dtNascimento = this.pessoa.dtNascimento.split('/').join('-');

      if (this.idValidation(this.pessoa.id)) {
        this.service.update(this.pessoa).subscribe(res => {

            this.router.navigate([`/pessoas`]);
        });

      } else {
        this.service.insert(this.pessoa).subscribe(res => {

          this.router.navigate([`/pessoas`]);
        });
      }
    }
  }

  idValidation = (id: number): boolean => {

    return id && typeof id === 'number' && !Number.isNaN(id) && id > 0 && Number.isInteger(id);
  }

}
