import { Tournoi } from './Tournoi';
import {Local} from "./Local";
import {Jeu} from "./Jeu";
import {Organisateur} from "./Organisateur";

export class TournoiEnEquipe{
  id: number = null;
  nom: string = "";
  Description: string = "";
  DateDebut: Date;
  DateFin: Date;
  prix: number = 0;
  publie: boolean = false;
  porte: boolean = false;
  local: Local = null;
  console: Console = null
  jeu: Jeu = null;
  utilisateur: Organisateur = null;
  nbrEquipes: number = 2;
}
