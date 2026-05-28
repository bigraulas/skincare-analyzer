package ro.skincare.skincare_analyzer.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import ro.skincare.skincare_analyzer.repository.IngredientRepository;
import ro.skincare.skincare_analyzer.model.Ingredient;


@Service



public class IngredientService {
    private IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> findAll(){
        return ingredientRepository.findAll();
    }

    public Optional<Ingredient> findById(Long id){
        return ingredientRepository.findById(id);
    }

    public Ingredient save(Ingredient ingredient){
        return ingredientRepository.save(ingredient);

    }

    public void deleteById(Long id){
        ingredientRepository.deleteById(id);
    }
}
