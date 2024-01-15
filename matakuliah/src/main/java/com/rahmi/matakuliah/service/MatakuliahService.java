/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rahmi.matakuliah.service;

import com.rahmi.matakuliah.entity.Matakuliah;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rahmi.matakuliah.repository.MatakuliahRepository;

/**
 *
 * @author Ideapad 5
 */
@Service
public class MatakuliahService {
    @Autowired
    private  MatakuliahRepository matkulrepository;
    
    public List<Matakuliah>getAll(){
        return matkulrepository.findAll();
    }
    
    public Matakuliah getmatkul(Long id){
        Optional<Matakuliah> matkulOptional = matkulrepository.findById(id);
        return matkulOptional.get();
    }
    
    public void insert(Matakuliah matkul){
        Optional<Matakuliah> matkulOptional = matkulrepository.findMatakuliahByNama(matkul.getNama());
        Optional<Matakuliah> matkulOptionalkode = matkulrepository.findMatakuliahByKode(matkul.getKode());
        if (matkulOptional.isPresent()) {
            throw new IllegalStateException("nama mata kuliah ini sudah ada");
        }
        if (matkulOptionalkode.isPresent()) {
            throw new IllegalStateException("kode mata kuliah ini sudah ada");
        }
        
        matkulrepository.save(matkul);
    }
    
    public void delete (Long id){
        boolean ada = matkulrepository.existsById(id);
        
        if (!ada) {
            throw new IllegalStateException("mata kuliah ini tidak ada");
        }
        matkulrepository.deleteById(id);
    }
    
    @Transactional
    public void update(Long id, String kode, String nama, Integer sks){
        Matakuliah matkul = matkulrepository.findById(id).orElseThrow(()-> new IllegalStateException("mata kuliah ini tidak ada"));
        
        if (nama != null && nama.length()>0 && !Objects.equals(matkul.getNama(),nama)) {
            matkul.setNama(nama);
        }
        if (kode != null && kode.length()>0 && !Objects.equals(matkul.getKode(),kode)) {
            Optional<Matakuliah> mahaOptionalkode = matkulrepository.findMatakuliahByKode(kode);
            if (mahaOptionalkode.isPresent()) {
                throw  new IllegalStateException("kode ini sudah ada");
            }
            matkul.setKode(kode);
        }
         if (nama != null && nama.length()>0 && !Objects.equals(matkul.getNama(),nama)) {
            Optional<Matakuliah> mahaOptional = matkulrepository.findMatakuliahByNama(nama);
            if (mahaOptional.isPresent()) {
                throw  new IllegalStateException("nama mata kuliah ini sudah ada");
            }
            matkul.setKode(nama);
        }
         if (sks != null && !Objects.equals(matkul.getSks(),sks)) {
            matkul.setSks(sks);
        }
        
    }
    
}