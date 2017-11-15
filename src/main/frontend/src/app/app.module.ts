import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ConsoleComponent } from './console/console/console.component';

import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import {RouterModule, Routes} from '@angular/router';
import {ConsoleService} from "./services/console.service";
import {Config} from "../models/Config";
import { SweetAlertService } from 'ng2-sweetalert2';
import { EditConsoleComponent } from './console/edit-console/edit-console.component';
import { NewConsoleComponent } from './console/new-console/new-console.component';
import { JeuComponent } from './jeu/jeu.component';
import { EditJeuComponent } from './jeu/edit-jeu/edit-jeu.component';

const appRouter: Routes = [
  {path: 'consoles', component: ConsoleComponent},
  {path: 'edit-console/:id', component: EditConsoleComponent},
  {path: 'new-console', component: NewConsoleComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ConsoleComponent,
    EditConsoleComponent,
    NewConsoleComponent,
    JeuComponent,
    EditJeuComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(appRouter),
    FormsModule
  ],
  providers: [ConsoleService, Config, SweetAlertService],
  bootstrap: [AppComponent]
})
export class AppModule { }
