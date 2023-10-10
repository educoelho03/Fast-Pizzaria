package br.com.pizzaria.fastPizzas.exceptions;

public class FuncionarioNotFoundException extends RuntimeException {
    public FuncionarioNotFoundException(String s){
        super(s);
    }
}
