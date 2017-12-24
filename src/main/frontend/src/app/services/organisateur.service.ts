import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import {Config} from '../../models/Config';
import { Organisateur } from '../../models/Organisateur';

@Injectable()
export class OrganisateurService {

  _organisateursUrl:string;

  constructor(
    public _http:Http,
    private _config: Config
  ) {
    this._organisateursUrl = this._config.serverURL + "organisateurs/";
  }

  getAllOrganisateurs(){
    return this._http.get(this._organisateursUrl)
      .map(resp => resp.json());
  }

  getListOrganisateurs(page:number, size:number){
    return this._http.get(this._organisateursUrl + "chercher?size=" + size + "&page=" + page)
      .map(resp => resp.json());
  }

  getOrganisateurs(mot:string, page:number, size:number){
    return this._http.get(this._organisateursUrl + "chercher?mot=" + mot + "&size" + size + "&page=" + page)
      .map(resp => resp.json());
  }

  getOrganisateur(id:number){
    return this._http.get(this._organisateursUrl + id)
      .map(resp => resp.json());
  }

  saveOrganisateur(organisateur:Organisateur){
    return this._http.post(this._organisateursUrl, organisateur)
      .map(resp => resp.json());
  }

  updateOrganisateur(organisateur:Organisateur){
    return this._http.put(this._organisateursUrl + organisateur.id, organisateur)
      .map(resp => resp.json());
  }

  deleteOrganisateur(id:number){
    return this._http.delete(this._organisateursUrl + id)
      .map(resp => resp.json());
  }


}
