import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DonorDetailsComponent } from './donor-detail.component';

describe('DonorDetailComponent', () => {
  let component: DonorDetailsComponent;
  let fixture: ComponentFixture<DonorDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DonorDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DonorDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
