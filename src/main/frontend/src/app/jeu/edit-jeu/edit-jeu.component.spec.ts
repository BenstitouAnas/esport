import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditJeuComponent } from './edit-jeu.component';

describe('EditJeuComponent', () => {
  let component: EditJeuComponent;
  let fixture: ComponentFixture<EditJeuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditJeuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditJeuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
