package ro.skincare.skincare_analyzer.service;

import org.springframework.stereotype.Service;
import ro.skincare.skincare_analyzer.model.RutinaProdus;
import ro.skincare.skincare_analyzer.repository.RutinaProdusRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RutinaProdusService {


    private RutinaProdusRepository rutinaProdusRepository;

    public RutinaProdusService(RutinaProdusRepository rutinaProdusRepository){
        this.rutinaProdusRepository=rutinaProdusRepository;
    }

    public List<RutinaProdus> findAll(){
        return rutinaProdusRepository.findAll();
    }

    public Optional<RutinaProdus> findById(Long id){
        return rutinaProdusRepository.findById(id);
    }

    public RutinaProdus save(RutinaProdus rutinaProdus){
        return rutinaProdusRepository.save(rutinaProdus);
    }

    public void deleteById(Long id){
        rutinaProdusRepository.deleteById(id);
    }
}
