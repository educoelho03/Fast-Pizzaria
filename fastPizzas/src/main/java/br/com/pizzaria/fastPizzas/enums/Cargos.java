package br.com.pizzaria.fastPizzas.enums;

public enum Cargos {
    ZERO(0 , "GERENTE"),
    UM(1, "GARCOM"),
    DOIS(2, "FAXINEIRO"),
    TRES(3, "PIZZAIOLO"),
    QUATRO(4, "CAIXA");

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
