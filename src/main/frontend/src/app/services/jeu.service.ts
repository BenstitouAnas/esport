import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import {Config} from "../../models/Config";
import { Jeu } from "../../models/Jeu"

@Injectable()
export class JeuService {

  _jeuxUrl:string;

  constructor(
    public _http:Http,
    private _config: Config
  ) {
    this._jeuxUrl = this._config.serverURL + "jeux/";
  }

  getListJeux(page:number, size:number){
    return this._http.get(this._jeuxUrl + "chercher?size=" + size + "&page=" + page)
      .map(resp => resp.json());
  }

  getJeux(mot:string, page:number, size:number){
    return this._http.get(this._jeuxUrl + "chercher?mot=" + mot + "&size" + size + "&page=" + page)
      .map(resp => resp.json());
  }

  getJeu(id:number){
    return this._http.get(this._jeuxUrl + id)
      .map(resp => resp.json());
  }

  saveJeu(jeu:Jeu){
    return this._http.post(this._jeuxUrl, jeu)
      .map(resp => resp.json());
  }

  updateJeu(jeu:Jeu){
    return this._http.put(this._jeuxUrl + jeu.id, jeu)
      .map(resp => resp.json());
  }

  deleteJeu(id:number){
    return this._http.delete(this._jeuxUrl + id)
      .map(resp => resp.json());
  }

}
