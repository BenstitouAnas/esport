import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ConsoleComponent } from './console/console/console.component';

import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { AngularMultiSelectModule } from 'angular2-multiselect-dropdown/angular2-multiselect-dropdown';

import {RouterModule, Routes} from '@angular/router';
import {ConsoleService} from "./services/console.service";
import {Config} from "../models/Config";
import { SweetAlertService } from 'ng2-sweetalert2';
import { EditConsoleComponent } from './console/edit-console/edit-console.component';
import { NewConsoleComponent } from './console/new-console/new-console.component';
import { JeuComponent } from './jeu/jeu.component';
import { EditJeuComponent } from './jeu/edit-jeu/edit-jeu.component';
import { NewJeuComponent } from './jeu/new-jeu/new-jeu.component';
import {JeuService} from "./services/jeu.service";
import { OrganisateurComponent } from './utilisateur/organisateur/organisateur/organisateur.component';
import { EditOrganisateurComponent } from './utilisateur/organisateur/edit-organisateur/edit-organisateur.component';
import { NewOrganisateurComponent } from './utilisateur/organisateur/new-organisateur/new-organisateur.component';
import { VilleComponent } from './ville/ville/ville.component';
import { EditVilleComponent } from './ville/edit-ville/edit-ville.component';
import { NewVilleComponent } from './ville/new-ville/new-ville.component';
import {VilleService} from "./services/ville.service";

const appRouter: Routes = [
  {path: 'consoles', component: ConsoleComponent},
  {path: 'edit-console/:id', component: EditConsoleComponent},
  {path: 'new-console', component: NewConsoleComponent},

  {path: 'jeux', component: JeuComponent},
  {path: 'edit-jeu/:id', component: EditJeuComponent},
  {path: 'new-jeu', component: NewJeuComponent},

  {path: 'villes', component: VilleComponent},
  {path: 'edit-ville/:id', component: EditVilleComponent},
  {path: 'new-ville', component: NewVilleComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    ConsoleComponent,
    EditConsoleComponent,
    NewConsoleComponent,
    JeuComponent,
    EditJeuComponent,
    NewJeuComponent,
    OrganisateurComponent,
    EditOrganisateurComponent,
    NewOrganisateurComponent,
    VilleComponent,
    EditVilleComponent,
    NewVilleComponent
  ],
  imports: [
    AngularMultiSelectModule,
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(appRouter),
    FormsModule
  ],
  providers: [
    Config,
    SweetAlertService,
    ConsoleService,
    JeuService,
    VilleService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
