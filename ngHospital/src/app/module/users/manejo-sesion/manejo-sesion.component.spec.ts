import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManejoSesionComponent } from './manejo-sesion.component';

describe('ManejoSesionComponent', () => {
  let component: ManejoSesionComponent;
  let fixture: ComponentFixture<ManejoSesionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManejoSesionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManejoSesionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
