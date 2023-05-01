import { TestBed } from '@angular/core/testing';

import { ServiceEspecialidadService } from './service-especialidad.service';

describe('ServiceEspecialidadService', () => {
  let service: ServiceEspecialidadService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceEspecialidadService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
