
import {Injectable} from "@angular/core";

@Injectable()
export class Config{

  private _serverURL:string;


  constructor() {
    this._serverURL = "http://localhost:8099/";
  }

  get serverURL(): string {
    return this._serverURL;
  }

}
