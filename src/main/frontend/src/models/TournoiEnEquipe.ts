import { Jeu } from './Jeu';
import { Tournoi } from './Tournoi';
import { Console } from './Console';

export class TournoiEnEquipe extends Tournoi {

  private nbrEquipes: number;
  constructor(Nom: string,
              Description: string,
              DateDebut: Date,
              DateFin: Date,
              prix: number,
              console: Console,
              jeu: Jeu,
              nbrEquipes: number
  ) {
    super(Nom, Description, DateDebut, DateFin, prix, console, jeu)
    this.nbrEquipes = nbrEquipes;
  }
  getNbEquipes() {
    return this.nbrEquipes;
  }

}
