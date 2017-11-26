package esport.sprint1.sprint1.models;

import javax.persistence.*;
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
	public Rounds(){

	}

	public void finalize() throws Throwable {

	}

}