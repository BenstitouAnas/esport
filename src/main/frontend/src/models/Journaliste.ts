import {Tournoi} from "./Tournoi";

export class Journaliste{
  id: number = null;
  organisateur: string = "";
  actualites: Array<Tournoi> = new Array();
  nom: string = "";
  prenom: string = "";

  villeId: number = null;

  nomUtilisateur: string = "";
  email: string = "";
  adresse: string = "";
  pays: string = "";
  codePostale: number = null;
  apropos: string = "";
  citation: string = "";

  levele: number = 0;
  points: number = 0;

  newUser: boolean = true;
  active: boolean = false;
  confirm: boolean = false;

  photo: string = "";
  coverImg: string = "";

  created_at: Date = new Date;
  updated_at: Date = null;

}
