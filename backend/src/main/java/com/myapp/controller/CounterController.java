package com.myapp.controller;

import com.myapp.model.Counter;
import com.myapp.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/counter")
public class CounterController {

    private final CounterService counterService;

    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping("/{id}")
    public Counter getCounter(@PathVariable Long id) {
        return counterService.incrementCounter(id);
    }

    @PostMapping
    public Counter createCounter() {
        return counterService.incrementCounter(null);
    }
}
