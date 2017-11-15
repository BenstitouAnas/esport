import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Config} from "../../models/Config";
import { Console } from "../../models/Console";


@Injectable()
export class ConsoleService {

  _consolesUrl:string;

  constructor(
    public _http:Http,
    private _config: Config
    ) {
    this._consolesUrl = this._config.serverURL + "consoles/";
  }

  getListConsoles(page:number, size:number){
    return this._http.get(this._consolesUrl + "chercher?size=" + size + "&page=" + page)
      .map(resp => resp.json());
  }

  getConsoles(mot:string, page:number, size:number){
    return this._http.get(this._consolesUrl + "chercher?mot=" + mot + "&size" + size + "&page=" + page)
      .map(resp => resp.json());
  }

  getConsole(id:number){
    return this._http.get(this._consolesUrl + id)
      .map(resp => resp.json());
  }

  saveConsole(console:Console){
    return this._http.post(this._consolesUrl, console)
      .map(resp => resp.json());
  }

  updateConsole(console:Console){
    return this._http.put(this._consolesUrl + console.id, console)
      .map(resp => resp.json());
  }

  deleteConsole(id:number){
    return this._http.delete(this._consolesUrl + id)
      .map(resp => resp.json());
  }

}
