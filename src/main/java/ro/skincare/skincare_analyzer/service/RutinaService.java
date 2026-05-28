package ro.skincare.skincare_analyzer.service;


import org.springframework.stereotype.Service;
import ro.skincare.skincare_analyzer.model.Rutina;
import ro.skincare.skincare_analyzer.repository.RutinaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RutinaService  {
    private RutinaRepository rutinaRepository;

    public RutinaService(RutinaRepository rutinaRepository){
        this.rutinaRepository=rutinaRepository;
    }

    public List<Rutina> findAll(){
        return rutinaRepository.findAll();
    }

    public Optional<Rutina> findById(Long id){
        return rutinaRepository.findById(id);
    }
    public Rutina save(Rutina rutina){
        return rutinaRepository.save(rutina);
    }
    public void deleteById(Long id){
        rutinaRepository.deleteById(id);

    }
}


