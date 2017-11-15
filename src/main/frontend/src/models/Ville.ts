import {Utilisateur} from "./Utilisateur";

export class Ville {
  id: number = null;
  nom: string = "";
  utilisateurs: Array<Utilisateur> = new Array();
}
