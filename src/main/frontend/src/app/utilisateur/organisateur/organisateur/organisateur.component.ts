import { Component, OnInit } from '@angular/core';
import {Http} from "@angular/http";
import {Router} from "@angular/router";

import swal from 'sweetalert2/dist/sweetalert2.all.min.js';
import {OrganisateurService} from "../../../services/organisateur.service";
import {Config} from "../../../../models/Config";
import {Organisateur} from "../../../../models/Organisateur";

@Component({
  selector: 'app-organisateur',
  templateUrl: './organisateur.component.html',
  styleUrls: ['./organisateur.component.css']
})
export class OrganisateurComponent implements OnInit {

  pageOrganisateurs:any;
  mot:string="";
  currentPage:number=0;
  size:number=5;

  pages:Array<number>;

  constructor(
    public _http:Http,
    public organisateurService:OrganisateurService,
    public router:Router,
    public _config: Config
  ) { }

  ngOnInit() {
    this.organisateurService.getListOrganisateurs(this.currentPage, this.size)
      .subscribe(data => {
        this.pageOrganisateurs = data;
        this.pages = new Array(data.totalPages);
      }, err => {
        console.log(err);
      })
  }

  doSearch(){
    this.organisateurService.getOrganisateurs(this.mot, this.currentPage, this.size)
      .subscribe(data => {
        this.pageOrganisateurs = data;
        this.pages = new Array(data.totalPages);
      }, err => {
        console.log(err);
      })
  }

  chercher(){
    this.doSearch();
  }

  goToPage(i:number){
    this.currentPage = i;
    this.doSearch();
  }

  onEditOrganisateur(id:number){
    this.router.navigate(['edit-organisateur', id]);
  }

  onDeleteOrganisateur(organisateur:Organisateur){

    swal({
      title: 'Are you sure?',
      text: 'You will not be able to recover this imaginary file!',
      type: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then(()=> this.deleteOrganisateur(organisateur)).then(function(){
      swal(
        'Deleted!',
        'Your imaginary file has been deleted.',
        'success'
      )
    }, function(dismiss) {
      // dismiss can be 'overlay', 'cancel', 'close', 'esc', 'timer'
      if (dismiss === 'cancel') {
        swal(
          'Cancelled',
          'Your imaginary file is safe :)',
          'error'
        )
      }
    });
  }

  deleteOrganisateur(organisateur:Organisateur){
    this.organisateurService.deleteOrganisateur(organisateur.id)
      .subscribe(data => {
        this.pageOrganisateurs.content.splice(
          this.pageOrganisateurs.content.indexOf(organisateur), 1
        );
      }, err => {
        console.log(err);
      });
  }

  setPageSize(value:any){
    this.size=value;
    this.ngOnInit();
  }
}
