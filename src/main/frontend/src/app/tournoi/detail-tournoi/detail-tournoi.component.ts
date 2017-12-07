import { Component, OnInit } from '@angular/core';
import {Tournoi} from "../../../models/Tournoi";
import {TournoiService} from "../../services/tournoi.service";
import {ActivatedRoute, Router} from "@angular/router";
import swal from 'sweetalert2/dist/sweetalert2.all.min.js';

@Component({
  selector: 'app-tournoi',
  templateUrl: './detail-tournoi.component.html',
  styleUrls: ['./detail-tournoi.component.scss'],

})
export class DetailTournoiComponent implements OnInit {

  tournoi: Tournoi = new Tournoi();
  idTournoi: number
  numberOfMatchs:number
  mode:number = 1;
  numbers : Array<number> = new Array();
  matchs : Array<number> = new Array();
  constructor(
    public tournoiService: TournoiService,
    public activatedRoute: ActivatedRoute,
    public router: Router
  ) {
    this.idTournoi = this.activatedRoute.snapshot.params['id'];
  }

  ngOnInit() {
    this.tournoiService.getTournoi(this.idTournoi)
      .subscribe(data =>{
        console.log(data);
        this.tournoi = data;
        if(this.tournoi.type == "indiv")
          this.numbers = Array.from(Array(this.tournoi.nbJoueurs/2)).map((x, i) => i );
        else
          this.numbers = Array.from(Array(this.tournoi.nbEquipes/2)).map((x, i) => i );
      }, err => {
        console.log(err);
      });
  }
  diviseTeams(){
   this.numberOfMatchs = 0
    var temp = this.numbers.length
    var i
    for(i = temp;i >= 0 ; i--) {
      if (i % 2 != 0)
        i = (i-1) / 2;
      else
        i = i / 2;
      this.numberOfMatchs++;
    }
    this.matchs = Array.from(Array(this.numberOfMatchs)).map((x, i) => i );
   return true;

  }
  cutTeams()
  {
    if(this.numbers.length == 0){
      this.numbers = []
    }
    if (this.numbers.length % 2 != 0)
      this.numbers.length = (this.numbers.length-1) / 2;
    else
      this.numbers.length = this.numbers.length / 2;
    return true;
  }


}
