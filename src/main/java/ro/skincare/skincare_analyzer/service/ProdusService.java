package ro.skincare.skincare_analyzer.service;

import org.springframework.stereotype.Service;
import ro.skincare.skincare_analyzer.model.Produs;
import ro.skincare.skincare_analyzer.repository.ProdusRepository;

import java.util.List;
import java.util.Optional;


@Service
public class ProdusService {

    private ProdusRepository produsRepository;

    public ProdusService(ProdusRepository produsRepository) {
        this.produsRepository = produsRepository;
    }

    public List<Produs> findAll() {
        return produsRepository.findAll();
    }

    public Optional<Produs> findById(Long id) {
        return produsRepository.findById(id);
    }

    public Produs save(Produs produs) {
        return produsRepository.save(produs);
    }

    public void deleteById(Long id){
        produsRepository.deleteById(id);
    }
}
