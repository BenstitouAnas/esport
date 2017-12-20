import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import swal from 'sweetalert2/dist/sweetalert2.all.min.js';
import {JournalisteService} from "../../../services/journaliste.service";
import {Journaliste} from "../../../../models/Journaliste";

@Component({
  selector: 'app-edit-journalistes',
  templateUrl: './edit-journalistes.component.html',
  styleUrls: ['./edit-journalistes.component.css']
})
export class EditJournalistesComponent implements OnInit {

  journaliste: Journaliste = new Journaliste();
  idConsole: number
  mode:number = 1;

  constructor(
    public activatedRoute: ActivatedRoute,
    public journalisteService: JournalisteService,
    public router: Router
  ) {

    this.idConsole = this.activatedRoute.snapshot.params['id'];
  }

  ngOnInit() {
    this.journalisteService.getJournalist(this.idConsole)
      .subscribe(data =>{
        this.journaliste = data;
      }, err => {
        console.log(err);
      })
  }

  updateConsole(){
    this.journalisteService.updateJournalist(this.journaliste)
      .subscribe(data => {
        swal(
          'Good job!',
          'You clicked the button!',
          'success'
        )
        this.router.navigate(['journalistes']);
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
