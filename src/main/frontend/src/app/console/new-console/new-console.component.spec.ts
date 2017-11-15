import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewConsoleComponent } from './new-console.component';

describe('NewConsoleComponent', () => {
  let component: NewConsoleComponent;
  let fixture: ComponentFixture<NewConsoleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewConsoleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewConsoleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
