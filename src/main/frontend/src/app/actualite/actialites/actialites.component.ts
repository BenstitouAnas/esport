import { Component, OnInit } from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
import {Router} from '@angular/router';
import {Config} from "../../../models/Config";
import swal from 'sweetalert2/dist/sweetalert2.all.min.js';
import {ActualiteService} from "../../services/actualite.service";
import {Actualite} from "../../../models/Actualite";

@Component({
  selector: 'app-actialites',
  templateUrl: './actialites.component.html',
  styleUrls: ['./actialites.component.css']
})
export class ActialitesComponent implements OnInit {

  pageActualites:any;
  mot:string="";
  currentPage:number=0;
  size:number=5;

  pages:Array<number>;

  constructor(
    public _http:Http,
    public actualiteService:ActualiteService,
    public router:Router,
    public _config: Config
  ) { }

  ngOnInit() {
    this.actualiteService.getListActualites(this.currentPage, this.size)
      .subscribe(data => {
        this.pageActualites = data;
        this.pages = new Array(data.totalPages);
      }, err => {
        console.log(err);
      })
  }

  doSearch(){
    this.actualiteService.getActualites(this.mot, this.currentPage, this.size)
      .subscribe(data => {
        this.pageActualites = data;
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

  onEditActualite(id:number){
    this.router.navigate(['edit-actualite', id]);
  }

  onDeleteActualite(act:Actualite){

    swal({
      title: 'Are you sure?',
      text: 'You will not be able to recover this imaginary file!',
      type: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then(()=> this.deleteActualite(act)).then(function(){
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

  deleteActualite(act:Actualite){
    this.actualiteService.deleteActualite(act.id)
      .subscribe(data => {
        this.pageActualites.content.splice(
          this.pageActualites.content.indexOf(act), 1
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
