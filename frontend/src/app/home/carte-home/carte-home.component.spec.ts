import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarteHomeComponent } from './carte-home.component';

describe('CarteHomeComponent', () => {
  let component: CarteHomeComponent;
  let fixture: ComponentFixture<CarteHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CarteHomeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarteHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
