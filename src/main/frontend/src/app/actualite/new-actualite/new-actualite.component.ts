import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {actService} from "../../services/Actualite.service";
import {jrnService} from "../../services/Journaliste.service";
import {Journaliste} from "../../../models/Journaliste";

@Component({
  selector: 'app-new-actualite',
  templateUrl: './new-actualite.component.html',
  styleUrls: ['./new-actualite.component.css']
})
export class NewActualiteComponent implements OnInit {

  journaliste: Journaliste = new Journaliste();

  constructor(
    public actualiteService: actService,
    public journalistesService: jrnService,
    public router: Router
  ) { }

  ngOnInit() {

    this.journalistesService.getJournaliste(1)
      .subscribe(data => {
        this.journaliste = data;
      }, err => {
        console.log(err);
      });
  }

  onSaveActualite(dataForm){

    this.actualiteService.saveActualite(dataForm)
      .subscribe(data => {
        this.router.navigate(['tournois'])
      }, err => {
        console.log(JSON.parse(err).message)
      })

  }


  public type:string;
  public showHideNbEquipe:boolean = false;
  public showHideNbJoueurs:boolean = false;

}
