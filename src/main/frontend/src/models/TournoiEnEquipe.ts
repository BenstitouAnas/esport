import { Jeu } from './Jeu';
import { Tournoi } from './Tournoi';
import { Console } from './Console';
import { Local } from './Local';
import { Organisateur } from './Organisateur';

export class TournoiEnEquipe extends Tournoi {
  private _nbrEquipes: number;

  constructor(Nom: string, Description: string, DateDebut: Date, DateFin: Date, prix: number, publie: boolean, porte: boolean, local: Local, console: Console, jeu: Jeu, utilisateur: Organisateur, nbrEquipes: number) {
    super(Nom, Description, DateDebut, DateFin, prix, publie, porte, local, console, jeu, utilisateur);
    this._nbrEquipes = nbrEquipes;
  }

  get nbrEquipes(): number {
    return this._nbrEquipes;
  }

  set nbrEquipes(value: number) {
    this._nbrEquipes = value;
  }
}
