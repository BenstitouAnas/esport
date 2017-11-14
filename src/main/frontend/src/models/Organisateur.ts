import { Utilisateur } from './Utilisateur';

export class Organisateur extends Utilisateur {
  private _organisation: string;


  constructor(Nom: string, Prenom: string, organisation: string) {
    super(Nom, Prenom);
    this._organisation = organisation;
  }


  get organisation(): string {
    return this._organisation;
  }

  set organisation(value: string) {
    this._organisation = value;
  }
}
