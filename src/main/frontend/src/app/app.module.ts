import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ConsoleComponent } from './console/console/console.component';

import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { AngularMultiSelectModule } from 'angular2-multiselect-dropdown/angular2-multiselect-dropdown';

import { RouterModule, Routes } from '@angular/router';
import { ConsoleService } from './services/console.service';
import { Config } from '../models/Config';
import { SweetAlertService } from 'ng2-sweetalert2';
import { EditConsoleComponent } from './console/edit-console/edit-console.component';
import { NewConsoleComponent } from './console/new-console/new-console.component';
import { JeuComponent } from './jeu/jeu.component';
import { EditJeuComponent } from './jeu/edit-jeu/edit-jeu.component';
import { NewJeuComponent } from './jeu/new-jeu/new-jeu.component';
import { JeuService } from './services/jeu.service';

import { OrganisateurComponent } from './utilisateur/organisateur/organisateur/organisateur.component';
import { EditOrganisateurComponent } from './utilisateur/organisateur/edit-organisateur/edit-organisateur.component';
import { NewOrganisateurComponent } from './utilisateur/organisateur/new-organisateur/new-organisateur.component';
import { VilleComponent } from './ville/ville/ville.component';
import { EditVilleComponent } from './ville/edit-ville/edit-ville.component';
import { NewVilleComponent } from './ville/new-ville/new-ville.component';
import { VilleService } from './services/ville.service';
import { OrganisateurService } from './services/organisateur.service';
import { DetailTournoiComponent } from './tournoi/detail-tournoi/detail-tournoi.component';
import { TournoiComponent } from './tournoi/tournoi/tournoi.component';
import { EditTournoiComponent } from './tournoi/edit-tournoi/edit-tournoi.component';
import { NewTournoiComponent } from './tournoi/new-tournoi/new-tournoi.component';
import { TournoiService } from './services/tournoi.service';
import { UiSwitchModule } from '../../node_modules/angular2-ui-switch/src';
import {CommonModule} from '@angular/common';

import { AgmCoreModule } from '@agm/core';
import { ModalModule } from 'ngx-modialog';
import { BootstrapModalModule } from 'ngx-modialog/plugins/bootstrap';
import { GoogleMapComponent } from './util/google-map/google-map.component';
import {BsModalModule} from 'ng2-bs3-modal';
import { PublierTournoiComponent } from './tournoi/publier-tournoi/publier-tournoi.component';
import { SidebarModule } from './sidebar/sidebar.module';
import { FooterModule } from './shared/footer/footer.module';
import { NavbarModule} from './shared/navbar/navbar.module';
import { FixedPluginModule} from './shared/fixedplugin/fixedplugin.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserComponent } from './user/user.component';
import { TableComponent } from './table/table.component';
import { TypographyComponent } from './typography/typography.component';
import { IconsComponent } from './icons/icons.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { UpgradeComponent } from './upgrade/upgrade.component';
import { JournalistesComponent } from './utilisateur/journaliste/journalistes/journalistes.component';
import { EditJournalistesComponent } from './utilisateur/journaliste/edit-journalistes/edit-journalistes.component';
import { NewJournalistesComponent } from './utilisateur/journaliste/new-journalistes/new-journalistes.component';
import {JournalisteService} from './services/journaliste.service';
import { ActialitesComponent } from './actualite/actialites/actialites.component';
import { NewActialiteComponent } from './actualite/new-actialite/new-actialite.component';
import { EditActialiteComponent } from './actualite/edit-actialite/edit-actialite.component';
import {ActualiteService} from "./services/actualite.service";
import {JoueurService} from "./services/joueur.service";
import { BoutiqueComponent } from './boutique/boutique.component';
import {ProduitsService} from "./services/produits.service";
import { MessagerieComponent } from './messagerie/messagerie.component';
import { HomeComponent } from './home/home/home.component';
import { LoginComponent } from './login/login/login.component';
import { RegisterComponent } from './register/register/register.component';
import {AuthGuard} from "./_guards/auth.guard";
import {AlertService} from "./_services/alert.service";
import {AuthenticationService} from "./_services/authentication.service";
import {UserService} from "./_services/user.service";
import {JwtInterceptor} from "./_helpers/jwt.interceptor";
import {fakeBackendProvider} from "./_helpers/fake-backend";
import {AlertComponent} from "./_directives/alert.component";
import {HttpClientModule} from "@angular/common/http";
import {routing} from "./app.routing";

import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { MesmatchesComponent } from './mesmatches/mesmatches.component';


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
    NewVilleComponent,
    TournoiComponent,
    EditTournoiComponent,
    NewTournoiComponent,
    GoogleMapComponent,
    PublierTournoiComponent,
    DashboardComponent,
    UserComponent,
    TableComponent,
    TypographyComponent,
    IconsComponent,
    DetailTournoiComponent,
    NotificationsComponent,
    UpgradeComponent,
    JournalistesComponent,
    EditJournalistesComponent,
    NewJournalistesComponent,
    ActialitesComponent,
    NewActialiteComponent,
    EditActialiteComponent,
    BoutiqueComponent,
    MessagerieComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,

    AppComponent,
    AlertComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    MesmatchesComponent
  ],
  imports: [
    AngularMultiSelectModule,
    BrowserModule,
    HttpModule,
    FormsModule,
    UiSwitchModule,
    CommonModule,
    SidebarModule,
    NavbarModule,
    FooterModule,
    FixedPluginModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyBhPDxeKaJmieOUn7oniGrD9tFKAC4yOsg'
    }),
    ModalModule.forRoot(),
    BootstrapModalModule,
    BsModalModule,

    BrowserModule,
    FormsModule,
    HttpClientModule,
    routing
  ],
  providers: [
    Config,
    SweetAlertService,
    ConsoleService,
    JeuService,
    VilleService,
    OrganisateurService,
    JournalisteService,
    ActualiteService,
    TournoiService,
    JoueurService,
    ProduitsService,

    AuthGuard,
    AlertService,
    AuthenticationService,
    UserService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptor,
      multi: true
    },

    // provider used to create fake backend
    fakeBackendProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
