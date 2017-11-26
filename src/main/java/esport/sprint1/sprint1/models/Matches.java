package esport.sprint1.sprint1.models;

import javax.persistence.*;

/**
 * @author Amine
 * @version 1.0
 * @created 26-nov.-2017 12:35:39
 */
@Entity
public class Matches {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	private Long Joueur1;
	private Long Joueur2;
	private int result = 0;
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="ROUND_ID")
	private Rounds Round;
	public Matches(){

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getJoueur1() {
		return Joueur1;
	}

	public void setJoueur1(Long joueur1) {
		Joueur1 = joueur1;
	}

	public Long getJoueur2() {
		return Joueur2;
	}

	public void setJoueur2(Long joueur2) {
		Joueur2 = joueur2;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public Rounds getRound() {
		return Round;
	}

	public void setRound(Rounds round) {
		Round = round;
	}

	public Long getWinner() {
		if (this.result == 1) {
			return Joueur1;
		} else if (this.result == 2) {
			return Joueur2;
		} else {
			return null;
		}
	}
	public void createMatch(Long J1,Long J2){
		Joueur1 = J1;
		Joueur2 = J2;
	}
	public void finalize() throws Throwable {

	}

}