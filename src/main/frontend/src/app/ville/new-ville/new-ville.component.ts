import { Component, OnInit } from '@angular/core';
import {VilleService} from "../../services/ville.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-new-ville',
  templateUrl: './new-ville.component.html',
  styleUrls: ['./new-ville.component.css']
})
export class NewVilleComponent implements OnInit {

  constructor(
    public villeService: VilleService,
    public router: Router
  ) { }

  ngOnInit() {
  }

  onSaveVille(dataForm){
    this.villeService.saveVille(dataForm)
      .subscribe(data => {
        this.router.navigate(['villes'])
      }, err => {
        console.log(JSON.parse(err).message)
      })
  }

}
