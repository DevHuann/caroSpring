package com.vcoderlog.lab01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

    @GetMapping("get-all")
    List<String> getAll() {
        var employees = Arrays.asList("Test", "Test1");



        return employees;
    }
}
