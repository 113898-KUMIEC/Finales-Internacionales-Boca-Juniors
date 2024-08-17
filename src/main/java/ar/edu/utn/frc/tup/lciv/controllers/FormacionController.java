package ar.edu.utn.frc.tup.lciv.controllers;

import ar.edu.utn.frc.tup.lciv.Dtos.FinalesCompletas;
import ar.edu.utn.frc.tup.lciv.Models.FinalesInternacionales;
import ar.edu.utn.frc.tup.lciv.Models.Formaciones;
import ar.edu.utn.frc.tup.lciv.Service.FinalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/finales")
public class FormacionController {
    @Autowired
    private FinalesService finalesService;
    @GetMapping("/formaciones")
    public ResponseEntity<List<Formaciones>> getAllFormaciones() {
        List<Formaciones> formaciones = finalesService.getAllFormaciones();
        return ResponseEntity.ok(formaciones);
    }
    @GetMapping("/Internacionales")
    public ResponseEntity<List<FinalesInternacionales>> getAllPartidos() {
        List<FinalesInternacionales> finales = finalesService.getAllPartidos();
        return ResponseEntity.ok(finales);
    }

    @GetMapping("/PartidosCompletos")
    public ResponseEntity<List<FinalesCompletas>> getAllPartidosCompletos() {
        List<FinalesCompletas> finales = finalesService.getAllFinalesCompletas();
        return ResponseEntity.ok(finales);
    }
    @GetMapping("/PartidosCompletos/dt/{nombreDT}")
    public ResponseEntity<List<FinalesCompletas>> getAllPartidosCompletosByDT(@PathVariable String nombreDT) {
        List<FinalesCompletas> finales = finalesService.getFinalesCompletasByDT(nombreDT);
        return ResponseEntity.ok(finales);
    }
    @GetMapping("/PartidosCompletos/jugador/{nombreJugador}")
    public ResponseEntity<List<FinalesCompletas>> getAllPartidosCompletosByJugador(@PathVariable String nombreJugador) {
        List<FinalesCompletas> finales = finalesService.getFinalesCompletasByJugador(nombreJugador);
        return ResponseEntity.ok(finales);
    }

}
