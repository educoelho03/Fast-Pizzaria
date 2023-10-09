package br.com.pizzaria.fastPizzas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {

    @GetMapping("/")
    public ModelAndView listaCardapio(){
        return new ModelAndView("index"); // Retorna uma pagina HTML
    }
}
