package model;

public class Venda {

    private int id_Venda;
    private double precoTotal;
    private Produto produto;
    private Cliente cliente;
    
    private int quantidadeComprada; 

    public Venda(int id_Venda, Produto produto, Cliente cliente, int quantidadeComprada) {
        this.id_Venda = id_Venda;
        this.produto = produto;
        this.cliente = cliente;
        this.quantidadeComprada = quantidadeComprada;

        this.calcularTotal();
    }

    public void calcularTotal() {
    
        this.precoTotal = this.produto.getPreco() * this.quantidadeComprada;
    }

    /* 
    **criar a função realizarVenda, onde o cliente compra um produto e o estoque do produto é atualizado, e o valor total da venda é calculado
        tendo uim verificador de estoque, onde se a quantidade desejada for maior que a quantidade em estoque, a venda não é realizada e uma mensagem de erro é exibida
    **adiconar uma função de desconto para funcionario e cliente com o polimorfismo.
*/



    @Override
    public String toString() {
        return "=== RESUMO DA VENDA ===\n" +
               "Venda ID: " + id_Venda + "\n" +
               "Cliente: " + cliente.getNome() + "\n" + 
               "Produto: " + produto.getNomeprod() + " (x" + quantidadeComprada + ")\n" +
               "Total: R$ " + precoTotal + "\n" +
               "=======================";
    }
}