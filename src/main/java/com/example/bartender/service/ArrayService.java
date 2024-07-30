package com.example.bartender.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bartender.entity.ArrayEntity;
import com.example.bartender.repository.ArrayRepository;

@Service
public class ArrayService {

    @Autowired
    private ArrayRepository arrayRepository;
    // Método para generar una lista de números primos

    private List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        int num = 2;
        while (primes.size() < n) {
            boolean isPrime = true;
            for (int prime : primes) {
                if (num % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(num);
            }
            num++;
        }
        return primes;
    }
    // Método principal para procesar el arreglo

    public List<Integer> processArray(int id, int Q) {
        //  Obtener el arreglo desde la bd
        ArrayEntity arrayEntity = arrayRepository.findById(id).orElseThrow(() -> new RuntimeException("Array not found"));
        List<Integer> A = Arrays.stream(arrayEntity.getInputArray().split(","))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());
        // Generar una lista de números primos para el número de iteraciones Q

        List<Integer> primes = generatePrimes(Q);
        List<Integer> respuesta = new ArrayList<>();

    //  arreglo para cada número primo en la lista de primos..

        for (int i = 0; i < Q; i++) {
            int Pi = primes.get(i);
            List<Integer> B = new ArrayList<>();
            List<Integer> Ai = new ArrayList<>();

            for (int num : A) {
                if (num % Pi == 0) {
                    B.add(num);
                } else {
                    Ai.add(num);
                }
            }

            respuesta.addAll(B);
            A = Ai;
        }
        // almacenar los valores restantes de Ai
        respuesta.addAll(A);
        return respuesta;
    }
}
