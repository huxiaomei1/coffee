package spring.demo.service;


import lombok.extern.slf4j.Slf4j;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import spring.demo.model.Coffee;
import spring.demo.repository.CoffeeRepository;

import javax.persistence.Cacheable;
import java.util.List;

@Slf4j
@Service
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    public Coffee saveCoffer (String name, Money price){
        return coffeeRepository.save(Coffee.builder().name(name).price(price).build());
    }


    public Coffee getCoffee(Long id) {
        return coffeeRepository.getOne(id);
    }



    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll(Sort.by("id"));
    }



}
