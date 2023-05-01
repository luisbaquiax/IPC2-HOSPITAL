import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavMedicoComponent } from './nav-medico.component';

describe('NavMedicoComponent', () => {
  let component: NavMedicoComponent;
  let fixture: ComponentFixture<NavMedicoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavMedicoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavMedicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
