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
public class Secao {
    private int numero;
    private String nome;
    private List<Prateleira> prateleiras = new ArrayList<Prateleira>();
    
    public void addPrateleira(Prateleira novaPrateleira){
        this.prateleiras.add(novaPrateleira);
    }
    public List<Prateleira> getPrateleiras(){
        return this.prateleiras;
    }
    
    public int getNumero(){
        return this.numero;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
}
