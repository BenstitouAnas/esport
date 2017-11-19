import { Component, OnInit } from '@angular/core';
import {Jeu} from "../../../models/Jeu";
import {JeuService} from "../../services/jeu.service";
import {ConsoleService} from "../../services/console.service";
import {TournoiService} from "../../services/tournoi.service";
import {Router} from "@angular/router";
import {Console} from "../../../models/Console";
import {Organisateur} from "../../../models/Organisateur";
import {OrganisateurService} from "../../services/organisateur.service";

@Component({
  selector: 'app-new-tournoi',
  templateUrl: './new-tournoi.component.html',
  styleUrls: ['./new-tournoi.component.css']
})
export class NewTournoiComponent implements OnInit {

  allConsoles: Array<Console> = new Array();
  allJeuxConsoles: Array<Jeu> = new Array();

  selectedConsole = [];
  selectedJeu = [];

  consoleDropdownSettings = {};
  jeuDropdownSettings = {};

  console: Console = new Console();
  jeu: Jeu = new Jeu();
  organisateur: Organisateur = new Organisateur();

  constructor(
    public jeuService: JeuService,
    public consoleService: ConsoleService,
    public tournoiService: TournoiService,
    public organisateursService: OrganisateurService,
    public router: Router
  ) { }

  ngOnInit() {
    this.consoleService.getAllConsoles()
      .subscribe(data => {
        this.allConsoles = data;
      }, err => {
        console.log(err);
      });

    this.organisateursService.getOrganisateur(1)
      .subscribe(data => {
        this.organisateur = data;
      }, err => {
        console.log(err);
      });

    this.consoleDropdownSettings = {
      singleSelection: true,
      text:"Select Console",
      selectAllText:'Select All',
      unSelectAllText:'UnSelect All',
      enableSearchFilter: false,
      classes:"myclass custom-class"
    };

    this.jeuDropdownSettings = {
      singleSelection: true,
      text:"Select Jeu",
      selectAllText:'Select All',
      unSelectAllText:'UnSelect All',
      enableSearchFilter: true,
      classes:"myclass custom-class"
    };
  }

  onSaveTournoi(dataForm){
   dataForm.console = this.console;
   dataForm.jeu = this.jeu;
   dataForm.organisateur = this.organisateur;

    this.tournoiService.saveTournoi(dataForm)
      .subscribe(data => {
        this.router.navigate(['tournois'])
      }, err => {
        console.log(JSON.parse(err).message)
      })

  }

  onConsoleSelect(consol:Console) {
    this.consoleService.getJeux(consol)
      .subscribe(data => {
        this.allJeuxConsoles = data;
      }, err => {
        console.log(err);
      });

    this.console = this.allConsoles.find(c => c.id == consol.id);
  }
  OnConsoleDeSelect(item: any) {
    this.allJeuxConsoles = [];
  }

  onJeuSelect(jeu:Jeu) {
    this.jeu = this.allJeuxConsoles.find(c => c.id == jeu.id);
  }
  OnJeuDeSelect(item: any) {
    //this.allJeuxConsoles = [];
  }

  onSelectAll(items: any) {
    //console.log(items);
  }
  onDeSelectAll(items: any) {
    //console.log(items);
  }

  public showHideNbEquipe:boolean = false;
  public showHideNbJoueurs:boolean = false;

  handleSelectedValue(value) {
    // Get and value and assign it to variable declared above
    if(value == 'equipe'){
      this.showHideNbJoueurs = false;
      this.showHideNbEquipe = true;

    }

    if(value == 'indiv'){
      this.showHideNbEquipe = false;
      this.showHideNbJoueurs = true;
    }
  }

}
