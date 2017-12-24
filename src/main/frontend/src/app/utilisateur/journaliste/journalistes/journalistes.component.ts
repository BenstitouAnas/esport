import { Component, OnInit } from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
import {Router} from '@angular/router';
import swal from 'sweetalert2/dist/sweetalert2.all.min.js';
import {JournalisteService} from "../../../services/journaliste.service";
import {Config} from "../../../../models/Config";
import {Journaliste} from "../../../../models/Journaliste";

@Component({
  selector: 'app-journalistes',
  templateUrl: './journalistes.component.html',
  styleUrls: ['./journalistes.component.css']
})
export class JournalistesComponent implements OnInit {

  pageJournalistes:any;
  mot:string="";
  currentPage:number=0;
  size:number=5;

  pages:Array<number>;

  constructor(
    public _http:Http,
    public journalisteService:JournalisteService,
    public router:Router,
    public _config: Config
  ) { }

  ngOnInit() {
    this.journalisteService.getListJournaliste(this.currentPage, this.size)
      .subscribe(data => {
        console.log(data)
        this.pageJournalistes = data;
        this.pages = new Array(data.totalPages);
      }, err => {
        console.log(err);
      })
  }

  doSearch(){
    this.journalisteService.getJournaliste(this.mot, this.currentPage, this.size)
      .subscribe(data => {
        this.pageJournalistes = data;
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

  onEditJournaliste(id:number){
    this.router.navigate(['edit-journaliste', id]);
  }

  onDeleteJournaliste(consol:Journaliste){

    swal({
      title: 'Are you sure?',
      text: 'You will not be able to recover this imaginary file!',
      type: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then(()=> this.deleteJournaliste(consol)).then(function(){
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

  deleteJournaliste(consol:Journaliste){
    this.journalisteService.deleteJournalist(consol.id)
      .subscribe(data => {
        this.pageJournalistes.content.splice(
          this.pageJournalistes.content.indexOf(consol), 1
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
