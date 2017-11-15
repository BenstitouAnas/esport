import { Component, OnInit } from '@angular/core';
import {ConsoleService} from "../../services/console.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-new-console',
  templateUrl: './new-console.component.html',
  styleUrls: ['./new-console.component.css']
})
export class NewConsoleComponent implements OnInit {

  constructor(
    public consoleService: ConsoleService,
    public router: Router
  ) { }

  ngOnInit() {
  }

  onSaveConsole(dataForm){
    this.consoleService.saveConsole(dataForm)
      .subscribe(data => {
        this.router.navigate(['consoles'])
      }, err => {
        console.log(JSON.parse(err).message)
      })
  }

}
