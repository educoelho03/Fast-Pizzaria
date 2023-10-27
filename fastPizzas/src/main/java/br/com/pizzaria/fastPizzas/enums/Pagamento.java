package br.com.pizzaria.fastPizzas.enums;

// Melhorar ENUM - Colocar chave valor?
public enum Pagamento {
    CARTAO_CREDITO(0, "Cartão de Crédito"),
    CARTAO_DEBITO(1, "Cartão de Débito"),
    DINHEIRO(2, "Dinheiro"),
    PIX(3, "PIX");

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
