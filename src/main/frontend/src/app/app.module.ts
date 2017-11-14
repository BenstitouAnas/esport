import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ConsoleComponent } from './console/console/console.component';

import {RouterModule, Routes} from '@angular/router';

const appRouter: Routes = [
  {path: 'consoles', component: ConsoleComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    ConsoleComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
