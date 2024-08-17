package ar.edu.utn.frc.tup.lciv.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formaciones {
    @JsonProperty("id_partido")
    private Integer idPartido;
    private List<Titulares> titulares;
    private String dt;
}
