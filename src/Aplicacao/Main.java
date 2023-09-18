package Aplicacao;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Produto> list = new ArrayList<>();

        System.out.print("Entre com o número de produtos: ");
        int n = sc.nextInt();

        for (int idx = 1; idx <= n; idx++ ) {
            System.out.println("Dados do #°" + idx + " produto: ");
            System.out.print("O produto é comum, usado ou importado (c/u/i)?");
            char tipo = sc.next().charAt(0);
            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Preço: ");
            double preco = sc.nextDouble();
            if( tipo == 'c') {
                list.add(new Produto(nome, preco));
            } else if (tipo == 'u' ) {
                System.out.print("Data de fabricação (DD/MM/AAAA): ");
                LocalDate data = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                list.add(new ProdutoUsado(nome, preco, data));
            }
            else {
                System.out.print("Taxa de importação: ");
                double taxaImportacao = sc.nextDouble();
                list.add(new ProdutoImportado(nome, preco, taxaImportacao));
            }
        }
        System.out.println();
        System.out.println("Etiqueta de Preço: ");
        for ( Produto prod : list) {
            System.out.println(prod.etiquetaDePreco());
        }

         sc.close();
        }
}
