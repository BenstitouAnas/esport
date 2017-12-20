import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewActialiteComponent } from './new-actialite.component';

describe('NewActialiteComponent', () => {
  let component: NewActialiteComponent;
  let fixture: ComponentFixture<NewActialiteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewActialiteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewActialiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
