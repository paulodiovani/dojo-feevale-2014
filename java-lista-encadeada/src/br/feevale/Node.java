/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.feevale;

/**
 *
 * @author Carlos
 * @author Paulo Diovani
 */
public class Node<T> {
    private Node anterior = null;
    private T conteudo;
    private Node proximo = null;
    
    public void setConteudo(T e) {
        this.conteudo = e;
    }

    public T getConteudo() {
        return this.conteudo;
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
