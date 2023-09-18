package entidades;

public class ProdutoImportado extends Produto {
    private double taxaAlfandega;

    public ProdutoImportado() {
    }

    public ProdutoImportado(String nome, double preco, double taxaAlfandega) {
        super(nome, preco);
        this.taxaAlfandega = taxaAlfandega;
    }

    public double getTaxaAlfandega() {
        return taxaAlfandega;
    }

    public void setTaxaAlfandega(double taxaAlfandega) {
        this.taxaAlfandega = taxaAlfandega;
    }

    public Double precoTotal() {
        return getPreco() + taxaAlfandega;
    }

    @Override
    public String etiquetaDePreco () {
        return getNome() + " $ " + String.format("%.2f", precoTotal())
                + " (Taxa de Alfândega: $ " + taxaAlfandega + " )";
    }


}
