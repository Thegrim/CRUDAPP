package com.myapp.service;

import com.myapp.model.Counter;
import com.myapp.repository.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterService {

    private final CounterRepository counterRepository;

    @Autowired
    public CounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    public Counter incrementCounter(Long id) {
        Counter counter = counterRepository.findById(id).orElse(new Counter());
        counter.setCount(counter.getCount() + 1);
        return counterRepository.save(counter);
    }
}
