import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewJeuComponent } from './new-jeu.component';

describe('NewJeuComponent', () => {
  let component: NewJeuComponent;
  let fixture: ComponentFixture<NewJeuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewJeuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewJeuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
