import {Journaliste} from "./Journaliste";

export class Actualite {
  id: number = null;
  titre: string = '';
  contenu: string = '';
  Date_Ecriture: Date = new Date();
  m_Writer: Journaliste;
}
