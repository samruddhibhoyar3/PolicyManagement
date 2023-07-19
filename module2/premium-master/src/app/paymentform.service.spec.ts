import { TestBed } from '@angular/core/testing';

import { PaymentformService } from './paymentform.service';

describe('PaymentformService', () => {
  let service: PaymentformService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PaymentformService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
