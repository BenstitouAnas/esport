import { Jeu } from './Jeu';

export class Console {
  private _id: number;
  private _Nom: string;
  private _Jeux: Array<Jeu>;

  public constructor(
    _id: number,
    Nom: string,
    Jeux: Array<Jeu>) {
    this._id = _id;
    this._Nom = Nom;
    this._Jeux = Jeux;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get Nom(): string {
    return this._Nom;
  }

  set Nom(value: string) {
    this._Nom = value;
  }

  get Jeux(): Array<Jeu> {
    return this._Jeux;
  }

  set Jeux(value: Array<Jeu>) {
    this._Jeux = value;
  }
}
