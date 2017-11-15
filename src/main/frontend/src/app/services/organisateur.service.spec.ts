import { TestBed, inject } from '@angular/core/testing';

import { OrganisateurService } from './organisateur.service';

describe('OrganisateurService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OrganisateurService]
    });
  });

  it('should be created', inject([OrganisateurService], (service: OrganisateurService) => {
    expect(service).toBeTruthy();
  }));
});
