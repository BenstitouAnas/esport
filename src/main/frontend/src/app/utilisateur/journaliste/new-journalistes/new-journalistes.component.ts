import { Component, OnInit } from '@angular/core';
import {JournalisteService} from "../../../services/journaliste.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-new-journalistes',
  templateUrl: './new-journalistes.component.html',
  styleUrls: ['./new-journalistes.component.css']
})
export class NewJournalistesComponent implements OnInit {

  constructor(
    public journalisteService: JournalisteService,
    public router: Router
  ) { }

  ngOnInit() {
  }

  onSaveConsole(dataForm){
    this.journalisteService.saveJournalist(dataForm)
      .subscribe(data => {
        this.router.navigate(['journalistes'])
      }, err => {
        console.log(JSON.parse(err).message)
      })
  }
}
