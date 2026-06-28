package model;

public class Produto {

    private int id_produto;
    private String dataValidade;
    private String nomeProd;
    private int quantidade;
    private double preco;


    public Produto(int id_produto, String dataValidade, String nomeProd, int quantidade, double preco) {
        this.id_produto = id_produto;
        this.dataValidade = dataValidade;
        this.nomeProd = nomeProd;
        this.quantidade = quantidade;
        this.preco = preco;
    }


    public Produto() {
    }


    public int getIdProduto() { 
        return id_produto; 
    }
    
    public String getDataValidade() { 
        return dataValidade; 
    }
    
    public String getNomeprod() { 
        return nomeProd; 
    }
    
    public int getQuantidade() { 
        return quantidade; 
    }
    
    public double getPreco() { 
        return preco; 
    }


    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public void setQuant(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


    public String exibirProduto() {
        return "ID: " + id_produto + "\n" +
               "Produto: " + nomeProd + "\n" +
               "Quantidade: " + quantidade + "\n" +
               "Preço: R$ " + preco + "\n" +
               "Validade: " + dataValidade;
    }

    @Override
    public String toString() {
        return "ID: " + id_produto + " | Nome: " + nomeProd + " | Quantidade: " + quantidade + " | Preço: R$ " + preco;
    }
}