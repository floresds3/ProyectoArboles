/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.proyectoarboles;

/**
 *
 * @author killu
 */
public class A_Lista 
{
  private nodo inicio;
    
    public A_Lista()
    {
        inicio = null;
    }
    
    public void Add(int v)
    {
        nodo nuevo = new nodo(v);
        
        if (inicio == null)
            inicio = nuevo;
        else 
        {
            nodo act = inicio;
            while(act.sig != null)
            {
                act = act.sig;
            }
            act.sig = nuevo;
        }
    }
    public void Print()
    {
        if(inicio == null)
            System.out.println("No hay nodos en la lista.");
        else 
        {
            nodo act = inicio;
            while(act != null)
            {
                System.out.println(act.valor);
                act = act.sig;
            }
        }
    }
    public int Find(int pos)
    {
       if (inicio == null)
        {
            return -1;
        }
       else 
        {
            nodo act = inicio;
            
            for (int i = 0; i < pos; i++)
            {
                if (act.sig == null) 
                {
                    return -1;
                }
                
                act = act.sig;
            }
            
            return act.valor;
        }
    }
    
    public int Count()
    {
        //return cuenta los nodos que hay
        
        int i = 0;
        
        if (inicio == null)
        {
            return 0;
        }
        else 
        {
            nodo act = inicio;
            
            while (act != null)
            {
                act = act.sig;
                
                i++;
            }
            
            return i;
        }
    }
    public int FindValue(int valor)
    {
        //regresa lo contrario de find
        //si hay valores repetidos, arroja el primero
        //si no esta return -1
        
        int i = 0;
        
        if (inicio == null)
            return -1;
        else 
        {
            nodo act = inicio;
            
            while (act != null && act.valor != valor)
            {
                act = act.sig;
                i++;
            }
            
            if (act == null)
                return -1;
            else
                return i;
        }
    }
    public boolean Change(int pos, int NewVal)
    {
        //asigna nuevo valor en la posicion asignada
        //return true si el cambio es exitoso
        //si no, return false
        if (inicio == null)
            return false;
        else 
        {
            nodo act = inicio;
            
            for (int i = 0; i < pos; i++)
            {
                if (act.sig == null) 
                {
                    return false;
                }
                
                act = act.sig;
            }
            
            act.valor = NewVal;
            return true;
        }
    }
    public boolean delete(int pos)
    {
        //return true si se elimina el nodo
        //en la posicion indicada
        //si no, return false
        if (inicio == null)
            return false;
        
        if (pos < 0)
        {
           return false; 
        }
        else if (pos > 0)
        {
            nodo act = inicio;
            
            for (int i = 0; i < pos - 1 ; i++)
            {
                if (act.sig == null) 
                {
                    return false;
                }
                
                act = act.sig;
            }
            
            act.sig = act.sig.sig;
            
            return true;
        }
        else
        {
            inicio = inicio.sig;
            return true;
        }
    }  
}
