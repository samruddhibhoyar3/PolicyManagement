import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PremiumDueComponent } from './premium-due.component';

describe('PremiumDueComponent', () => {
  let component: PremiumDueComponent;
  let fixture: ComponentFixture<PremiumDueComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PremiumDueComponent]
    });
    fixture = TestBed.createComponent(PremiumDueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
