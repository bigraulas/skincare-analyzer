package ro.skincare.skincare_analyzer.model;


import jakarta.persistence.*;

@Entity
@Table(name="rutinaprodus")
public class RutinaProdus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name= "rutina_id")
    private Rutina rutina;

    @ManyToOne
    @JoinColumn(name = "produs_id")
    private Produs produs;

    private Integer ordine;

    @Enumerated(EnumType.STRING)
    private MomentZi momentZi;

    public RutinaProdus(){};

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public Integer getOrdine(){
        return this.ordine;
    }
    public void setOrdine(Integer ordine)
    {
        this.ordine=ordine;
    }

    public MomentZi getMomentZi(){
        return this.momentZi;
    }
    public void setMomentZi(MomentZi momentZi){
        this.momentZi=momentZi;
    }
    public Rutina getRutina(){
        return this.rutina;
    }
    public void setRutina(Rutina rutina){
        this.rutina=rutina;
    }

    public Produs getProdus(){
        return this.produs;
    }

    public void setProdus(Produs produs){
        this.produs=produs;
    }
}
