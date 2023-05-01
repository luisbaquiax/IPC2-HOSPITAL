import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddInformacionMedicoComponent } from './add-informacion-medico.component';

describe('AddInformacionMedicoComponent', () => {
  let component: AddInformacionMedicoComponent;
  let fixture: ComponentFixture<AddInformacionMedicoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddInformacionMedicoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddInformacionMedicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
