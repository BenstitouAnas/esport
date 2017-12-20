import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditActialiteComponent } from './edit-actialite.component';

describe('EditActialiteComponent', () => {
  let component: EditActialiteComponent;
  let fixture: ComponentFixture<EditActialiteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditActialiteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditActialiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
