import { Injectable } from '@angular/core';
import {Joueur} from "../../models/Joueur";
import {Http} from "@angular/http";
import {Config} from "../../models/Config";

@Injectable()
export class JoueurService {


  _JoueursUrl:string;

  constructor(
    public _http:Http,
    private _config: Config
  ) {
    this._JoueursUrl = this._config.serverURL + "Joueurs/";
  }

  getAllJoueurs(){
    return this._http.get(this._JoueursUrl)
      .map(resp => resp.json());
  }

  getListJoueurs(page:number, size:number){
    return this._http.get(this._JoueursUrl + "chercher?size=" + size + "&page=" + page)
      .map(resp => resp.json());
  }

  getJoueurs(mot:string, page:number, size:number){
    return this._http.get(this._JoueursUrl + "chercher?mot=" + mot + "&size" + size + "&page=" + page)
      .map(resp => resp.json());
  }

  getJoueur(id:number){
    return this._http.get(this._JoueursUrl + id)
      .map(resp => resp.json());
  }

  saveJoueur(Joueur:Joueur){
    return this._http.post(this._JoueursUrl, Joueur)
      .map(resp => resp.json());
  }

  updateJoueur(Joueur:Joueur){
    return this._http.put(this._JoueursUrl + Joueur.id, Joueur)
      .map(resp => resp.json());
  }

  deleteJoueur(id:number){
    return this._http.delete(this._JoueursUrl + id)
      .map(resp => resp.json());
  }



}
