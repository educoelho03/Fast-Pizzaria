package br.com.pizzaria.fastPizzas.exceptions;

public class ClienteNotFoundException extends RuntimeException{
    public ClienteNotFoundException(String e){
        super(e);
    }
}
