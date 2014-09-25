/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dojo.java;

/**
 *
 * @author Carlos
 */
public class Node<T> {
    private Node anterior = null;
    private T conteudo;
    private Node proximo = null;
    
    public void adicionaConteudo(T e) {
        this.conteudo = e;
    }
    
    public String toString(){
        return conteudo.toString();
    }
    
    public void setProximo(Node<T> e) {
        this.proximo = e;
    }
    
    public Node<T> getProximo() {
        return this.proximo;
    }
}
