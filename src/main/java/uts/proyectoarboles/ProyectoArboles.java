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
        
        A_Lista lista = new A_Lista();
        A_Pila pila = new A_Pila();
        A_Cola cola =  new A_Cola();
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
            
            Opciones(op, sc, arbol, lista, pila, cola);
        }while ( op != 5 );
        
        sc.close();
    }
    
    static void Opciones(int op, Scanner sc, Arbol arbol, A_Lista lista, A_Pila pila, A_Cola cola)
    {
        switch (op) 
        {
            case 1:
                Lista(lista, sc);
                break;
            case 2:
                Pila(pila, sc);
                break;
            case 3:
                Cola(cola, sc);
                break;
            case 4:
                Arbol(arbol, sc);
                break;
            case 5:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Ingrese alguna de las opciones del menu.");
        }
    }
    
    static void Lista(A_Lista lista, Scanner sc)
    {
        int op = 0;
        
        do
        {
            System.out.println("MENU LISTA");
            
            System.out.println("1. Insertar nodo");
            System.out.println("2. Encontrar nodo");
            System.out.println("3. Cambiar nodo");
            System.out.println("4. Encontrar valor de nodo");
            System.out.println("5. Borrar nodo");
            System.out.println("6. Imprimir tamamo de la lista");
            System.out.println("7. Imprimir lista");
            System.out.println("8. Volver a menu principal");
            
            System.out.print("Seleccione la opcion: ");
            op = sc.nextInt(); 
            
            System.out.println("");

            OpcionesLista(op, sc, lista);
            
            sc.nextLine();
            System.out.print("\nPRESIONE ENTER PARA CONTINUAR...");
            sc.nextLine();
        }while ( op != 8 );
    }
    
    static void OpcionesLista(int op, Scanner sc, A_Lista lista)
    {
        switch (op) 
        {
            case 1:
                System.out.print("Ingrese el valor del nodo: ");
                int valor = sc.nextInt();
                lista.Add(valor);
                System.out.println("Nodo agregado exitosamente.\n");
                break; 
            case 2:
                System.out.print("Ingrese la posicion del nodo: ");
                int pos1 = sc.nextInt();
                
                int resultado = lista.Find(pos1);
                System.out.println("Posicion " +pos1+ " valor: " +resultado+ "\n");
                break;
            case 3:
                System.out.print("Ingrese la posicion del nodo a cambiar: ");
                int pos = sc.nextInt();
                
                System.out.print("\nAhora ingrese el nuevo valor: ");
                int newValue = sc.nextInt();
                
                if (lista.Change(pos, newValue))
                    System.out.println("Nodo cambiado con exito.");
                else
                    System.out.println("Ocurrio un error.");
                break;
            case 4:
                System.out.print("Ingrese el valor del nodo a buscar");
                int v = sc.nextInt();
                
                int i = lista.FindValue(v);
                
                if (i != -1) 
                {
                    System.out.println("Valor en posición: " +i);
                }
                else 
                {
                    System.out.println("No se ha encontrado el valor.");
                }
                break;
            case 5:
                System.out.print("Ingrese la posicion a borrar: ");
                int pos2 = sc.nextInt();
                
                if (lista.delete(pos2))
                    System.out.println("Se ha eliminado el nodo exitosamente.");
                else 
                    System.out.println("No se ha podido eliminar el nodo.");
                break;
            case 6:
                System.out.println("Imprimiendo tamaño de la lista...");
                int cont = lista.Count();
                
                if (cont != 0)
                    System.out.println("El tamano de la lista es de: " +cont);
                else
                    System.out.println("Lista vacía");
                break;               
            case 7:
                System.out.println("Imprimiendo lista..");
                lista.Print();
                break;
            case 8:
                System.out.println("Regresando a menu principal...");
                break;
            default:
                System.out.println("Opcion no valida. Por favor, seleccione una de las opciones del menu.");
        }
    }
    
    static void Pila(A_Pila pila, Scanner sc)
    {
        int op = 0;
        
        do
        {
            System.out.println("\nMENU PILAS");
            
            System.out.println("1. Asignar tamano de pila");
            System.out.println("2. Push");
            System.out.println("3. Pop");
            System.out.println("4. Imprimir pila");
            System.out.println("5. Volver a menu principal");
            
            System.out.print("Seleccione la opcion: ");
            op = sc.nextInt();
            
            System.out.println("");
            
            OpcionesPila(op, sc, pila);
             
            sc.nextLine();
            System.out.print("\nPRESIONE ENTER PARA CONTINUAR...");
            sc.nextLine();
        }while ( op != 5 );
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
                System.out.println("Regresando a menu principal...");
                break;
            default:
                System.out.println("Opcion no valida. Por favor, seleccione una de las opciones del menu.");
        }
    }
    
    static void Cola(A_Cola cola, Scanner sc)
    {
        int op = 0;
        
        do
        {
            System.out.println("\nMENU COLAS");
            
            System.out.println("1. Asignar tamano de cola");
            System.out.println("2. Insert");
            System.out.println("3. Extract");
            System.out.println("4. Imprimir cola");
            System.out.println("5. Volver a menu principal");
            
            System.out.print("Seleccione la opcion: ");
            op = sc.nextInt();
            
            System.out.println("");
            
            OpcionesCola(op, sc, cola);
             
            sc.nextLine();
            System.out.print("\nPRESIONE ENTER PARA CONTINUAR...");
            sc.nextLine();
        }while ( op != 5 );
    }
    
    static void OpcionesCola(int op, Scanner sc, A_Cola cola)
    {
        switch (op) 
        {
            case 1:                
                System.out.println("Ingrese el tamano de la cola: ");
                int t = sc.nextInt();
                
                if(cola.Size(t))
                    System.out.println("El tamano de la cola fue modificado exitosamente");
                else
                    System.out.println("No ha sido posible modificar la cola");
                break; 
            case 2:
                System.out.print("Ingrese el valor a agregar: ");
                int valor = sc.nextInt();
                
                if(cola.Insert(valor))
                    System.out.println("Se agrego el valor exitosamente");
                else
                    System.out.println("No fue posible agregar el valor");
                break;
            case 3:
                int e = cola.Extract();
                
                if (e == -1)
                    System.out.println("La cola esta vacia");
                else
                    System.out.println("Se elimino el nodo con valor de: " +e);
                break;
            case 4:
                cola.Print();
                break;
            case 5:
                System.out.println("Regresando a menu principal...");
                break;
            default:
                System.out.println("Opcion no valida. Por favor, seleccione una de las opciones del menu.");
        }
    }
    static void Arbol(Arbol arbol, Scanner sc)
    {
        int op;
        
        do
        {
            System.out.println("    MENU PRINCIPAL    ");
            System.out.println("");
            System.out.println("1. Insertar nodo");
            System.out.println("2. Imprimir tamaño");
            System.out.println("3. Imprimir altura");
            System.out.println("4. Imprimir LRP");
            System.out.println("5. Imprimir recorrido");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.println("-----------------------");
            System.out.println("");
            System.out.print("Seleccione la opcion: ");
            op = sc.nextInt();
            
            System.out.println("");
            
            OpcionesArbol(op, sc, arbol);
             
            sc.nextLine();
            System.out.print("\nPRESIONE ENTER PARA CONTINUAR...");
            sc.nextLine();
            

        }
        while (op != 6);
    }
    
    static void OpcionesArbol(int op, Scanner sc, Arbol arbol) 
    {
        switch (op) 
        {
            case 1:
                System.out.print("Ingrese el valor a insertar: ");
                int n = sc.nextInt();
                
                arbol.Insert(n);
                break;
                
            case 2:
                System.out.println("Imprimiendo tamano...");
                
                int tam = arbol.Tamano();
                System.out.println("El Tamano del arbol es de " + tam);
                break;
                
            case 3:
                System.out.println("Imprimiendo Altura...");
                
                int alt = arbol.Altura();
                System.out.println("La altura del arbol es de " + alt);
                break;
            case 4:
                System.out.println("Imprimiento LRP...");
                
                double LRP = arbol.LRP();
                System.out.println("El LRP del arbol es de " + LRP);
                break;
            case 5:
                System.out.println("Imprimiendo recorrido...");
                
                arbol.Recorrido();
                break;
        }
    }
}
