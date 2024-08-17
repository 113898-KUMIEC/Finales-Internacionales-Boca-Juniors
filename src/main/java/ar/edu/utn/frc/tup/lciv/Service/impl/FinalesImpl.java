package ar.edu.utn.frc.tup.lciv.Service.impl;

import ar.edu.utn.frc.tup.lciv.Client.RestClient;
import ar.edu.utn.frc.tup.lciv.Dtos.FinalesCompletas;
import ar.edu.utn.frc.tup.lciv.Models.FinalesInternacionales;
import ar.edu.utn.frc.tup.lciv.Models.Formaciones;
import ar.edu.utn.frc.tup.lciv.Models.Titulares;
import ar.edu.utn.frc.tup.lciv.Service.FinalesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FinalesImpl implements FinalesService {
    private final ModelMapper modelMapper;
    private final RestClient restClient;

    @Autowired
    public FinalesImpl(ModelMapper modelMapper, RestClient restClient) {
        this.modelMapper = modelMapper;
        this.restClient = restClient;
    }
    @Autowired
    public List<Formaciones> getAllFormaciones() {
        ResponseEntity<List<Formaciones>> responseEntity = restClient.getAllFormaciones();
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            System.err.println("Error en la respuesta HTTP: " + responseEntity.getStatusCode());
            return new ArrayList<>();
        }
    }
    @Autowired
    public List<FinalesInternacionales> getAllPartidos() {
        ResponseEntity<List<FinalesInternacionales>> responseEntity = restClient.getAllFinales();
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            System.err.println("Error en la respuesta HTTP: " + responseEntity.getStatusCode());
            return new ArrayList<>();
        }
    }

    @Override
    public List<FinalesCompletas> getAllFinalesCompletas() {
        List<FinalesInternacionales> finalesInternacionales = getAllPartidos();
        List<Formaciones> formaciones = getAllFormaciones();

        List<FinalesCompletas> finalesCompletas = new ArrayList<>();

        for(FinalesInternacionales partidos : finalesInternacionales){
            Formaciones formacion = null;

            for(Formaciones f: formaciones){
                if (f.getIdPartido().equals(partidos.getId_partido())){
                    formacion = f;
                    break;
                }
            }

            FinalesCompletas finalCompleta = new FinalesCompletas();
            finalCompleta.setPais(partidos.getPais());
            finalCompleta.setFecha(partidos.getFecha());
            finalCompleta.setCiudad(partidos.getCiudad());
            finalCompleta.setEquipo(partidos.getEquipo());
            finalCompleta.setRival(partidos.getRival());
            finalCompleta.setResultado(partidos.getResultado());
            finalCompleta.setTorneo(partidos.getTorneo());
            finalCompleta.setId_partido(partidos.getId_partido());
            finalCompleta.setFormacion(formacion);
            finalesCompletas.add(finalCompleta);

        }
        return finalesCompletas;
    }

    @Override
    public List<FinalesCompletas> getFinalesCompletasByDT(String nombreDT) {
        List<FinalesCompletas> finalesCompletas = getAllFinalesCompletas();

        List<FinalesCompletas> partidos = new ArrayList<>();

        for (FinalesCompletas partido:finalesCompletas){
            if (partido.getFormacion() != null){
                if (partido.getFormacion().getDt().equals(nombreDT)){
                    partidos.add(partido);
                }
            }
        }
        return partidos;
    }

    @Override
    public List<FinalesCompletas> getFinalesCompletasByJugador(String nombreJugador) {
        List<FinalesCompletas> finalesCompletas = getAllFinalesCompletas();

        List<FinalesCompletas> partidos = new ArrayList<>();

        for (FinalesCompletas partido:finalesCompletas){
            if (partido.getFormacion() != null){
                List<Titulares> titutlares = partido.getFormacion().getTitulares();
                for (Titulares t: titutlares){
                    if (t.getNombre().equals(nombreJugador)){
                        partidos.add(partido);
                    }
                }
            }
        }
        return partidos;
    }


}
