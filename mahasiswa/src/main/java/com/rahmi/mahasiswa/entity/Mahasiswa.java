/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rahmi.mahasiswa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate; 
import java.util.Date;

/**
 *
 * @author Ideapad 5
 */

@Entity
@Table
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nama;
    private String email;
    private LocalDate tgl_lahir;

    public Mahasiswa() {
    }

    public Mahasiswa(long id, String nama, String email, LocalDate tgl_lahir) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.tgl_lahir = tgl_lahir;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(LocalDate tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" + "id=" + id + ", nama=" + nama + ", email=" + email + 
                ", tgl_lahir=" + tgl_lahir + '}';
    }

}