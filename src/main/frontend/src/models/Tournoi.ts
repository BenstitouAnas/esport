import { Jeu } from './Jeu';
import { Organisateur } from './Organisateur';
import { Console } from './Console';
import { Local } from './Local';

export class Tournoi {
  private Nom: string;
  private Description: string;
  private DateDebut: Date;
  private DateFin: Date;
  private prix: number;
  private publie: boolean;
  private porte: boolean;
  private local: Local;
  private console: Console;
  private jeu: Jeu;
  private utilisateur: Organisateur;
  constructor(Nom: string,
              Description: string,
              DateDebut: Date,
              DateFin: Date,
              prix: number,
              console: Console,
              jeu: Jeu
  ) {
    this.Nom = Nom;
    this.Description = Description;
    this.DateDebut = DateDebut;
    this.DateFin = DateFin;
    this.prix = prix;
    this.setConsole(console);
    this.setJeu(jeu);
    this.local = null;
    this.publie = false;
    this.porte = false;
  }
  setConsole(console: Console) {
    this.console = console;
  }
  setJeu(jeu: Jeu) {
    this.jeu = jeu;
  }
  getNom() {
    return this.Nom;
  }
  getDescription() {
    return this.Description;
  }
  getConsole() {
    return this.console;
  }
  getJeu() {
    return this.jeu;
  }
  getDateDebut() {
    return this.DateDebut;
  }
  getDateFin() {
    return this.DateFin;
  }
  getPrix() {
    return this.prix;
  }
  getLocal() {
    return this.local;
  }
  getUtilisateur() {
    return this.utilisateur;
  }
  getPorte() {
    return this.porte;
  }
  getPublie() {
    return this.publie;
  }
}
