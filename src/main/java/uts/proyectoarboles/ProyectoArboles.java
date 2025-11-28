/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package uts.proyectoarboles;

import java.util.Scanner;

/**
 *
 * @author killu
 */
public class ProyectoArboles 
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        
        Arbol arbol = new Arbol();
        
        do
        {
            System.out.println("\nMenu Principal");
            
            System.out.println("1. Lista");
            System.out.println("2. Pilas");
            System.out.println("3. Colas");
            System.out.println("4. Arboles");
            System.out.println("5. Salir");
            
            System.out.print("Seleccione la opcion: ");
            op = sc.nextInt();
            
            System.out.println("");
            
            Opciones(op, sc, arbol);
             
            sc.nextLine();
            System.out.print("\nPRESIONE ENTER PARA CONTINUAR...");
            sc.nextLine();
        }while ( op != 5 );
        
        sc.close();
    }
    
    static void Opciones(int op, Scanner sc, Arbol arbol)
    {
        switch (op) 
        {
            case 1:
                System.out.println("Lista...");
                break;
            case 2:
                Pila();
                break;
            case 3:
                System.out.println("Colas");
                break;
            case 4:
                System.out.println("Arboles");
                break;
            case 5:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Ingrese alguna de las opciones del menu.");
        }
    }
    
    static void Lista()
    {
        
    }
    
    static void Pila()
    {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        
        A_Pila pila = new A_Pila();
        
        do
        {
            System.out.println("\nMENU PILAS");
            
            System.out.println("1. Asignar tamano de pila");
            System.out.println("2. Push");
            System.out.println("3. Pop");
            System.out.println("4. Imprimir pila");
            System.out.println("5. Salir");
            
            System.out.print("Seleccione la opcion: ");
            op = sc.nextInt();
            
            System.out.println("");
            
            OpcionesPila(op, sc, pila);
             
            sc.nextLine();
            System.out.print("\nPRESIONE ENTER PARA CONTINUAR...");
            sc.nextLine();
        }while ( op != 5 );
        
        sc.close();
    }
    
    static void OpcionesPila(int op, Scanner sc, A_Pila pila)
    {
        switch (op) 
        {
            case 1:                
                System.out.print("Ingrese el tamano de la pila: ");
                int t = sc.nextInt();
                
                if(pila.Size(t))
                    System.out.println("El tamano de la pila fue modificado exitosamente");
                else
                    System.out.println("No ha sido posible modificar la pila");
                break; 
            case 2:
                System.out.print("Ingrese el valor a agregar: ");
                int valor = sc.nextInt();
                
                if(pila.Push(valor))
                    System.out.println("Se agrego el valor exitosamente");
                else
                    System.out.println("No fue posible agregar el valor");
                break;
            case 3:
                int e = pila.Pop();
                
                if (e == -1)
                    System.out.println("La pila esta vacia");
                else
                    System.out.println("Se elimino el nodo con valor de: " +e);
                break;
            case 4:
                pila.Print();
                break;
            case 5:
                System.out.println("Saliendo..");
                break;
            default:
                System.out.println("Opcion no valida. Por favor, seleccione una de las opciones del menu.");
        }
    }
}
