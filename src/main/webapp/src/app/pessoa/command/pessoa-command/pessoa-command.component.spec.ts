import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PessoaCommandComponent } from './pessoa-command.component';

describe('PessoaCommandComponent', () => {
  let component: PessoaCommandComponent;
  let fixture: ComponentFixture<PessoaCommandComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PessoaCommandComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PessoaCommandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
