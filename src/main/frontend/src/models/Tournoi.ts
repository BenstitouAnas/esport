import { Jeu } from './Jeu';
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
  organisateur: Organisateur = null;

  nbEquipes: number = 2;
  nbJoueurs: number = 4;

}
