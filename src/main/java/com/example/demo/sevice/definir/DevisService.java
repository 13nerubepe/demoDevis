package com.example.demo.sevice.definir;

import com.example.demo.entity.DTO.DevisCreateDto;
import com.example.demo.entity.Devis;

import java.util.List;

public interface DevisService {
    List<Devis> getDevis();

    //    @Override
    //    public Devis createDevis(Devis devis) {
    //        return this.devisRepository.save(devis);
    //    }
    Devis createDevis(DevisCreateDto devisCreateDto);
//    Devis createDevis(Devis devis);

}
