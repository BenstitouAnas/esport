import { Component, OnInit } from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
import {Router} from '@angular/router';
import {Config} from "../../../models/Config";
import swal from 'sweetalert2/dist/sweetalert2.all.min.js';
import {VilleService} from "../../services/ville.service";
import {Ville} from "../../../models/Ville";

@Component({
  selector: 'app-ville',
  templateUrl: './ville.component.html',
  styleUrls: ['./ville.component.css']
})
export class VilleComponent implements OnInit {

  pageVilles:any;
  mot:string="";
  currentPage:number=0;
  size:number=5;

  pages:Array<number>;

  constructor(
    public _http:Http,
    public villeService:VilleService,
    public router:Router,
    public _config: Config
  ) { }

  ngOnInit() {
    this.villeService.getListVilles(this.currentPage, this.size)
      .subscribe(data => {
        this.pageVilles = data;
        this.pages = new Array(data.totalPages);
      }, err => {
        console.log(err);
      })
  }

  doSearch(){
    this.villeService.getVilles(this.mot, this.currentPage, this.size)
      .subscribe(data => {
        this.pageVilles = data;
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

  onEditVille(id:number){
    this.router.navigate(['edit-ville', id]);
  }

  onDeleteVille(ville:Ville){

    swal({
      title: 'Are you sure?',
      text: 'You will not be able to recover this imaginary file!',
      type: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then(()=> this.deleteVille(ville)).then(function(){
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

  deleteVille(ville:Ville){
    this.villeService.deleteVille(ville.id)
      .subscribe(data => {
        this.pageVilles.content.splice(
          this.pageVilles.content.indexOf(ville), 1
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
