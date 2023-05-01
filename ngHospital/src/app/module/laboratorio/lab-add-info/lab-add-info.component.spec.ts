import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LabAddInfoComponent } from './lab-add-info.component';

describe('LabAddInfoComponent', () => {
  let component: LabAddInfoComponent;
  let fixture: ComponentFixture<LabAddInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LabAddInfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LabAddInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
