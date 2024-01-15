/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rahmi.nilai.controller;

import com.rahmi.nilai.entity.Nilai;
import com.rahmi.nilai.service.NilaiService;
import com.rahmi.nilai.vo.ResponseTemplate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ideapad 5
 */

@RestController
@RequestMapping("api/v1/nilai")
public class NilaiController {
    @Autowired
    private NilaiService nilaiService;
    
    @PostMapping
    public void insert(@RequestBody Nilai nilai){
        nilaiService.insert(nilai); 
    }
    
    @GetMapping(path = "{id}")
    public ResponseTemplate getNilai(@PathVariable("id") Long nilaiId){
        return nilaiService.getNilai(nilaiId);
    }
}
