import {Component, OnInit} from '@angular/core';
declare var $:any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'app';

  isAuthenticatedUser: boolean = false;

  ngOnInit(){
    if (localStorage.getItem('currentUser')) {
      // logged in so return true
      this.isAuthenticatedUser = true;
    }
  }

}
