package ro.skincare.skincare_analyzer.model;


import jakarta.persistence.*;

@Entity
@Table(name = "rutina")
public class Rutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;

    @Enumerated(EnumType.STRING)
    private TipPiele tipPiele;

    public Rutina(){};

    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getNume(){
        return this.nume;
    }

    public void setNume(String nume){
        this.nume=nume;
    }

    public TipPiele getTipPiele(){
        return this.tipPiele;

    }
    public void setTipPiele(TipPiele tipPiele){
        this.tipPiele=tipPiele;
    }


}
