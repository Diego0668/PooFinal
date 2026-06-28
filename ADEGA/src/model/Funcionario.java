package model;

import java.util.List;
import javax.swing.JOptionPane;

public class Funcionario extends Pessoa {

    private int id_func;
    private String cargo;
    private String senha;


    public Funcionario(String nome, String cpf, int id_func, String cargo, String senha) {
        super(nome, cpf); 
        this.id_func = id_func;
        this.cargo = cargo;
        this.senha = senha;
    }


    public void cadastrarProd(int id_produto, String dataValidade, String nomeProd, int quantidade, double preco, List<Produto> estoqueGlobal) {
        

        Produto novoProduto = new Produto(id_produto, dataValidade, nomeProd, quantidade, preco);
        

        estoqueGlobal.add(novoProduto);


        JOptionPane.showMessageDialog(null, "Produto '" + nomeProd + "' cadastrado com sucesso pelo(a) " + this.getCargo() + " " + this.getNome());
    }


    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
/*
criar um login pro funcionario, para acessar as funçoes de cadastro e listagem de produtos ---ok
criar um menu para o funcionario escolher entre cadastrar produto, listar produtos, realizar venda, etc----ok
deixar apenas dois cargos sendo funcionario e gerente, onde o gerente tem acesso a todas as funçoes e o funcionario tem acesso apenas a cadastro e listagem de produtos----ok
falta diversificar as funçoes entre gerente e funcionario


*/
