package org.lessons.java.spring_mypizza.controller;

import org.lessons.java.spring_mypizza.entity.Pizza;
import org.lessons.java.spring_mypizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.List;
import java.util.Optional;
   

@Controller                     
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired                  
    private PizzaRepository pizzaRepository;

    @GetMapping             
    public String index(Model model) {
        List<Pizza> pizzas = pizzaRepository.findAll(); 
        model.addAttribute("pizzas", pizzas);           
        return "pizzas/index";                          
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
        Optional<Pizza> pizza = pizzaRepository.findById(id);
    
        if (pizza.isPresent()) {
        model.addAttribute("pizza", pizza.get());
            return "pizzas/show";
        } else {
            return "redirect:/pizzas";
        }
}
}

