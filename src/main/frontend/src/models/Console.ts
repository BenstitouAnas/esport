import { Jeu } from './Jeu';

export class Console {
  private _id: number;
  private Nom: string;
  private Jeux: Array<Jeu>
  public constructor(
    _id: number,
    Nom: string,
    Jeux: Array<Jeu>) {
    this._id = _id;
    this.Nom = Nom;
    this.Jeux = Jeux;
  }
  getId() {
    return this._id;
  }
}
