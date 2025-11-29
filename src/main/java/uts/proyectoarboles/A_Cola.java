/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.proyectoarboles;

/**
 *
 * @author killu
 */
public class A_Cola 
{
    private nodo inicio;
    private nodo fin;
    private int maxSize;
    private int count;
    
    public A_Cola()
    {
        inicio = null;
        fin = null;
        count = 0;
        maxSize = 0;
    }
    
    public boolean OverFlow()
    {
        return count == maxSize;
    }
    
    public boolean UnderFlow()
    {
        return inicio == null;
    }
    
    public boolean Size(int newTamano)
    {        
        if (newTamano > 0 && newTamano != maxSize)
        {
            maxSize = newTamano;
            
            nodo act = inicio;
            
            if (newTamano < count)
            { 
                for (int i = 0; i < newTamano - 1; i++)
                {
                    act = act.sig;
                }
                
                fin = act;
                
                fin.sig = null;
                
                count = newTamano;      
            }
            
            return true;
        }
        else
            return false;
    }
    
    public boolean Insert(int v)
    {
        nodo nuevo = new nodo(v);
        if (!OverFlow())
        {
            if (inicio == null)
            {
                inicio = nuevo;
                fin = nuevo;
                count++;
                return true;
            }
            else
            {
                fin.sig = nuevo;
                fin = nuevo;
                count++;
                return true;
            }
        }
        else
            return false;
    }
    
    public int Extract()
    {
        int valor = 0;
        
        if (!UnderFlow())
        {
            if (count == 1)
            {
                valor = inicio.valor;
                inicio = null;
                
                fin = null;
                
                count--;
                return valor;
            }
            else 
            {
                valor = inicio.valor;
                
                inicio = inicio.sig;
                
                count--;
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
            System.out.println("La cola esta vacia");
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
}
