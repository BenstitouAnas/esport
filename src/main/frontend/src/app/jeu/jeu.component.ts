import { Component, OnInit } from '@angular/core';
import {Http} from "@angular/http";
import {JeuService} from "../services/jeu.service";
import {Router} from "@angular/router";
import {Config} from "../../models/Config";
import {Jeu} from "../../models/Jeu";

import swal from 'sweetalert2/dist/sweetalert2.all.min.js';

@Component({
  selector: 'app-jeu',
  templateUrl: './jeu.component.html',
  styleUrls: ['./jeu.component.css']
})
export class JeuComponent implements OnInit {

  pageJeux:any;
  mot:string="";
  currentPage:number=0;
  size:number=5;

  pages:Array<number>;

  constructor(
    public _http:Http,
    public jeuService:JeuService,
    public router:Router,
    public _config: Config
  ) { }

  ngOnInit() {
    this.jeuService.getListJeux(this.currentPage, this.size)
      .subscribe(data => {
        this.pageJeux = data;
        this.pages = new Array(data.totalPages);
      }, err => {
        console.log(err);
      })
  }

  doSearch(){
    this.jeuService.getJeux(this.mot, this.currentPage, this.size)
      .subscribe(data => {
        this.pageJeux = data;
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

  onEditJeu(id:number){
    this.router.navigate(['edit-jeu', id]);
  }

  onDeleteJeu(jeu:Jeu){

    swal({
      title: 'Are you sure?',
      text: 'You will not be able to recover this imaginary file!',
      type: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then(()=> this.deleteJeu(jeu)).then(function(){
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

  deleteJeu(jeu:Jeu){
    this.jeuService.deleteJeu(jeu.id)
      .subscribe(data => {
        this.pageJeux.content.splice(
          this.pageJeux.content.indexOf(jeu), 1
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
