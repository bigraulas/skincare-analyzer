package ro.skincare.skincare_analyzer.controller;



import org.springframework.web.bind.annotation.*;
import ro.skincare.skincare_analyzer.model.Ingredient;
import ro.skincare.skincare_analyzer.model.Produs;
import ro.skincare.skincare_analyzer.service.ProdusService;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api/produse")
public class ProdusController {

    private ProdusService produsService;

    public ProdusController(ProdusService produsService) {
        this.produsService = produsService;
    }

    @GetMapping
    public List<Produs> toateProdusele() {
        return produsService.findAll();
    }

    @GetMapping("/{id}")
    public Produs unProdus(@PathVariable Long id) {
        return produsService.findById(id).orElse(null);
    }

    @PostMapping
    public Produs adaugaProdus(@RequestBody Produs produs) {
        return produsService.save(produs);
    }

    @PutMapping("/{id}")
    public Produs schimbaProdus(@PathVariable Long id, @RequestBody Produs produs) {
        Produs produsExistent = produsService.findById(id).orElse(null);
        produsExistent.setNume(produs.getNume());
        produsExistent.setBrand(produs.getBrand());
        produsExistent.setListaIngrediente(produs.getListaIngrediente());
        return produsService.save(produsExistent);
    }


    @DeleteMapping("/{id}")
    public void stergeProdus(@PathVariable Long id) {
        produsService.deleteById(id);
    }

    @GetMapping("/{id}/ingrediente")
    public Set<Ingredient> ingredienteProdus(@PathVariable Long id){
        Produs produsExistent = produsService.findById(id).orElse(null);
        return produsExistent.getIngrediente();
    }
}