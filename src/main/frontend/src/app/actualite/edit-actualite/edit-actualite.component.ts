import { Component, OnInit } from '@angular/core';
import {Tournoi} from "../../../models/Tournoi";
import {TournoiService} from "../../services/tournoi.service";
import {ActivatedRoute, Router} from "@angular/router";
import swal from 'sweetalert2/dist/sweetalert2.all.min.js';

@Component({
  selector: 'app-edit-actualite',
  templateUrl: './edit-actualite.component.html',
  styleUrls: ['./edit-actualite.component.css']
})
export class EditActualiteComponent implements OnInit {

  tournoi: Tournoi = new Tournoi();
  idTournoi: number
  mode:number = 1;

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
        this.tournoi = data;
      }, err => {
        console.log(err);
      });
  }

  updateTournoi(){
    console.log(this.tournoi);
    this.tournoiService.updateTournoi(this.tournoi)
      .subscribe(data => {
        swal(
          'Good job!',
          'You clicked the button!',
          'success'
        )
        this.router.navigate(['tournois']);
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
