package com.example;

import com.example.service.Service;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> data = List.of("30 99 used_ornaments", "30 105 max_capacity", "12 100 used_ornaments",
                "20 80 used_ornaments", "12 120 max_capacity", "20 101 max_capacity", "21 110 used_ornaments");

        System.out.println(new Service().processChristmasTrees(data, 20));
    }
}
