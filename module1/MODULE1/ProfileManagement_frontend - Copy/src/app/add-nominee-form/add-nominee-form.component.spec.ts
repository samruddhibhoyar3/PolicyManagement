import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNomineeFormComponent } from './add-nominee-form.component';

describe('AddNomineeFormComponent', () => {
  let component: AddNomineeFormComponent;
  let fixture: ComponentFixture<AddNomineeFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddNomineeFormComponent]
    });
    fixture = TestBed.createComponent(AddNomineeFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
