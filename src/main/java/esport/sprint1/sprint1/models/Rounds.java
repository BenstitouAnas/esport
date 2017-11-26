package esport.sprint1.sprint1.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Amine
 * @version 1.0
 * @created 26-nov.-2017 12:46:31
 */
@Entity
public class Rounds {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@OneToMany(mappedBy = "Round")
	private List<Matches> m_Matches;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TOURNOI_ID")
	private Tournois tournoi;
	private Long theLuckyGuy;
	private ArrayList<Long> playersCurrentTurn;
	public Rounds(){

	}
	public void StartToornament(ArrayList<Long> T){
		this.m_Matches = new ArrayList<>();
		this.playersCurrentTurn = new ArrayList<>(T);
		this.generateMatchs();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Matches> getM_Matches() {
		return m_Matches;
	}

	public void setM_Matches(List<Matches> m_Matches) {
		this.m_Matches = m_Matches;
	}


	public Tournois getTournoi() {
		return tournoi;
	}

	public void setTournoi(Tournois tournoi) {
		this.tournoi = tournoi;
	}

	public Long getTheLuckyGuy() {
		return theLuckyGuy;
	}

	public void setTheLuckyGuy(Long theLuckyGuy) {
		this.theLuckyGuy = theLuckyGuy;
	}

	public ArrayList<Long> getPlayersCurrentTurn() {
		return playersCurrentTurn;
	}

	public void setPlayersCurrentTurn(ArrayList<Long> playersCurrentTurn) {
		this.playersCurrentTurn = playersCurrentTurn;
	}

	public void generateMatchs() {
		Matches match;
		Collections.shuffle(this.playersCurrentTurn);
		if (this.theLuckyGuy != null) {
			this.playersCurrentTurn.add(this.theLuckyGuy);
			this.theLuckyGuy = null;
			Collections.shuffle(this.playersCurrentTurn);
		}
		if ((this.playersCurrentTurn.size() % 2) != 0) {
			Collections.shuffle(this.playersCurrentTurn);
			this.theLuckyGuy = this.playersCurrentTurn.get(0);
			this.playersCurrentTurn.remove(0);
		}
		this.m_Matches = new ArrayList<>();
		for (int i = 0; i < this.playersCurrentTurn.size(); i += 2) {
			match = new Matches();
			match.createMatch(this.playersCurrentTurn.get(i),
					this.playersCurrentTurn.get(i + 1));
			this.m_Matches.add(match);
		}

	}
	public boolean hasNextTurn() {
		return ((this.playersCurrentTurn.size() > 1)
				&& (this.theLuckyGuy != null));
	}
	public void finalize() throws Throwable {

	}

}