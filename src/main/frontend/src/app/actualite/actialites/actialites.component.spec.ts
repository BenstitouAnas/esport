import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActialitesComponent } from './actialites.component';

describe('ActialitesComponent', () => {
  let component: ActialitesComponent;
  let fixture: ComponentFixture<ActialitesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActialitesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActialitesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
