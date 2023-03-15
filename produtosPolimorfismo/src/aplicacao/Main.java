package aplicacao;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Produto[] produtos;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Digite o número de produtos: ");
        int n = sc.nextInt();
        sc.nextLine();
        produtos = new Produto[n];

        for(int i = 1; i <= n; i++){

            Produto produto = null;

            System.out.println("Dados do produto #" + i);
            System.out.print("comum, usado ou importado? (c/u/i) ");
            char tipo = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Preco: ");
            double preco = sc.nextDouble();
            sc.nextLine();

            if(tipo == 'c'){
                produto = new Produto(nome, preco);
            } else if (tipo == 'u') {
                System.out.print("Data de fabricação (DD/MM/YYYY)");
                LocalDate dataFabricacao = LocalDate.parse(sc.next(), formato);
                produto = new ProdutoUsado(nome, preco, dataFabricacao);
            } else{
                System.out.print("Taxa da alfândega: ");
                double taxa = sc.nextDouble();
                produto = new ProdutoImportado(nome, preco, taxa);
            }

            produtos[i - 1] = produto;
        }

        System.out.println("Etiquetas de preço: ");
        for(Produto produto: produtos) {
            System.out.println(produto.etiquetaPreco());
        }
        
        sc.close();
    }
}
