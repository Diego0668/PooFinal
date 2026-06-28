package model;


public class Adega {

    private Produto produto;
    private Funcionario funcionario;
    private Cliente cliente;

    public Adega(Produto produto , Funcionario funcionario , Cliente cliente){
        
        this.produto = produto;
        this.funcionario = funcionario;
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    
}
