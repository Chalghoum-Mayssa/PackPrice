import { TestBed } from '@angular/core/testing';
import { PriceService } from './pack-price.service';



describe('PackPriceService', () => {
  let service: PriceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PriceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
