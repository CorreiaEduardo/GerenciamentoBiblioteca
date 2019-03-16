/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentobiblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class Prateleira {
    private int numero;
    private List<Livro> livros = new ArrayList<Livro>();
    
    public List<Livro> getLivros(){
        return this.livros;
    }
    public void addLivro(Livro novoLivro){
        this.livros.add(novoLivro);
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
}
