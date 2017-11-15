import { Utilisateur } from './Utilisateur';
import {Tournoi} from "./Tournoi";

export class Organisateur extends Utilisateur {
  organisation: string = "";
  tournois: Array<Tournoi> = new Array();
}
