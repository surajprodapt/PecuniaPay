import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatabyidComponent } from './databyid.component';

describe('DatabyidComponent', () => {
  let component: DatabyidComponent;
  let fixture: ComponentFixture<DatabyidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DatabyidComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DatabyidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
