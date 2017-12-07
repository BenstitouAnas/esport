import { Jeu } from './Jeu';
import { Rounds } from './Rounds';
import { Organisateur } from './Organisateur';
import { Console } from './Console';
import { Local } from './Local';

export class Tournoi {
  id: number = null;
  titre: string = "";
  description: string = "";
  dateDebut: Date;
  dateFin: Date;
  prix: number = 0;
  publie: boolean = false;
  porte: boolean = false;
  local: Local = null;
  console: Console = null
  jeu: Jeu = null;
  Round: Array<Rounds> = new Array();
  organisateur: Organisateur = null;

  nbEquipes: number = 2;
  nbJoueurs: number = 4;

  type: string = "";

  enLigne: boolean = true;

}
