import {Journaliste} from "./Journaliste";

export class Actualite {
  id: number = null;
  titre: string = '';
  contenu: string = '';
  dateEcriture: Date = new Date();
  m_Writer: Journaliste;
  backGround: string = "";
}
