import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegionAddComponent } from './region-add.component';

describe('RegionAddComponent', () => {
  let component: RegionAddComponent;
  let fixture: ComponentFixture<RegionAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegionAddComponent]
    });
    fixture = TestBed.createComponent(RegionAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
