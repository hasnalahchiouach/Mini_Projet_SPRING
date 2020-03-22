package Hasna.example.mini_projet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commandes")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private long id ;
	@Column(name = "etat")
private boolean etat ;
	@Column(name = "quantite")
private int quantite;
	@ManyToOne
	@JoinColumn(name="produit_id", nullable=false)
	private Produit produit;
	public Commande(boolean etat, int quantite) {
		super();
		this.etat = etat;
		this.quantite = quantite;
	}
	public Commande() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long l) {
		this.id = l;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	
	

}
