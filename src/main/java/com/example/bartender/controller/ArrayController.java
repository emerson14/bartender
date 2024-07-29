package com.example.bartender.controller;

import com.example.bartender.service.ArrayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArrayController {

    @Autowired
    private ArrayService arrayService;

    @GetMapping("/process")
    public List<Integer> processArray(@RequestParam int id, @RequestParam int Q) {
        return arrayService.processArray(id, Q);
    }
}
