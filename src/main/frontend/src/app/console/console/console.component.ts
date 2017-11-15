import { Component, OnInit } from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
import {Router} from '@angular/router';
import { ConsoleService} from "../../services/console.service";
import {Config} from "../../../models/Config";
import swal from 'sweetalert2/dist/sweetalert2.all.min.js';
import {Console} from "../../../models/Console";

@Component({
  selector: 'app-console',
  templateUrl: './console.component.html',
  styleUrls: ['./console.component.css'],
  providers: [Config]
})
export class ConsoleComponent implements OnInit {

  pageConsoles:any;
  mot:string="";
  currentPage:number=0;
  size:number=5;

  pages:Array<number>;

  constructor(
    public _http:Http,
    public consoleService:ConsoleService,
    public router:Router,
    public _config: Config
  ) { }

  ngOnInit() {
    this.consoleService.getListConsoles(this.currentPage, this.size)
      .subscribe(data => {
        this.pageConsoles = data;
        this.pages = new Array(data.totalPages);
      }, err => {
        console.log(err);
      })
  }

  doSearch(){
    this.consoleService.getConsoles(this.mot, this.currentPage, this.size)
      .subscribe(data => {
        this.pageConsoles = data;
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

  onEditConsole(id:number){
    this.router.navigate(['edit-console', id]);
  }

  onDeleteConsole(consol:Console){

    swal({
      title: 'Are you sure?',
      text: 'You will not be able to recover this imaginary file!',
      type: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then(()=> this.deleteConsole(consol)).then(function(){
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

  deleteConsole(consol:Console){
    this.consoleService.deleteConsole(consol.id)
      .subscribe(data => {
        this.pageConsoles.content.splice(
          this.pageConsoles.content.indexOf(consol), 1
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
