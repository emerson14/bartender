package com.example.bartender.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bartender.service.ArrayService;
//controllador
@RestController
@RequestMapping("/api")
public class ArrayController {

    @Autowired
    private ArrayService arrayService;

    @GetMapping("/process")
    public ResponseEntity<List<Integer>> process(@RequestParam int id, @RequestParam int Q) {
        //  correr el processArray en la clase arrayService
        List<Integer> result = arrayService.processArray(id, Q);
        return ResponseEntity.ok(result);
    }
}