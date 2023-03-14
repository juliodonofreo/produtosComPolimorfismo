package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class ProdutoUsado extends Produto{

    private LocalDate dataFabricacao;

    public ProdutoUsado() {
        super();
    }

    public ProdutoUsado(String nome, Double preco, LocalDate dataFabricacao) {
        super(nome, preco);
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    @Override
    public String etiquetaPreco() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%s (usado) R$%.2f (Data de fabricação: %s)", nome, preco, dataFabricacao.format(formatter));
    }
}
