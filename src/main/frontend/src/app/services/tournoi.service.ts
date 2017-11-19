import { Injectable } from '@angular/core';
import { Http } from "@angular/http";
import { Config } from "../../models/Config";
import { Tournoi } from "../../models/Tournoi";

@Injectable()
export class TournoiService {

  _tournoisUrl:string;

  constructor(
    public _http:Http,
    private _config: Config
  ) {
    this._tournoisUrl = this._config.serverURL + "tournois/";
  }

  getListTournois(page:number, size:number){
    return this._http.get(this._tournoisUrl + "chercher?size=" + size + "&page=" + page)
      .map(resp => resp.json());
  }

  getTournois(mot:string, page:number, size:number){
    return this._http.get(this._tournoisUrl + "chercher?mot=" + mot + "&size" + size + "&page=" + page)
      .map(resp => resp.json());
  }

  getTournoi(id:number){
    return this._http.get(this._tournoisUrl + id)
      .map(resp => resp.json());
  }

  saveTournoi(tournoi:Tournoi){
    return this._http.post(this._tournoisUrl, tournoi)
      .map(resp => resp.json());
  }

  updateTournoi(tournoi:Tournoi){
    return this._http.put(this._tournoisUrl + tournoi.id, tournoi)
      .map(resp => resp.json());
  }

  deleteTournoi(id:number){
    return this._http.delete(this._tournoisUrl + id)
      .map(resp => resp.json());
  }

  publierTournoi(id:number){
    return this._http.put(this._tournoisUrl + id + "/publier", null)
      .map(resp => resp.json());
  }

  nonPublierTournoi(id:number){
    return this._http.put(this._tournoisUrl + id + "/nonpublier", null)
      .map(resp => resp.json());
  }

}
