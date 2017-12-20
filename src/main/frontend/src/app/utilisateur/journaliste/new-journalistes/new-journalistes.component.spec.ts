import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewJournalistesComponent } from './new-journalistes.component';

describe('NewJournalistesComponent', () => {
  let component: NewJournalistesComponent;
  let fixture: ComponentFixture<NewJournalistesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewJournalistesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewJournalistesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
