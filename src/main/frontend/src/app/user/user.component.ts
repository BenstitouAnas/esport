import { Component, OnInit } from '@angular/core';


import {ActivatedRoute, Router} from "@angular/router";
import swal from 'sweetalert2/dist/sweetalert2.all.min.js';
import {Organisateur} from "../../models/Organisateur";
import {OrganisateurService} from "../services/organisateur.service";

@Component({
    selector: 'user-cmp',
    moduleId: module.id,
    templateUrl: 'user.component.html'
})

export class UserComponent implements OnInit{

  organisateur: Organisateur = new Organisateur();
  idUser: number;

  constructor(
    public organisateurService: OrganisateurService,
    public activatedRoute: ActivatedRoute,
    public router: Router
  ) {
    this.idUser = this.activatedRoute.snapshot.params['id'];
  }

  ngOnInit() {
    this.organisateurService.getOrganisateur(this.idUser)
      .subscribe(data =>{
        this.organisateur = data;
        console.log(this.organisateur);
      }, err => {
        console.log(err);
      });
  }

  updateOrganisateur(){
    console.log(this.organisateur);
    this.organisateur.updated_at = new Date();
    this.organisateurService.updateOrganisateur(this.organisateur)
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
