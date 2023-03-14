package entidades;

import org.jetbrains.annotations.NotNull;

public final class ProdutoImportado extends Produto{
    private Double taxaAlfandega;

    public ProdutoImportado() {
        super();
    }

    public ProdutoImportado(String nome, Double preco, Double taxaAlfandega) {
        super(nome, preco);
        this.taxaAlfandega = taxaAlfandega;
        this.preco += taxaAlfandega;
    }

    public Double getTaxaAlfandega() {
        return taxaAlfandega;
    }

    public void setTaxaAlfandega(Double taxaAlfandega) {
        this.taxaAlfandega = taxaAlfandega;
    }

    @Override
    public String etiquetaPreco() {
        return String.format("%s R$%.2f (Taxa da alfândega: R$%.2f)", nome, preco, taxaAlfandega);
    }
}
