package ro.skincare.skincare_analyzer.controller;

import org.springframework.web.bind.annotation.*;
import ro.skincare.skincare_analyzer.model.RutinaProdus;
import ro.skincare.skincare_analyzer.service.RutinaProdusService;

import java.util.List;


@RestController
@RequestMapping("/api/rutinaproduse")
public class RutinaProdusController {

    private RutinaProdusService rutinaProdusService;

    public RutinaProdusController(RutinaProdusService rutinaProdusService) {
        this.rutinaProdusService = rutinaProdusService;
    }

    @GetMapping
    public List<RutinaProdus> toateRutineleProdus(){
        return rutinaProdusService.findAll();
    }

    @GetMapping("/{id}")
    public RutinaProdus unRutinaProdus(@PathVariable Long id){
        return rutinaProdusService.findById(id).orElse(null);
    }

    @PostMapping
    public RutinaProdus adaugaRutinaProdus(@RequestBody RutinaProdus rutinaProdus){
        return rutinaProdusService.save(rutinaProdus);
    }

    @PutMapping("/{id}")
    public RutinaProdus schimbaRutinaProdus(@PathVariable Long id, @RequestBody RutinaProdus rutinaProdus )
    {
        RutinaProdus rutinaProdusExistent= rutinaProdusService.findById(id).orElse(null);

        rutinaProdusExistent.setProdus(rutinaProdus.getProdus());

        rutinaProdusExistent.setRutina(rutinaProdus.getRutina());

        rutinaProdusExistent.setOrdine(rutinaProdus.getOrdine());

        rutinaProdusExistent.setMomentZi(rutinaProdus.getMomentZi());

        return rutinaProdusService.save(rutinaProdusExistent);
    }
    @DeleteMapping("/{id}")
    public void stergeRutinaProdus(@PathVariable Long id){
        rutinaProdusService.deleteById(id);
    }
}
