import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentformComponent } from './paymentform.component';

describe('PaymentformComponent', () => {
  let component: PaymentformComponent;
  let fixture: ComponentFixture<PaymentformComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PaymentformComponent]
    });
    fixture = TestBed.createComponent(PaymentformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
