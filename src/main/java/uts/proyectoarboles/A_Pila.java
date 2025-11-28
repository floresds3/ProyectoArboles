/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.proyectoarboles;

/**
 *
 * @author killu
 */
public class A_Pila 
{
    private nodo inicio;
    private int maxSize;
    private int tope;
    
    public A_Pila()
    {
        inicio = null;
        tope = 0;
        maxSize = 0;
    }
    
    public boolean Full()
    {
        return tope == maxSize;
    }
    
    public boolean Empty()
    {
        return inicio == null;
    }
    
    public boolean Size(int newTamano)
    {        
        if (newTamano > 0 && newTamano != maxSize)
        {
            maxSize = newTamano;
            
            nodo act = inicio;
            
            if (newTamano < tope)
            {
                for (int i = 1; i < newTamano; i++)
                {
                    act = act.sig;
                }
                
                act.sig = null;
                
                tope = newTamano;       
            }
            
            return true;
        }
        else
            return false;
    }
    
    public boolean Push(int v)
    {
        nodo nuevo = new nodo(v);
        if (!Full())
        {
            if (inicio == null)
            {
                inicio = nuevo;
                tope++;
                return true;
            }
            else
            {
                nodo act = inicio;
                while(act.sig != null)
                {
                    act = act.sig;
                }
                act.sig = nuevo;
                tope++;
                return true;
            }
        }
        else
            return false;
    }
    
    public int Pop()
    {
        int valor = 0;
        
        if (!Empty())
        {
            if (tope == 1)
            {
                valor = inicio.valor;
                inicio = null;
                tope--;
                return valor;
            }
            else 
            {
                nodo act = inicio;
                
                for (int i = 0; i < tope - 2; i++)
                {
                    act = act.sig;
                }
                
                valor = act.sig.valor;
                act.sig = null;
                
                tope--;
                return valor;
            }
        }
        else 
        {
            return -1;
        }
    }
    
    public void Print()
    {
        if (inicio == null)
            System.out.println("La pila esta vacia");
        else 
        {
//            nodo act = inicio;
//            while(act != null)
//            {
//                System.out.println(act.valor);
//                act = act.sig;
//            }
            
            nodo act = inicio;
            
            RecursividadPrint(act);
        }
    }
    
    public void RecursividadPrint(nodo act)
    {
      if (act.sig != null)
      {
        RecursividadPrint(act.sig);
      }
      
        System.out.println(act.valor);
    }
}