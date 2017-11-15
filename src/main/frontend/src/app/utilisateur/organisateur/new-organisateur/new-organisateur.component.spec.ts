import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewOrganisateurComponent } from './new-organisateur.component';

describe('NewOrganisateurComponent', () => {
  let component: NewOrganisateurComponent;
  let fixture: ComponentFixture<NewOrganisateurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewOrganisateurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewOrganisateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
