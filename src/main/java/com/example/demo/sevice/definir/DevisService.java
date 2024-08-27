package com.example.demo.sevice.definir;

import com.example.demo.entity.Devis;

import java.util.List;

public interface DevisService {
    List<Devis> getDevis();
    Devis createDevis(Devis devis);

}
