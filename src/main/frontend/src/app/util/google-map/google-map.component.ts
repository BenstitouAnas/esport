import {Component, OnInit, ViewChild} from '@angular/core';
import { AgmMap } from '@agm/core';
import {BsModalComponent} from "ng2-bs3-modal";

@Component({
  selector: 'app-google-map',
  //templateUrl: './google-map.component.html',
  styleUrls: ['./google-map.component.css'],
  template: `
        <bs-modal #myModal>
            ...
        </bs-modal>
    `
})
export class GoogleMapComponent{

  @ViewChild('myModal')
  modal: BsModalComponent;

  close() {
    this.modal.close();
  }

  open() {
    this.modal.open();
  }

/*
  constructor() { }

  @ViewChild(AgmMap)
  public agmMap: AgmMap;

  ngOnInit() {
    this.agmMap.triggerResize();
  }

  open(){
    console.log("OPEN")
  }


  title: string = 'My first AGM project';
  lat: number = 51.678418;
  lng: number = 7.809007;
  zoom: number= 15;
*/
}
