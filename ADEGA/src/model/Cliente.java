package model;

public class Cliente extends Pessoa {

    private int id_cliente;
    private String telefone;


    public Cliente(int id_cliente, String nome, String telefone, String cpf) {
        super(nome, cpf); 
        this.id_cliente = id_cliente;
        this.telefone = telefone;
    }


    public Venda efetuarCompra(int idVenda, Produto produto, int quantidadeDesejada) {
        

        if (quantidadeDesejada > produto.getQuantidade()) {
            System.out.println("Erro: Estoque insuficiente do produto '" + produto.getNomeprod() + "' para o cliente " + this.getNome());
            return null;
        }


        int novoEstoque = produto.getQuantidade() - quantidadeDesejada;
        produto.setQuant(novoEstoque);


        Venda novaVenda = new Venda(idVenda, produto, this, quantidadeDesejada);
        
        return novaVenda;
    }


    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    @Override
    public String toString() {
        return "Cliente [ID: " + id_cliente + " | Nome: " + getNome() + " | Telefone: " + telefone + " | CPF: " + getCpf() + "]";
    }
}
/* 
falta arruma umas funçoes e separar em classes 
*/