import {Component, OnInit, ViewChild} from '@angular/core';
import { Http } from "@angular/http";
import { Router } from "@angular/router";

import swal from 'sweetalert2/dist/sweetalert2.all.min.js';
import {TournoiService} from "../../services/tournoi.service";
import {Config} from "../../../models/Config";
import {Tournoi} from "../../../models/Tournoi";
import { Modal } from 'ngx-modialog/plugins/bootstrap';

import {BsModalComponent} from "ng2-bs3-modal";

declare var jquery:any;
declare var $ :any;

@Component({
  selector: 'app-actualite',
  templateUrl: './actualite.component.html',
  styleUrls: ['./actualite.component.css'],

})
export class ActualiteComponent implements OnInit {

  pageTournois:any;
  mot:string="";
  currentPage:number=0;
  size:number=5;

  pages:Array<number>;

  tournoi:Tournoi = new Tournoi();

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
  mouseEnter(A){
    console.log(A);
    $('.thumbnail').hover(
      function(){
        $(this).find('.caption').slideDown(250); //.fadeIn(250)
      },
      function(){
        $(this).find('.caption').slideUp(250); //.fadeOut(205)
      }
    );
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
  onDetailTournoi(id:number){
    this.router.navigate(['detail-tournoi', id]);
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
  genererTournoi(id:number){

    swal({
      title: 'Etes vous sur ?',
      text: 'Voulez vous générer les matches ?',
      type: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Oui, générer',
      cancelButtonText: 'Non, pas encore'
    }).then(()=> this.generate(id)).then(function(){
      swal(
        'généré',
        'Vos matches ont été générés',
        'success'
      )
    }, function(dismiss) {
      // dismiss can be 'overlay', 'cancel', 'close', 'esc', 'timer'
      if (dismiss === 'cancel') {
        swal(
          'Annulé',
          'Vos matches n\'ont pas encore été générés',
          'error'
        )
      }
    });

  }
  generate(id:number){
    this.tournoiService.genererTournoi(id)
      .subscribe(data =>{
      }, err => {
        console.log(err);
      });
  }
  publierTournoi(id:number){
    this.router.navigate(['publier-tournoi', id]);

    /*this.tournoiService.getTournoi(id)
      .subscribe(data => {
        this.tournoi = data;
      }, err => {
        console.log(err);
      });
*/
    /*if(this.tournoi.local.id == 1){

    }

    if(this.tournoi.local.id != 1){
      swal(
        'Oops...',
        'Tournoi deja Publiee !',
        'error'
      )
    }

    /*this.tournoiService.publierTournoi(id)
      .subscribe(data => {
        this.ngOnInit();
      }, err => {
        console.log(err);
      });*/
  }

}
