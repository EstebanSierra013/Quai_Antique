import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GaleryHomeComponent } from './galery-home.component';

describe('GaleryHomeComponent', () => {
  let component: GaleryHomeComponent;
  let fixture: ComponentFixture<GaleryHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GaleryHomeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GaleryHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
