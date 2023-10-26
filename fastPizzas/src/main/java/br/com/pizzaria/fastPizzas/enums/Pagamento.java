package br.com.pizzaria.fastPizzas.enums;

// Melhorar ENUM - Colocar chave valor?
public enum Pagamento {
    ZERO(0, "Cartão de Crédito"),
    UM(1, "Cartão de Débito"),
    DOIS(2, "Dinheiro"),
    TRES(3, "PIX");

    private final int codigo;
    private final String descricao;

    Pagamento(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCodigo(){
        return codigo;
    }

//    public static Pagamento getCodigoBy(int codigo){
//        for(Pagamento pagamento : values()){
//            if (pagamento.codigo == codigo){
//                return pagamento;
//            }
//        }
//
//        throw new IllegalArgumentException("Forma de pagamento inválida. ");
//    }
}
