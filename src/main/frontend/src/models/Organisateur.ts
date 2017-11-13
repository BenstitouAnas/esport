import { Utilisateur } from './Utilisateur';
export class Organisateur extends Utilisateur {
  Organisation: string;
  constructor(Nom: string,
              Prenom: string,
              Organisation: string) {
    super(Nom, Prenom);
    this.Organisation = Organisation;
  }
}
