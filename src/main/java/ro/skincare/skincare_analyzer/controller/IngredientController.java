package ro.skincare.skincare_analyzer.controller;

import org.springframework.web.bind.annotation.*;
import ro.skincare.skincare_analyzer.model.Ingredient;
import ro.skincare.skincare_analyzer.service.IngredientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ingrediente")
public class IngredientController {

    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<Ingredient> findAll() {
        return ingredientService.findAll();

    }

    @GetMapping("/{id}")
    public Ingredient unIngredient(@PathVariable Long id) {

        return ingredientService.findById(id).orElse(null);
    }

    @PostMapping
    public Ingredient adaugaIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.save(ingredient);

    }

    @PutMapping("/{id}")
    public Ingredient schimbaIngredient(@PathVariable Long id, @RequestBody Ingredient ingredient) {

        Ingredient ingredientExistent = ingredientService.findById(id).orElse(null);
        ingredientExistent.setNumeInci(ingredient.getNumeInci());
        ingredientExistent.setDescriere(ingredient.getDescriere());
        ingredientExistent.setFunctie(ingredient.getFunctie());
        ingredientExistent.setEComedogenic(ingredient.getEComedogenic());
        ingredientExistent.setScorSiguranta(ingredient.getScorSiguranta());
        return ingredientService.save(ingredientExistent);
    }

    @DeleteMapping("/{id}")
    public void stergeIngredient(@PathVariable Long id) {
        ingredientService.deleteById(id);
    }

    @GetMapping("/nume/{nume}")
    public Integer scorDeSiguranta(@PathVariable String nume)
    {
        Ingredient ingredient = ingredientService.findByNumeInci(nume).orElse(null);
        return ingredient.getScorSiguranta();
    }


}
