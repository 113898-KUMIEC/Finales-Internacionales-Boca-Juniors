package ar.edu.utn.frc.tup.lciv.Client;

import ar.edu.utn.frc.tup.lciv.Models.FinalesInternacionales;
import ar.edu.utn.frc.tup.lciv.Models.Formaciones;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Service
public class RestClient {

    @Autowired
    RestTemplate restTemplate;

    private static final String URL = "https://my-json-server.typicode.com/113898-KUMIEC/get";
    private static final String URLFinal = "https://my-json-server.typicode.com/113898-KUMIEC/getFinales";
    private static final String URLFinal2 = "https://my-json-server.typicode.com/113898-KUMIEC/getFormacionVDos";
    @CircuitBreaker(name = "microCircuitBreaker", fallbackMethod = "fallback")
    public ResponseEntity<List<Formaciones>> getAllFormaciones(){
        return restTemplate.exchange(URL + "/formaciones", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Formaciones>>() {});
    }
    @CircuitBreaker(name = "microCircuitBreaker", fallbackMethod = "fallback1")
    public ResponseEntity<List<FinalesInternacionales>> getAllFinales(){
        return restTemplate.exchange(URLFinal + "/finales_internacionales", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<FinalesInternacionales>>() {});
    }

    @CircuitBreaker(name = "microCircuitBreaker", fallbackMethod = "fallback2")
    public ResponseEntity<List<Formaciones>> getAllFormacionesV2(){
        return restTemplate.exchange(URLFinal2 + "/formaciones", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Formaciones>>() {});
    }

    public ResponseEntity<List<Formaciones>> fallback(Exception e){
        return ResponseEntity.status(500).body(null);
    }
    public ResponseEntity<List<FinalesInternacionales>> fallback1(Exception e){
        return ResponseEntity.status(500).body(null);
    }
    public ResponseEntity<List<FinalesInternacionales>> fallback2(Exception e){
        return ResponseEntity.status(500).body(null);
    }
}
