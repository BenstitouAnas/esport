import { Jeu } from './Jeu';
import { Organisateur } from './Organisateur';
import { Console } from './Console';
import { Local } from './Local';

export class Tournoi {
  private _Nom: string;
  private _Description: string;
  private _DateDebut: Date;
  private _DateFin: Date;
  private _prix: number;
  private _publie: boolean;
  private _porte: boolean;
  private _local: Local;
  private _console: Console;
  private _jeu: Jeu;
  private _utilisateur: Organisateur;

  constructor(Nom: string, Description: string, DateDebut: Date, DateFin: Date, prix: number, publie: boolean, porte: boolean, local: Local, console: Console, jeu: Jeu, utilisateur: Organisateur) {
    this._Nom = Nom;
    this._Description = Description;
    this._DateDebut = DateDebut;
    this._DateFin = DateFin;
    this._prix = prix;
    this._publie = publie;
    this._porte = porte;
    this._local = local;
    this._console = console;
    this._jeu = jeu;
    this._utilisateur = utilisateur;
  }

  get Nom(): string {
    return this._Nom;
  }

  set Nom(value: string) {
    this._Nom = value;
  }

  get Description(): string {
    return this._Description;
  }

  set Description(value: string) {
    this._Description = value;
  }

  get DateDebut(): Date {
    return this._DateDebut;
  }

  set DateDebut(value: Date) {
    this._DateDebut = value;
  }

  get DateFin(): Date {
    return this._DateFin;
  }

  set DateFin(value: Date) {
    this._DateFin = value;
  }

  get prix(): number {
    return this._prix;
  }

  set prix(value: number) {
    this._prix = value;
  }

  get publie(): boolean {
    return this._publie;
  }

  set publie(value: boolean) {
    this._publie = value;
  }

  get porte(): boolean {
    return this._porte;
  }

  set porte(value: boolean) {
    this._porte = value;
  }

  get local(): Local {
    return this._local;
  }

  set local(value: Local) {
    this._local = value;
  }

  get console(): Console {
    return this._console;
  }

  set console(value: Console) {
    this._console = value;
  }

  get jeu(): Jeu {
    return this._jeu;
  }

  set jeu(value: Jeu) {
    this._jeu = value;
  }

  get utilisateur(): Organisateur {
    return this._utilisateur;
  }

  set utilisateur(value: Organisateur) {
    this._utilisateur = value;
  }
}
