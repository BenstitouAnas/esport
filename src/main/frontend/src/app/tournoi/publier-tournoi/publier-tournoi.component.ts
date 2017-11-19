import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TournoiService} from "../../services/tournoi.service";
import {Tournoi} from "../../../models/Tournoi";

@Component({
  selector: 'app-publier-tournoi',
  templateUrl: './publier-tournoi.component.html',
  styleUrls: ['./publier-tournoi.component.css']
})
export class PublierTournoiComponent implements OnInit {


  idTournoi:number;
  tournoi: Tournoi = new Tournoi();
  lat: number = 51.678418;
  lng: number = 7.809007;

  enLigne:boolean = true;

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

    console.log(this.lat + " - " + this.lng)

  }

}
