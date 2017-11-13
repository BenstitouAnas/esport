export class Jeu {
  private _id: number;
  private Nom: string;
  private AfficheUrl: string;
  private Type: boolean;
  public constructor(
    _id: number,
    Nom: string,
    AfficheUrl: string,
    Type: boolean) {
    this._id = _id;
    this.Nom = Nom;
    this.AfficheUrl = AfficheUrl;
    this.Type = Type;
  }
  getType() {
    return this.Type;
  }
  getId() {
    return this._id;
  }
}
