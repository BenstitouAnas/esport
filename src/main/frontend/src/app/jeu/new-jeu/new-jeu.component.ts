import { Component, OnInit } from '@angular/core';
import {JeuService} from "../../services/jeu.service";
import {Router} from "@angular/router";
import {ConsoleService} from "../../services/console.service";
import {Console} from "../../../models/Console";

@Component({
  selector: 'app-new-jeu',
  templateUrl: './new-jeu.component.html',
  styleUrls: ['./new-jeu.component.css']
})
export class NewJeuComponent implements OnInit {

  allConsoles: Array<Console> = new Array();
  selectedItems = [];
  dropdownSettings = {};

  constructor(
    public jeuService: JeuService,
    public consoleService: ConsoleService,
    public router: Router
  ) { }

  ngOnInit() {
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

  onSaveJeu(dataForm){
    this.jeuService.saveJeu(dataForm)
      .subscribe(data => {
        this.router.navigate(['jeux'])
      }, err => {
        console.log(JSON.parse(err).message)
      })
  }

  onItemSelect(item: any) {
    //console.log(item);
    //console.log(this.selectedItems);
  }
  OnItemDeSelect(item: any) {
    //console.log(item);
    //console.log(this.selectedItems);
  }
  onSelectAll(items: any) {
    //console.log(items);
  }
  onDeSelectAll(items: any) {
    //console.log(items);
  }

}
