import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResigtrationComponent } from './resigtration.component';

describe('ResigtrationComponent', () => {
  let component: ResigtrationComponent;
  let fixture: ComponentFixture<ResigtrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResigtrationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResigtrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
