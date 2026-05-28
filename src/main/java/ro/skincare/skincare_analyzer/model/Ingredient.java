package ro.skincare.skincare_analyzer.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ingrediente")


public class Ingredient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String numeInci;

    private String descriere;





    private Integer scorSiguranta;

    private Boolean eComedogenic;

    private String functie;

    public Ingredient() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumeInci(String numeInci) {
        this.numeInci = numeInci;
    }

    public String getNumeInci() {
        return this.numeInci;
    }

    public void setScorSiguranta(Integer scorSiguranta) {
        this.scorSiguranta = scorSiguranta;
    }

    public Integer getScorSiguranta() {
        return this.scorSiguranta;
    }

    public void setEComedogenic(Boolean eComedogenic) {
        this.eComedogenic = eComedogenic;
    }

    public Boolean getEComedogenic() {
        return this.eComedogenic;

    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public String getFunctie() {
        return this.functie;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getDescriere() {
        return this.descriere;
    }

}
