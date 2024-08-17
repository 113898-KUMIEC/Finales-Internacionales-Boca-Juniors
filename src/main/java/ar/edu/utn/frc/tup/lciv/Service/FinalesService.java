package ar.edu.utn.frc.tup.lciv.Service;

import ar.edu.utn.frc.tup.lciv.Dtos.FinalesCompletas;
import ar.edu.utn.frc.tup.lciv.Models.FinalesInternacionales;
import ar.edu.utn.frc.tup.lciv.Models.Formaciones;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FinalesService {
    List<Formaciones> getAllFormaciones();
    List<FinalesInternacionales> getAllPartidos();
    List<FinalesCompletas> getAllFinalesCompletas();
    List<FinalesCompletas> getFinalesCompletasByDT(String nombreDT);
    List<FinalesCompletas> getFinalesCompletasByJugador(String nombreJugador);
}
