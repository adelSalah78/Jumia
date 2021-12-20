import { TestBed } from '@angular/core/testing';

import { SearchNumbersService } from './search-numbers.service';

describe('SearchNumbersService', () => {
  let service: SearchNumbersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SearchNumbersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
