package com.example.demo.sevice.implementation;

import com.example.demo.entity.Devis;
import com.example.demo.respository.DevisRepository;
import com.example.demo.sevice.definir.DevisService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class DevisServiceI implements DevisService {

    private final DevisRepository devisRepository;
    @Override
    public List<Devis> getDevis() {
        return this.devisRepository.findAll();
    }
}
