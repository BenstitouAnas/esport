import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import { VilleService } from "../../services/ville.service";
import { Ville} from "../../../models/Ville";
import swal from 'sweetalert2/dist/sweetalert2.all.min.js';

@Component({
  selector: 'app-edit-ville',
  templateUrl: './edit-ville.component.html',
  styleUrls: ['./edit-ville.component.css']
})
export class EditVilleComponent implements OnInit {

  ville: Ville = new Ville();
  idVille: number
  mode:number = 1;

  constructor(
    public activatedRoute: ActivatedRoute,
    public villeService: VilleService,
    public router: Router
  ) {

    this.idVille = this.activatedRoute.snapshot.params['id'];
  }

  ngOnInit() {
    this.villeService.getVille(this.idVille)
      .subscribe(data =>{
        this.ville = data;
      }, err => {
        console.log(err);
      })
  }

  updateVille(){
    this.villeService.updateVille(this.ville)
      .subscribe(data => {
        swal(
          'Good job!',
          'You clicked the button!',
          'success'
        )
        this.router.navigate(['villes']);
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
