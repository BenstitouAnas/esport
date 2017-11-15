import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ConsoleService} from "../../services/console.service";
import {Console} from "../../../models/Console";
import swal from 'sweetalert2/dist/sweetalert2.all.min.js';

@Component({
  selector: 'app-edit-console',
  templateUrl: './edit-console.component.html',
  styleUrls: ['./edit-console.component.css']
})
export class EditConsoleComponent implements OnInit {

  consol: Console = new Console();
  idConsole: number
  mode:number = 1;

  constructor(
    public activatedRoute: ActivatedRoute,
    public consoleService: ConsoleService,
    public router: Router
  ) {

    this.idConsole = this.activatedRoute.snapshot.params['id'];
  }

  ngOnInit() {
    this.consoleService.getConsole(this.idConsole)
      .subscribe(data =>{
          this.consol = data;
        }, err => {
        console.log(err);
      })
  }

  updateConsole(){
    this.consoleService.updateConsole(this.consol)
      .subscribe(data => {
        swal(
          'Good job!',
          'You clicked the button!',
          'success'
        )
        this.router.navigate(['consoles']);
      },err => {
        console.log(err);
        swal(
          'Oops...',
          'Something went wrong!',
          'error'
        )
      })
  }

}
