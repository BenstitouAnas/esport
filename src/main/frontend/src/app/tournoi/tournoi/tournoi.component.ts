import {Component, OnInit, ViewChild} from '@angular/core';
import { Http } from "@angular/http";
import { Router } from "@angular/router";

import swal from 'sweetalert2/dist/sweetalert2.all.min.js';
import {TournoiService} from "../../services/tournoi.service";
import {Config} from "../../../models/Config";
import {Tournoi} from "../../../models/Tournoi";
import { Modal } from 'ngx-modialog/plugins/bootstrap';

import {BsModalComponent} from "ng2-bs3-modal";


@Component({
  selector: 'app-tournoi',
  templateUrl: './tournoi.component.html',
  styleUrls: ['./tournoi.component.css'],

})
export class TournoiComponent implements OnInit {

  pageTournois:any;
  mot:string="";
  currentPage:number=0;
  size:number=5;

  pages:Array<number>;

  constructor(
    public _http:Http,
    public tournoiService:TournoiService,
    public router:Router,
    public _config: Config,
    public modal: Modal
  ) { }

  ngOnInit() {
    this.tournoiService.getListTournois(this.currentPage, this.size)
      .subscribe(data => {
        this.pageTournois = data;
        this.pages = new Array(data.totalPages);
      }, err => {
        console.log(err);
      })
  }

  doSearch(){
    this.tournoiService.getTournois(this.mot, this.currentPage, this.size)
      .subscribe(data => {
        this.pageTournois = data;
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

  onEditTournoi(id:number){
    this.router.navigate(['edit-tournoi', id]);
  }

  onDeleteTournoi(tournoi:Tournoi){

    swal({
      title: 'Are you sure?',
      text: 'You will not be able to recover this imaginary file!',
      type: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then(()=> this.deleteTournoi(tournoi)).then(function(){
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

  deleteTournoi(tournoi:Tournoi){
    this.tournoiService.deleteTournoi(tournoi.id)
      .subscribe(data => {
        this.pageTournois.content.splice(
          this.pageTournois.content.indexOf(tournoi), 1
        );
      }, err => {
        console.log(err);
      });
  }

  setPageSize(value:any){
    this.size=value;
    this.ngOnInit();
  }

   openModal(){
    this.modal.confirm()
      .size('lg')
      .isBlocking(true)
      .showClose(false)
      .keyboard(27)
      .title('Hello World')
      .body('')
      .open();
  }

  nonPublierTournoi(id:number){

    this.router.navigate(['tournois']);

    this.tournoiService.nonPublierTournoi(id)
      .subscribe(data => {
        this.ngOnInit();
      }, err => {
        console.log(err);
      });
  }

  publierTournoi(id:number){
    this.openModal();

    /*this.router.navigate(['tournois']);

    swal({
      title: '',
      html:
      '<app-google-map></app-google-map>',
      showCloseButton: true,
      showCancelButton: true,
      focusConfirm: false,
      confirmButtonText:
        '<i class="fa fa-thumbs-up"></i> Great!',
      confirmButtonAriaLabel: 'Thumbs up, great!',
      cancelButtonText:
        '<i class="fa fa-thumbs-down">Non</i>',
      cancelButtonAriaLabel: 'Thumbs down',
    });*/

    this.tournoiService.publierTournoi(id)
      .subscribe(data => {
        this.ngOnInit();
      }, err => {
        console.log(err);
      });

    /*swal({
      title: 'Publier Tournoi !',
      text: 'Patientez s\'il vous plaît',
      timer: 2000,
      onOpen: function () {
        swal.showLoading()
      }
    }).then(()=> this.tournoiService.publierTournoi(id)).then(function (result) {
      if (result.dismiss === 'timer') {
        console.log('I was closed by the timer')
      }
    })*/
  }

}
