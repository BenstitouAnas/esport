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
	private int Joueur1;
	private int Joueur2;
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="ROUND_ID")
	private Rounds Round;
	public Matches(){

	}

	public void finalize() throws Throwable {

	}

}