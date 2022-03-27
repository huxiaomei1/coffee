package spring.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.demo.controller.request.NewCoffeeRequest;
import spring.demo.model.Coffee;
import spring.demo.service.CoffeeService;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/coffee")
public class CoffeeController {
    @Autowired
    private CoffeeService coffeeService;

    @PostMapping("/addCoffee")
    public Coffee addCoffee(@Valid NewCoffeeRequest newCoffee, BindingResult result){

        return coffeeService.saveCoffer(newCoffee.getName(),newCoffee.getPrice());
    }

    @GetMapping(path = "/", params = "!name") // 填写url不能少了这个/
    @ResponseBody
    public List<Coffee> getAll() {
        return coffeeService.getAllCoffee();
    }


}
