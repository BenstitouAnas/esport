import { Jeu } from './Jeu';
import { Tournoi } from './Tournoi';
import { Console } from './Console';
import { Local } from './Local';
import { Organisateur } from './Organisateur';


export class TournoiIndividuel extends Tournoi {
  private _nbrJoueurs: number;

  constructor(Nom: string, Description: string, DateDebut: Date, DateFin: Date, prix: number, publie: boolean, porte: boolean, local: Local, console: Console, jeu: Jeu, utilisateur: Organisateur, nbrJoueurs: number) {
    super(Nom, Description, DateDebut, DateFin, prix, publie, porte, local, console, jeu, utilisateur);
    this._nbrJoueurs = nbrJoueurs;
  }

  get nbrJoueurs(): number {
    return this._nbrJoueurs;
  }

  set nbrJoueurs(value: number) {
    this._nbrJoueurs = value;
  }
}
