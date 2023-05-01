import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistorialPorcentajesComponent } from './historial-porcentajes.component';

describe('HistorialPorcentajesComponent', () => {
  let component: HistorialPorcentajesComponent;
  let fixture: ComponentFixture<HistorialPorcentajesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HistorialPorcentajesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HistorialPorcentajesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
