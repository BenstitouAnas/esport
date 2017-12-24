import {TournoiIndividuel} from "./TournoiIndividuel";

export class Joueur{
  id: number = null;
  organisateur: string = "";
  Tournois: Array<TournoiIndividuel> = new Array();
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
