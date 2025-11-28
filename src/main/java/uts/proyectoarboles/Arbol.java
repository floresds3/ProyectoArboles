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
    
    public void Recorrido (nodo act)
    {
        if (act != null)
        {
            System.out.print(act.valor + ", ");
            Recorrido(act.izq);
            
            System.out.print(act.valor + ", ");
            Recorrido(act.der);
            
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
            System.out.println("El nodo ya existe");
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
    
    public void Altura()
    {
        
    }
    
    public void Tamano()
    {
        
    }
    
    public void LFP()
    {
        
    }
}
