/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.feevale;

import java.util.*;

public class Lista<T> implements List {

    /**
     * Classe privada para retornar um Iterator
     * @param <T>
     */
    private class IteratorForLista<T> implements Iterator {
        private Lista<T> lista;
        private Node<T> current = null;
        private Node<T> next    = null;

        public IteratorForLista(Lista<T> lista) {
            this.lista = lista;
            this.next  = this.lista.primeiro;
        }

        @Override
        public boolean hasNext() {
            if (this.next == null) {
                return false;
            }
            return true;
        }

        @Override
        public Object next() {
            this.current = next;
            next = current.getProximo();
            return current.getConteudo();
        }

        @Override
        public void remove() {
            if (this.current == null) {
                throw new IllegalStateException();
            }

            this.lista.remove(this.current.getConteudo());
            this.current = null;
        }
    }

    private Node<T> primeiro = null;
    private Node<T> ultimo = null;
    private int tamanho = 0;

    @Override
    public int size() {
        return tamanho;
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(int cnt = 0; cnt < this.size(); cnt++) {
            if(this.get(cnt) == o){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new IteratorForLista<T>(this);
    }

    @Override
    public Object[] toArray() {
        ArrayList<T> arr = new ArrayList<T>();
        Iterator itr = this.iterator();

        while (itr.hasNext()) {
            arr.add((T) itr.next());
        }

        return arr.toArray();
    }

    @Override
    public Object[] toArray(Object[] ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Object e) {
        Node<T> nodo = new Node<T>();
        nodo.setConteudo((T) e);

        if (primeiro == null) {
            primeiro = nodo;
        } else {
            ultimo.setProximo(nodo);
        }

        ultimo = nodo;
        this.tamanho++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        for(int cnt = 0; cnt < this.size(); cnt++) {
            if(this.get(cnt) == o){
                this.remove(cnt);
                return true;
            }
        }
        return false;
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
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    @Override
    public Object get(int i) {
        if (i < 0) {
            return null;
        }

        Node<T> atual = primeiro;
        for (int y = 0; y < this.size(); y++) {
            if (y == i) {
                return atual.getConteudo();
            }
            atual = atual.getProximo();
        }

        return null;
    }

    @Override
    public Object set(int i, Object e) {
        if (i < 0) {
            return null;
        }

        T conteudo;
        Node<T> atual = primeiro;

        for (int y = 0; y < this.size(); y++) {
            if (y == i) {
                conteudo = atual.getConteudo();
                atual.setConteudo((T) e);
                return conteudo;
            }

            atual = atual.getProximo();
        }

        return null;
    }

    @Override
    public void add(int i, Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object remove(int i) {
        int j = 0;
        Node<T> atual = this.primeiro;
        Node<T> anterior = null;

        while (atual != null) {
            if (i == j) {
                if (i == 0) {
                    this.primeiro = atual.getProximo();
                } else {
                    anterior.setProximo(atual.getProximo());
                }

                if (atual == this.ultimo) {
                    this.ultimo = anterior;
                }

                this.tamanho--;
                return atual.getConteudo();
            }

            anterior = atual;
            atual = anterior.getProximo();
            j++;
        }

        return null;
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
