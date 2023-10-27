package br.com.pizzaria.fastPizzas.enums;

public enum Cargos {
    GERENTE(0 , "GERENTE"),
    GARCOM(1, "GARCOM"),
    FAXINEIRO(2, "FAXINEIRO"),
    PIZZAIOLO(3, "PIZZAIOLO"),
    CAIXA(4, "CAIXA");

    private final int codigo;
    private final String descricao;

    Cargos(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
