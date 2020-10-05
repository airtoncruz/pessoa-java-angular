import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PessoaQueryComponent } from './pessoa-query.component';

describe('PessoaQueryComponent', () => {
  let component: PessoaQueryComponent;
  let fixture: ComponentFixture<PessoaQueryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PessoaQueryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PessoaQueryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
