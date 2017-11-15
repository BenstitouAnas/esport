import { Component, OnInit } from '@angular/core';
import {Jeu} from "../../../models/Jeu";
import {ActivatedRoute, Router} from "@angular/router";
import {JeuService} from "../../services/jeu.service";
import swal from 'sweetalert2/dist/sweetalert2.all.min.js';
import {ConsoleService} from "../../services/console.service";

@Component({
  selector: 'app-edit-jeu',
  templateUrl: './edit-jeu.component.html',
  styleUrls: ['./edit-jeu.component.css']
})
export class EditJeuComponent implements OnInit {

  jeu: Jeu = new Jeu();
  idJeu: number
  mode:number = 1;

  allConsoles: Array<Console> = new Array();
  selectedItems: Array<Console> = new Array();
  dropdownSettings = {};

  constructor(
    public consoleService: ConsoleService,
    public activatedRoute: ActivatedRoute,
    public jeuService: JeuService,
    public router: Router
  ) {
    this.idJeu = this.activatedRoute.snapshot.params['id'];
  }

  ngOnInit() {
    this.jeuService.getJeu(this.idJeu)
      .subscribe(data =>{
        this.jeu = data;
        this.selectedItems = this.jeu.consoles;
      }, err => {
        console.log(err);
      });

    this.consoleService.getAllConsoles()
      .subscribe(data => {
        this.allConsoles = data;
      }, err => {
        console.log(err);
      });

    this.dropdownSettings = {
      singleSelection: false,
      text:"Select Console",
      selectAllText:'Select All',
      unSelectAllText:'UnSelect All',
      enableSearchFilter: true,
      classes:"myclass custom-class"
    };
  }

  updateJeu(){
    this.jeuService.updateJeu(this.jeu)
      .subscribe(data => {
        swal(
          'Good job!',
          'You clicked the button!',
          'success'
        )
        this.router.navigate(['jeux']);
      },err => {
        console.log(err);
        swal(
          'Oops...',
          'Something went wrong!',
          'error'
        )
      })
  }

  byType(jeu1:Jeu, jeu2:Jeu): boolean{
    return jeu1 && jeu2 ? jeu1.id === jeu2.id : jeu1 === jeu2;

  }
}
