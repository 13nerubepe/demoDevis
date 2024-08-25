package com.example.demo.controlleur;

import com.example.demo.entity.Client;
import com.example.demo.entity.Devis;
import com.example.demo.sevice.definir.ClientService;
import com.example.demo.sevice.definir.DevisService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("devis")
@RestController
@AllArgsConstructor
public class DevisControlleur {

    private final DevisService devisService;

    @GetMapping("listeDevis")
    public List<Devis> getlisteClient(){
        return this.devisService.getDevis();
    }

    @DeleteMapping
    public void deleteDevis(Devis devisId){}
}
