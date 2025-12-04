/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.proyectoarboles;

/**
 *
 * @author killu
 */
public class Arbol 
{
    public nodo raiz;
    public nodo obs;
    
    public Arbol ()
    {
        raiz = null;
        obs = null;
    }
    
    public void Recorrido()
    {
        RecorridoRec(raiz);
    }
    public void RecorridoRec (nodo act)
    {
        if (act != null)
        {
            System.out.print(act.valor + ", ");
            RecorridoRec(act.izq);
            
            System.out.print(act.valor + ", ");
            RecorridoRec(act.der);
            
            System.out.print(act.valor + ", ");
        }
    }
    
    public boolean FindKey(int v)
    {
        boolean found  = false;
        nodo q;
        q = raiz;
        
        while (!found && q != null)
        {
            if (v == q.valor)
            {
                obs = q;
                found = true;
            }
            else 
            {
                if (v < q.valor)
                {
                    if (q.izq == null)
                        obs = q;
                    q = q.izq;
                }
                else 
                {
                    if (q.der == null) 
                        obs = q;
                    q = q.der;
                }
            }
        }
        return found;
    }

    public void Insert (int v)
    {
        nodo nuevo, psave;
        boolean found = false;
        psave = obs;
        found = FindKey(v);
        
        if (found)
        {
            System.out.println("El nodo ya existe.");
            obs = psave;
        }
        else
        {
            nuevo = new nodo(v);
            
            if (raiz == null)
            {
                raiz = nuevo;
            }
            else 
            {
                if (v < obs.valor)
                    obs.izq = nuevo;
                else
                    obs.der = nuevo;
            }
            
            obs = nuevo;
        } 
    }
    
    public int Altura()
    {
        return AlturaRec(raiz);
    }
            
    public int AlturaRec(nodo act)
    {
        if (act == null)
            return 0;
        
        int subizq = AlturaRec(act.izq);
        int subder = AlturaRec(act.der);
       
        if(subizq > subder || subizq == subder)
            return subizq + 1;
        else
            return subder + 1;
    }
    
    public int Tamano()
    {
        return TamanoRec(raiz);
    }
    
    public int TamanoRec(nodo act)
    {
        if (act == null)
            return 0;
        
        int subizq = TamanoRec(act.izq);
        int subder = TamanoRec(act.der);
        
        return ( subizq + subder ) + 1;
    }
    
    public double LRP()
    {
        int n =  0;
        double promedio = LRPRec(raiz, n)/ TamanoRec(raiz);
        
        return promedio;
    }
    public double LRPRec(nodo act, int n)
    {
        
        if (act != null)
        {
            
            double subizq = LRPRec(act.izq, n+1);
            double subder = LRPRec(act.der, n+1);
            
            double suma = (subizq + subder) + n + 1;
            
            return suma;
            
        }
        return 0;
    }
}
