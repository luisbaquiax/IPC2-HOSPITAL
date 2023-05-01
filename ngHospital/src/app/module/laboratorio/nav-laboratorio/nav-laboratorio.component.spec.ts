import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavLaboratorioComponent } from './nav-laboratorio.component';

describe('NavLaboratorioComponent', () => {
  let component: NavLaboratorioComponent;
  let fixture: ComponentFixture<NavLaboratorioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavLaboratorioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavLaboratorioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
