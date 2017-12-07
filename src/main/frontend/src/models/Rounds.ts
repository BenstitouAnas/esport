import {Matches} from './Matches'
import {Tournoi} from './Tournoi'

export class Rounds {
  id: number = null;
  m_Matches : Array<Matches> = new Array();
  tournoi : Tournoi = null;
  theLuckyGuy : number;
  playersCurrentTurn  : Array<number> = new Array();
}
