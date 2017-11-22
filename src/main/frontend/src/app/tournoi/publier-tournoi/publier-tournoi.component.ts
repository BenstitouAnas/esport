import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TournoiService} from "../../services/tournoi.service";
import {Tournoi} from "../../../models/Tournoi";

import { AgmCoreModule} from "@agm/core";

@Component({
  selector: 'app-publier-tournoi',
  templateUrl: './publier-tournoi.component.html',
  styleUrls: ['./publier-tournoi.component.css']
})
export class PublierTournoiComponent implements OnInit {


  idTournoi:number;
  tournoi: Tournoi = new Tournoi();
  lat: number = 33.706395;
  lng: number = -7.353508;

  TypeTournoi = false;

  enLigne:boolean ;

  constructor(public activatedRoute:ActivatedRoute,
              public router:Router,
              public tournoiService:TournoiService
              ) {
    this.idTournoi = this.activatedRoute.snapshot.params['id'];
  }

  ngOnInit() {
    this.tournoiService.getTournoi(this.idTournoi)
      .subscribe(data =>{
        this.tournoi = data;
      }, err => {
        console.log(err);
      });
  }

  mapClicked($event: any) {
    this.lat = $event.coords.lat
    this.lng = $event.coords.lng
  }

  publier(){

    this.tournoiService.publierTournoi(this.idTournoi, this.lat, this.lng)
      .subscribe(data =>{
        console.log(this.TypeTournoi + ":" + this.lat + " - " + this.lng)
      }, err => {
        console.log(err);
      });
  }

}
