import { TestBed } from '@angular/core/testing';

import { CurrentResultSetService } from './current-result-set.service';

describe('CurrentResultSetService', () => {
  let service: CurrentResultSetService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CurrentResultSetService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
