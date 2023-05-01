import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavAdmin } from './nav.component';

describe('NavComponent', () => {
  let component: NavAdmin;
  let fixture: ComponentFixture<NavAdmin>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavAdmin ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavAdmin);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
