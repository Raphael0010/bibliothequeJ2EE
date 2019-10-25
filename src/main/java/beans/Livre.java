package beans;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Livre")
public class Livre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "annee")
    private int annee;

    @Column(name = "auteur")
    private String auteur;

    @Column(name = "prix")
    private float prix;

    @Column(name = "img")
    private String img;

    public Livre() {
    }

    public Livre(String titre, int annee, String auteur, float prix, String img) {
        this.titre = titre;
        this.annee = annee;
        this.auteur = auteur;
        this.prix = prix;
        this.img = img;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return new StringBuffer("id:").append(this.id).append("titre:").append(this.titre).append("annee: ")
                .append(this.annee).append("auteur : ").append(this.auteur).append("prix : ").append(this.prix)
                .append("img : ").append(this.img).toString();
    }

}