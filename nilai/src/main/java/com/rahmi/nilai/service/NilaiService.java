/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rahmi.nilai.service;

import com.rahmi.nilai.entity.Nilai;
import com.rahmi.nilai.repository.NilaiRepository;
import com.rahmi.nilai.vo.Mahasiswa;
import com.rahmi.nilai.vo.Matakuliah;
import com.rahmi.nilai.vo.ResponseTemplate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author asus
 */

@Service
public class NilaiService {
    @Autowired
    private NilaiRepository nilaiRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public List<Nilai> getNilai(){
        return nilaiRepository.findAll();
    }
    
    public void insert(Nilai nilai){
        nilaiRepository.save(nilai);
    }
    
    public ResponseTemplate getNilai(Long nilaiId){
        ResponseTemplate vo = new ResponseTemplate();
        Nilai nilai = nilaiRepository.findById(nilaiId)
                .orElseThrow(() -> new IllegalStateException("Nilai tidak ada"));
        Mahasiswa mahasiswa = 
                restTemplate.getForObject("http://localhost:9001/api/v1/mahasiswa/"
                        + nilai.getMahasiswaId(), Mahasiswa.class);
        Matakuliah matakuliah = 
                restTemplate.getForObject("http://localhost:9002/api/v1/matakuliah/"
                        + nilai.getMatakuliahId(), Matakuliah.class);
        vo.setNilai(nilai); 
        vo.setMahasiswa(mahasiswa);
        vo.setMatakuliah(matakuliah);
        return vo;
    }
}
