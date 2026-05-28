package ro.skincare.skincare_analyzer.model;


import jakarta.persistence.*;


import java.util.Set;

@Entity
@Table(name = "produs")

public class Produs {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nume;
    private String brand;
    private String listaIngrediente;

    @ManyToMany
    @JoinTable(
            name = "produs_ingredient",
            joinColumns = @JoinColumn(name = "produs_id"),
    inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<Ingredient> ingrediente;

    public Produs() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return this.nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getListaIngrediente() {
        return this.listaIngrediente;
    }

    public void setListaIngrediente(String listaIngrediente) {
        this.listaIngrediente = listaIngrediente;
    }

    public Set <Ingredient> getIngrediente(){
        return this.ingrediente;
    }
    public void setIngrediente(Set<Ingredient> ingrediente){
        this.ingrediente=ingrediente;
    }
}
