import { TestBed, inject } from '@angular/core/testing';

import { MyService } from './image.service';

describe('ImageService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MyService]
    });
  });

  it('should be created', inject([MyService], (service: MyService) => {
    expect(service).toBeTruthy();
  }));
});
