import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditOrganisateurComponent } from './edit-organisateur.component';

describe('EditOrganisateurComponent', () => {
  let component: EditOrganisateurComponent;
  let fixture: ComponentFixture<EditOrganisateurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditOrganisateurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditOrganisateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
