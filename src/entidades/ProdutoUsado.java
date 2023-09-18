package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ProdutoUsado extends Produto{
    private LocalDate dataFabricacao;

    public ProdutoUsado(){
    }
    public ProdutoUsado(String nome, double preco, LocalDate dataFabricacao) {
        super(nome,preco);
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    @Override
    public String etiquetaDePreco () {
        return getNome() + "(Usado)" + " $ " + String.format("%.2f", getPreco())
                +" (Data de frabricação: "
                + dataFabricacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+ ")";
    }
}



