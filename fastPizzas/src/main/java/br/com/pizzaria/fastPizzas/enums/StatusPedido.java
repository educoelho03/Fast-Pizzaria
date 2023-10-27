package br.com.pizzaria.fastPizzas.enums;

public enum StatusPedido {
    FINALIZADO(0, "FINALIZADO"),
    AGUARDANDO_PAGAMENTO(1, "AGUARDANDO_PAGAMENTO"),
    EM_ANDAMENTO(2, "EM_ANDAMENTO"),
    CANCELADO(3, "CANCELADO");

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
