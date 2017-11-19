import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewTournoiComponent } from './new-tournoi.component';

describe('NewTournoiComponent', () => {
  let component: NewTournoiComponent;
  let fixture: ComponentFixture<NewTournoiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewTournoiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewTournoiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
