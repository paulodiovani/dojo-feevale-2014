/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.feevale;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Carlos
 * @author Paulo Diovani
 */
public class Lista<T> implements List {
    private Node<T> primeiro = null;
    private Node<T> ultimo = null;
    private int tamanho = 0;
    
    @Override
    public int size() {
        return tamanho;
    }

    @Override
    public boolean isEmpty() {
        if (tamanho == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray(Object[] ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Object e) {
        Node<T> nodo = new Node();
        nodo.adicionaConteudo((T)e);
        this.tamanho ++;
        
        
        if(primeiro == null){
            primeiro = nodo;
        } else {
            ultimo.setProximo(nodo);
        }
        
        ultimo = nodo;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int i, Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        
        while( primeiro.getProximo()!=null){
            primeiro = primeiro.getProximo();
        }
        primeiro = null;
        tamanho = 0;
    }

    @Override
    public Object get(int i) {
        if(i < 0){
            return null;
        }
        Node<T> atual = primeiro;
        for(int y = 0; y < this.size();y++){
            if(y == i){
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    @Override
    public Object set(int i, Object e) {
         for(int j = 0; j < this.tamanho; j++) {
            if(j == i){
                Node<T> atual = (Node<T>)this.get(i);
                Node<T> velho = atual;
                Node<T> anterior = (Node<T>)this.get(i - 1);
                atual = new Node();
                atual.adicionaConteudo((T)e);
                anterior.setProximo(atual);
                return velho;
            } 
        }
        return false;
    }

    @Override
    public void add(int i, Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object remove(int i) { 
        for(int j = 0; j < this.tamanho; j++) {
            if(j == i){
                Node<T> atual = (Node<T>)this.get(i);
                Node<T> anterior = (Node<T>)this.get(i - 1);
                
                if(anterior != null) {
                    anterior.setProximo(atual.getProximo());
                }
                tamanho--;
                return atual;
                
                
            } 
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator listIterator(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List subList(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
