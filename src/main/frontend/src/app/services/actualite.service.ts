import { Injectable } from '@angular/core';
import {Config} from "../../models/Config";
import {Http} from "@angular/http";
import {Actualite} from "../../models/Actualite";

@Injectable()
export class ActualiteService {

  _actualitesUrl:string;

  constructor(
    public _http:Http,
    private _config: Config
  ) {
    this._actualitesUrl = this._config.serverURL + "actualites/";
  }

  getAllActualites(){
    return this._http.get(this._actualitesUrl)
      .map(resp => resp.json());
  }

  getListActualites(page:number, size:number){
    return this._http.get(this._actualitesUrl + "chercher?size=" + size + "&page=" + page)
      .map(resp => resp.json());
  }

  getActualites(mot:string, page:number, size:number){
    return this._http.get(this._actualitesUrl + "chercher?mot=" + mot + "&size" + size + "&page=" + page)
      .map(resp => resp.json());
  }

  getActualite(id:number){
    return this._http.get(this._actualitesUrl + id)
      .map(resp => resp.json());
  }

  saveActualite(actualite:Actualite){
    return this._http.post(this._actualitesUrl, actualite)
      .map(resp => resp.json());
  }

  updateActualite(actualite:Actualite){
    return this._http.put(this._actualitesUrl + actualite.id, actualite)
      .map(resp => resp.json());
  }

  deleteActualite(id:number){
    return this._http.delete(this._actualitesUrl + id)
      .map(resp => resp.json());
  }

}
