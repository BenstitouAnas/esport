import { Jeu } from './Jeu';
import { Organisateur } from './Organisateur';
import { Console } from './Console';
import { Local } from './Local';

export class Tournoi {
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
}
