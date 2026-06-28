package main;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Cliente;
import model.Funcionario;
import model.Produto;
import model.Venda;

public class App {

    public static void main(String[] args) {
        
        ArrayList<Produto> listaDeProdutos = new ArrayList<>();
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();

        listaFuncionarios.add(new Funcionario("Diego", "11122233344", 1, "Gerente", "1234"));
        listaFuncionarios.add(new Funcionario("Venancio", "55566677788", 2, "Funcionario", "4321"));

        Produto p1 = new Produto(1, "12/2026", "Cachaça 51", 20, 85.50);
        listaDeProdutos.add(p1);
        Produto p2 = new Produto(2, "05/2027", "Cerveja Skol", 100, 15.00);
        listaDeProdutos.add(p2);

        Funcionario funcionarioLogado = null;

        while (funcionarioLogado == null) {
            
            JTextField idLoginField = new JTextField();
            JTextField senhaLoginField = new JTextField();

            Object[] formularioLogin = {
                "SISTEMA DA ADEGA",
                "ID do Funcionário:   [1] ou [2]", idLoginField,
                "Senha:   [1234] ou [4321]", senhaLoginField
            };

            int acao = JOptionPane.showConfirmDialog(null, formularioLogin, "Acesso Restrito", JOptionPane.OK_CANCEL_OPTION);

            if (acao != JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(null, "Encerrando o sistema. Até logo!");
                System.exit(0);
            }

            try {
                int idDigitado = Integer.parseInt(idLoginField.getText());
                String senhaInput = senhaLoginField.getText(); 
                
                for (Funcionario f : listaFuncionarios) {
                    if (f.getId_func() == idDigitado && f.getSenha().equals(senhaInput)) {
                        funcionarioLogado = f;
                        break;
                    }
                }

                if (funcionarioLogado == null) {
                    JOptionPane.showMessageDialog(null, "ID ou Senha incorretos! Tente novamente.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro: O ID deve ser um número inteiro válido!", "Erro de Digitação", JOptionPane.WARNING_MESSAGE);
            }
        }


        boolean rodando = true;

        while (rodando) {

            String opcao = JOptionPane.showInputDialog(
                "Usuário: " + funcionarioLogado.getNome() + " (" + funcionarioLogado.getCargo() + ")\n" +
                "==== Menu Principal ====\n" +
                "1 - Listar Produtos \n"+
                "2 - Cadastrar Produto [não terminado ainda] \n" +
                "3 - Realizar Venda [não terminado ainda] \n" +
                "0 - Sair"
            );

            if (opcao == null || opcao.equals("0")) {
                rodando = false;
                break;
            }

            if (opcao.equals("1")) {
                if (listaDeProdutos.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado no estoque!");
                } else {
                    String textoCompleto = "=== PRODUTOS CADASTRADOS ===\n";
                    for (Produto p : listaDeProdutos) {
                        textoCompleto += p.exibirProduto() + "\n-------------------\n";
                    }
                    JOptionPane.showMessageDialog(null, textoCompleto);
                }           
            } 
            
            else if (opcao.equals("2")) {
                JTextField idField = new JTextField();
                JTextField nomeField = new JTextField();
                JTextField quantField = new JTextField();
                JTextField precoField = new JTextField();
                JTextField validadeField = new JTextField();

                Object[] mensagem = {
                    "ID do produto:", idField,
                    "Nome do produto:", nomeField,
                    "Quantidade:", quantField,
                    "Preço (ex: 10.50):", precoField,
                    "Data de validade (ex: 10/2028):", validadeField
                };

                int confirmacao = JOptionPane.showConfirmDialog(null, mensagem, "Cadastrar Novo Produto", JOptionPane.OK_CANCEL_OPTION);

                if (confirmacao == JOptionPane.OK_OPTION) {
                    try {
                        int id_produto = Integer.parseInt(idField.getText());
                        String nomeProd = nomeField.getText();
                        int quant = Integer.parseInt(quantField.getText());
                        double preco = Double.parseDouble(precoField.getText());
                        String dataValidade = validadeField.getText();

                        funcionarioLogado.cadastrarProd(id_produto, dataValidade, nomeProd, quant, preco, listaDeProdutos);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Erro na digitação de números! O cadastro foi cancelado.");
                    }
                }
            } 
            
            else if (opcao.equals("3")) {
                if (listaDeProdutos.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Não há produtos para vender!");
                    continue;
                }

                JTextField idBuscaField = new JTextField(15);
                JTextField qtdField = new JTextField(15);

                Object[] formularioVenda = {
                    "Digite o ID do produto:", idBuscaField,
                    "Quantidade desejada:", qtdField
                };

                int confirmacaoVenda = JOptionPane.showConfirmDialog(null, formularioVenda, "Realizar Venda", JOptionPane.OK_CANCEL_OPTION);

                if (confirmacaoVenda == JOptionPane.OK_OPTION) {
                    try {
                        int idBusca = Integer.parseInt(idBuscaField.getText());
                        int qtdDesejada = Integer.parseInt(qtdField.getText());

                        Produto prodEncontrado = null;

                        for (Produto p : listaDeProdutos) {
                            if (p.getIdProduto() == idBusca) {
                                prodEncontrado = p;
                                break;
                            }
                        }

                        if (prodEncontrado == null) {
                            JOptionPane.showMessageDialog(null, "Produto não encontrado no estoque!");
                        } else {
                            Cliente clienteTemp = new Cliente(1, "Cliente Balcão", "65999990000", "00011122233");
                            
                            Venda novaVenda = clienteTemp.efetuarCompra(5001, prodEncontrado, qtdDesejada);

                            if (novaVenda != null) {
                                JOptionPane.showMessageDialog(null, novaVenda.toString(), "Recibo da Venda", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Venda cancelada: Estoque insuficiente! (Disponível: " + prodEncontrado.getQuantidade() + ")");
                            }
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Erro na digitação! Insira apenas números inteiros para o ID e a quantidade.");
                    }
                }
            } 
            
            else {
                JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }
    }
}
//falta diminuir a main e termainar o 2 e 3 