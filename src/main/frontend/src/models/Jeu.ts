export class Jeu {
  private _id: number;
  private _Nom: string;
  private _AfficheUrl: string;
  private _Type: boolean;
  public constructor(
    _id: number,
    Nom: string,
    AfficheUrl: string,
    Type: boolean) {
    this._id = _id;
    this._Nom = Nom;
    this._AfficheUrl = AfficheUrl;
    this._Type = Type;
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

  get AfficheUrl(): string {
    return this._AfficheUrl;
  }

  set AfficheUrl(value: string) {
    this._AfficheUrl = value;
  }

  get Type(): boolean {
    return this._Type;
  }

  set Type(value: boolean) {
    this._Type = value;
  }
}
