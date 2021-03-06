package gerenciamentobiblioteca;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo C.
 */
public class Program {
    public static void main(String[] args) {
        boolean isSecaoCriada = false;
        boolean isPrateleiraCriada = false;
        List<Secao> secoes = new ArrayList<Secao>();
        int escolha;
        do{
            Object[] opcoes = {"Criar nova seção","Sair"};
            escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção",
                    "Bem-vindo(a)", 0, 2, null, opcoes, opcoes[0]);
            switch(escolha){
                case 0:
                    int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja criar uma nova seção?");
                    switch(confirm){
                        case 0:
                            int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Insira o número da seção",
                                    "Configurações iniciais 1/2",2));
                            String nome = JOptionPane.showInputDialog(null,"Insira o nome da seção",
                                    "Configurações iniciais 1/2",2);
                            Secao novaSecao = new Secao();
                            novaSecao.setNome(nome);
                            novaSecao.setNumero(numero);
                            secoes.add(novaSecao);
                            isSecaoCriada = true;
                            break;
                        case 1:
                            break;
                    }                
                    break;
            }
        }while(isSecaoCriada==false && escolha !=1);
        
        if (isSecaoCriada) {
            List<Prateleira> prateleiras = new ArrayList<Prateleira>();
            do{
                Object[] opcoes = {"Criar nova prateleira","Sair"};
                escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção",
                        "Bem-vindo(a)", 0, 2, null, opcoes, opcoes[0]);
                switch(escolha){
                    case 0:
                        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja criar uma nova prateleira?");
                        switch(confirm){
                            case 0:
                                int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Insira o número da prateleira",
                                        "Configurações iniciais 1/2",2));
                                int numeroSecao = Integer.parseInt(JOptionPane.showInputDialog(null,"Insira o número da seção correspondente",
                                        "Configurações iniciais 2/2",2));
                                Prateleira novaPrateleira = new Prateleira();
                                novaPrateleira.setNumero(numero);
                                prateleiras.add(novaPrateleira);
                                for (Secao node:secoes) {
                                    if (node.getNumero() == numeroSecao) {
                                        node.addPrateleira(novaPrateleira);
                                    }
                                }

                                isPrateleiraCriada = true;
                                break;
                            case 1:
                                break;
                        }                
                        break;
                }
            }while(!isPrateleiraCriada && escolha !=1);
        }
        if (isPrateleiraCriada) {
            do {
                Object[] opcoes = {"Gerenciar seções","Gerenciar funcionários","Gerenciar clientes","Sair"};
                escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Gerenciamento de biblioteca.",
                        0, 2, null, opcoes, opcoes[0]);
                switch(escolha){
                    case 0:
                        int gerenciar;
                        do {
                            Object[] gerenciamentoSecoes = {"Visualizar seções","Adicionar seção","Deletar seção","Voltar"};
                            gerenciar = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Gerenciando seções",
                                0, 2, null, gerenciamentoSecoes, gerenciamentoSecoes[0]);
                            switch(gerenciar){
                                case 0:
                                    
                                    Object[] gerenciamentoSecoes2 = {"Visualizar prateleiras","Adicionar prateleiras","Remover prateleiras","Avançar","Voltar"};
                                    int i = 1;
                                    int control = 0;
                                    int voltar = 0;
                                    int cont = 0;
                                    Secao node = secoes.get(cont);
                                    int gerenciarSecao = JOptionPane.showOptionDialog(null, "Nome: "+node.getNome()+"\nNúmero: "+node.getNumero()+"\nQtd de prateleiras: "+node.getPrateleiras().size(), "Visualizando - Seção "+i, 0, 2, null, gerenciamentoSecoes2, gerenciamentoSecoes2[0]);
                                    do {
                                        switch(gerenciarSecao){
                                            case 3:
                                                if(cont == (secoes.size() - 1)){
                                                    //cont = 0;
                                                }
                                                else{
                                                    cont++;
                                                    i++;
                                                }
                                                    node = secoes.get(cont);
                                                break;
                                            case 4:
                                                if(cont == 0){
                                                    control = 1;
                                                }
                                                else{
                                                    cont--;
                                                    node = secoes.get(cont);
                                                    i--;
                                                }
                                                break;
                                        }
                                        if (control != 1) {
                                        gerenciarSecao = JOptionPane.showOptionDialog(null, "Nome: "+node.getNome()+"\nNúmero: "+node.getNumero()+"\nQtd de prateleiras: "+node.getPrateleiras().size(), "Visualizando - Seção "+i, 0, 2, null, gerenciamentoSecoes2, gerenciamentoSecoes2[0]);
                                        }
                                    } while (control == 0);
                                    break;
                                case 1:
                                    int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja criar uma nova seção?");
                                    switch(confirm){
                                        case 0:
                                            int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Insira o número da seção",
                                                    "Configurações da nova seção 1/2",2));
                                            String nome = JOptionPane.showInputDialog(null,"Insira o nome da seção",
                                                    "Configurações da nova seção 1/2",2);
                                            Secao novaSecao = new Secao();
                                            novaSecao.setNome(nome);
                                            novaSecao.setNumero(numero);
                                            secoes.add(novaSecao);
                                            break;
                                        case 1:
                                            break;
                                    }
                                    break;

                            }
                        } while (gerenciar !=3);
                        
                        break;
                }
            } while (escolha != 3);
            
        }
        
    }
    
}
