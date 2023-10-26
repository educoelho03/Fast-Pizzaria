package br.com.pizzaria.fastPizzas.enums;

public enum StatusPedido {
    ZERO(0, "FINALIZADO"),
    UM(1, "AGUARDANDO_PAGAMENTO"),
    DOIS(2, "EM_ANDAMENTO"),
    TRES(3, "CANCELADO");

    private final int codigo;
    private final String descricao;

    StatusPedido(int codigo, String descricao) {
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
