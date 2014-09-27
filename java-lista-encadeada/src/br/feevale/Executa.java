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
public class Executa {
    
    public static void main(String args[]){
    
        Lista<String> lista = new Lista();
        
        System.out.println("Tamanho: " + lista.size());
        System.out.println("Esta vazio: " + lista.isEmpty());
        
        lista.add("teste");
        System.out.println("Add new: " + lista.size());
        System.out.println(lista.get(0).toString());

        lista.add("teste2");
        System.out.println("Add new 2: " + lista.size());
        System.out.println(lista.get(1).toString());
        
        lista.add("teste3");
        System.out.println("Add new 3: " + lista.size());
        System.out.println(lista.get(2).toString());

        lista.add("teste4");
        System.out.println("Add new 4: " + lista.size());
        System.out.println(lista.get(3).toString());
        
        /*lista.clear();
        System.out.println("Esta vazio: " + lista.isEmpty());
        System.out.println(lista.get(0));)*/
        System.out.println(lista.size());
        
        lista.set(2, "valorNovo");
        System.out.println("Valor novo " + lista.get(2));
        
        System.out.println(lista.get(1));
        lista.remove(1);
        System.out.println("Esta vazio: " + lista.isEmpty());
        System.out.println(lista.get(1));
        
        System.out.println(lista.size());
        
        
        
        Lista<String> listaNova = new Lista();
        lista.add("Segunda");
        lista.remove(0);
        System.out.println("Get: "+lista.get(0));
        
        
    
    }
}
