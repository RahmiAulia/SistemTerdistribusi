/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rahmi.matakuliah.repository;

import com.rahmi.matakuliah.entity.Matakuliah;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Ideapad 5
 */
public interface MatakuliahRepository extends JpaRepository<Matakuliah, Long> {

    public Optional<Matakuliah> findMatakuliahByNama(String nama);

    public Optional<Matakuliah> findMatakuliahByKode(String kode);

    public Optional<Matakuliah> findMatakuliahBySks(int sks);
    
}