import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditJournalistesComponent } from './edit-journalistes.component';

describe('EditJournalistesComponent', () => {
  let component: EditJournalistesComponent;
  let fixture: ComponentFixture<EditJournalistesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditJournalistesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditJournalistesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
