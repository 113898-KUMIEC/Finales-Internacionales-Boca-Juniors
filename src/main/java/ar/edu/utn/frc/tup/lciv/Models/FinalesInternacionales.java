package ar.edu.utn.frc.tup.lciv.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalesInternacionales {
    private Integer id_partido;
    private String equipo;
    private String torneo;
    private String fecha;
    private String rival;
    private String resultado;
    private String pais;
    private String ciudad;
}
