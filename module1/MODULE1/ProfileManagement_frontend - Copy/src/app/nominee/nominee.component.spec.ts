import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NomineeComponent } from './nominee.component';

describe('NomineeComponent', () => {
  let component: NomineeComponent;
  let fixture: ComponentFixture<NomineeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NomineeComponent]
    });
    fixture = TestBed.createComponent(NomineeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
