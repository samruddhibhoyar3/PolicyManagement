import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PremiumHistoryComponent } from './premium-history.component';

describe('PremiumHistoryComponent', () => {
  let component: PremiumHistoryComponent;
  let fixture: ComponentFixture<PremiumHistoryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PremiumHistoryComponent]
    });
    fixture = TestBed.createComponent(PremiumHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
