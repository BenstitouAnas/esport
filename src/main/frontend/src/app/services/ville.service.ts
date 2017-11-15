import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import {Config} from "../../models/Config";
import {Ville} from "../../models/Ville";

@Injectable()
export class VilleService {

  _villesUrl:string;

  constructor(
    public _http:Http,
    private _config: Config
  ) {
    this._villesUrl = this._config.serverURL + "villes/";
  }

  getAllVilles(){
    return this._http.get(this._villesUrl)
      .map(resp => resp.json());
  }

  getListVilles(page:number, size:number){
    return this._http.get(this._villesUrl + "chercher?size=" + size + "&page=" + page)
      .map(resp => resp.json());
  }

  getVilles(mot:string, page:number, size:number){
    return this._http.get(this._villesUrl + "chercher?mot=" + mot + "&size" + size + "&page=" + page)
      .map(resp => resp.json());
  }

  getVille(id:number){
    return this._http.get(this._villesUrl + id)
      .map(resp => resp.json());
  }

  saveVille(ville:Ville){
    return this._http.post(this._villesUrl, ville)
      .map(resp => resp.json());
  }

  updateVille(ville:Ville){
    return this._http.put(this._villesUrl + ville.id, ville)
      .map(resp => resp.json());
  }

  deleteVille(id:number){
    return this._http.delete(this._villesUrl + id)
      .map(resp => resp.json());
  }

}
