import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PublierTournoiComponent } from './publier-tournoi.component';

describe('PublierTournoiComponent', () => {
  let component: PublierTournoiComponent;
  let fixture: ComponentFixture<PublierTournoiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PublierTournoiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PublierTournoiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
