import { Jeu } from './Jeu';
import { Tournoi } from './Tournoi';
import { Console } from './Console';

export class TournoiIndividuel extends Tournoi {

  private nbrJoueurs: number;
  constructor(Nom: string,
              Description: string,
              DateDebut: Date,
              DateFin: Date,
              prix: number,
              console: Console,
              jeu: Jeu,
              nbrJoueurs: number
  ) {
    super(Nom, Description, DateDebut, DateFin, prix, console, jeu)
    this.nbrJoueurs = nbrJoueurs;
  }
  getNbIndividu() {
    return this.nbrJoueurs;
  }
}
