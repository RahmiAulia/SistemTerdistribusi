/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rahmi.mahasiswa.repository;

import com.rahmi.mahasiswa.entity.Mahasiswa;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ideapad 5
 */
@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {

    public Optional<Mahasiswa> findMahasiswaByEmail(String email); 
}
