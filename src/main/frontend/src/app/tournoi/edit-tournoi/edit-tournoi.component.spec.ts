import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditTournoiComponent } from './edit-tournoi.component';

describe('EditTournoiComponent', () => {
  let component: EditTournoiComponent;
  let fixture: ComponentFixture<EditTournoiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditTournoiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditTournoiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
