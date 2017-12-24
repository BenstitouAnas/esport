import { Injectable } from '@angular/core';
import {Config} from "../../models/Config";
import {Journaliste} from "../../models/Journaliste";
import {Http} from "@angular/http";

@Injectable()
export class JournalisteService {

  _journalisteUrl:string;

  constructor(
    public _http:Http,
    private _config: Config
  ) {
    this._journalisteUrl = this._config.serverURL + "journalistes/";
  }

  getAllJournaliste(){
    return this._http.get(this._journalisteUrl)
      .map(resp => resp.json());
  }

  getListJournaliste(page:number, size:number){
    return this._http.get(this._journalisteUrl + "chercher?size=" + size + "&page=" + page)
      .map(resp => resp.json());
  }

  getJournaliste(mot:string, page:number, size:number){
    return this._http.get(this._journalisteUrl + "chercher?mot=" + mot + "&size" + size + "&page=" + page)
      .map(resp => resp.json());
  }

  getJournalist(id:number){
    return this._http.get(this._journalisteUrl + id)
      .map(resp => resp.json());
  }

  saveJournalist(journalist:Journaliste){
    return this._http.post(this._journalisteUrl, journalist)
      .map(resp => resp.json());
  }

  updateJournalist(journalist:Journaliste){
    return this._http.put(this._journalisteUrl + journalist.id, journalist)
      .map(resp => resp.json());
  }

  deleteJournalist(id:number){
    return this._http.delete(this._journalisteUrl + id)
      .map(resp => resp.json());
  }


}
