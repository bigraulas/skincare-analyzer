package ro.skincare.skincare_analyzer.controller;


import org.springframework.web.bind.annotation.*;
import ro.skincare.skincare_analyzer.model.Rutina;
import ro.skincare.skincare_analyzer.service.RutinaService;

import java.util.List;

@RestController
@RequestMapping("/api/rutine")
public class RutinaController {

    private RutinaService rutinaService;
    public RutinaController(RutinaService rutinaService) {
        this.rutinaService=rutinaService;
    }
    @GetMapping
    public List<Rutina> toateRutinele(){
        return rutinaService.findAll();
    }

    @GetMapping("/{id}")
    public Rutina oRutina(@PathVariable Long id){
        return rutinaService.findById(id).orElse(null);
    }

    @PostMapping
    public Rutina adaugaRutina(@RequestBody Rutina rutina){
        return rutinaService.save(rutina);
    }

    @DeleteMapping("/{id}")
    public void stergeRutina(@PathVariable Long id){
        rutinaService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Rutina modificaRutina(@PathVariable Long id, @RequestBody Rutina rutina){
        Rutina rutinaExistenta= rutinaService.findById(id).orElse(null);
        rutinaExistenta.setNume(rutina.getNume());
        rutinaExistenta.setTipPiele(rutina.getTipPiele());
        return rutinaService.save(rutinaExistenta);


    }
}
