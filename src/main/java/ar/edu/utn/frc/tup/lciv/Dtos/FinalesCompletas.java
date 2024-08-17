package ar.edu.utn.frc.tup.lciv.Dtos;

import ar.edu.utn.frc.tup.lciv.Models.Formaciones;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FinalesCompletas {
    private Integer id_partido;
    private String equipo;
    private String torneo;
    private String fecha;
    private String rival;
    private String resultado;
    private String pais;
    private String ciudad;
    private Formaciones formacion;
}
