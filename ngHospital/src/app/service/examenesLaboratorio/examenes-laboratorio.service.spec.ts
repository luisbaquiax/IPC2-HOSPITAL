import { TestBed } from '@angular/core/testing';

import { ExamenesLaboratorioService } from './examenes-laboratorio.service';

describe('ExamenesLaboratorioService', () => {
  let service: ExamenesLaboratorioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExamenesLaboratorioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
