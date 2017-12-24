import { TestBed, inject } from '@angular/core/testing';

import { JournalisteService } from './journaliste.service';

describe('JournalisteService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [JournalisteService]
    });
  });

  it('should be created', inject([JournalisteService], (service: JournalisteService) => {
    expect(service).toBeTruthy();
  }));
});
