package gerenciamentobiblioteca;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Program {
    //teste
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
                                    Secao node = secoes.get(0);
                                    int gerenciarSecao = JOptionPane.showOptionDialog(null, ":\nNome: "+node.getNome()+"\nNúmero: "+node.getNumero()+"\nQtd de prateleiras: "+node.getPrateleiras().size(), "Visualizando - Seção "+i, 0, 2, null, gerenciamentoSecoes2, gerenciamentoSecoes2[0]);
                                    do {
                                        switch(gerenciarSecao){
                                            case 3:
                                                cont++;
                                                if(cont>secoes.size()){
                                                    //control = 1;
                                                    cont--;
                                                }
                                                else{
                                                    node = secoes.get(cont);
                                                    i++;
                                                }
                                                break;
                                            case 4:
                                                cont--;
                                                if(cont<1){
                                                    cont++;
                                                }
                                                else{
                                                    node = secoes.get(cont);
                                                    i--;
                                                }
                                                break;
                                        }
                                        gerenciarSecao = JOptionPane.showOptionDialog(null, ":\nNome: "+node.getNome()+"\nNúmero: "+node.getNumero()+"\nQtd de prateleiras: "+node.getPrateleiras().size(), "Visualizando - Seção "+i, 0, 2, null, gerenciamentoSecoes2, gerenciamentoSecoes2[0]);
                                    } while (control == 0);

                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
//                                    for (Secao node:secoes) {
//                                        voltar = 0;
//                                        while(voltar == 0){
//                                            int gerenciarSecao = JOptionPane.showOptionDialog(null, ":\nNome: "+node.getNome()+"\nNúmero: "+node.getNumero()+"\nQtd de prateleiras: "+node.getPrateleiras().size(), "Visualizando - Seção "+i, 0, 2, null, gerenciamentoSecoes2, gerenciamentoSecoes2[0]);
//                                            System.out.println(i);
//                                            if (gerenciarSecao == 3) {
//                                                if (i > secoes.size()) {
//                                                    control = 1;
//                                                    JOptionPane.showMessageDialog(null, "Fim da lista.", "Retornando", 2);
//                                                }
//                                                else{
//                                                    i++;
//                                                    node = secoes.get(i+1);
//                                                    voltar = 0;
//                                                    //continue;a
//                                                }
//                                            }
//                                            else if (gerenciarSecao == 4) {
//                                                if (i!=1) {
//                                                    i--;
//                                                    node = secoes.get(i-1);
//                                                    voltar = 0;
//                                                }
//                                                else{
//                                                    control = 1;
//                                                }
//                                            }
//                                        }
//                                        if (control ==1) {
//                                            break;
//                                        }
//                                        cont++;
//                                    }
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
