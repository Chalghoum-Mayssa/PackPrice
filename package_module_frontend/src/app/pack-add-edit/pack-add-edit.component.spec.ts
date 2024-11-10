import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PackAddEditComponent } from './pack-add-edit.component';

describe('PackAddEditComponent', () => {
  let component: PackAddEditComponent;
  let fixture: ComponentFixture<PackAddEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PackAddEditComponent]
    });
    fixture = TestBed.createComponent(PackAddEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
