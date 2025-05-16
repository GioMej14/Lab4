/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mejia_trigo_estructura;

/**
 *
 * @author trigo
 */

import java.util.Scanner;

public class Mejia_Trigo_Estructura {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");
        //Menú principal
        int opcion;
        
        //Menú principal
        do {

            System.out.println("**** MENÚ PRINCIPAL ****");
            System.out.println("1. Cifrado");
            System.out.println("2. Filtrar");
            System.out.println("3. Código enigma");
            System.out.println("4. Salir del sistema");
            System.out.print("Seleccione una opción: ");
            opcion = input.nextInt();

            switch (opcion) {
                case 1 -> { 
                    //Cifrado
                    //Solicitar frase
                    System.out.print("Ingrese frase a cifrar: ");
                    String frase = input.next();
                    
                    //Solicitar desplazamiento
                    System.out.print("Ingrese número positivo para desplazamiento: ");
                    int desplazamiento = input.nextInt();
                    
                    String resultado = "";
                    
                    //Recorrer cada cáracter de la frase
                    for (int contador = 0; contador < frase.length(); contador++) {
                        char caracter = frase.charAt(contador);
                        
                        if (caracter >= 'A' && caracter <= 'Z'){
                            //Cifrado para máyusculas
                            char nuevo = (char) ((caracter - 'A' + desplazamiento) % 26 + 'A'); //Esta linea cifra una letra mayuscula aplicando el desplazamiento y reiniciando si se pasa de la 'a'
                            resultado = resultado + nuevo;
                        } else if (caracter >= 'a' && caracter <= 'z'){
                            //Cifrado para minúsculas
                            char nuevo = (char) ((caracter - 'a' + desplazamiento) % 26 + 'a'); //Esta linea cifra una letra minúscula aplicando el desplazamiento y reiniciando si se pasa de la 'a'
                            resultado  = resultado + nuevo;
                        } else {
                            resultado = resultado + caracter;
                        }
                    }
                    //Mostrar frase cifrada
                    System.out.println("Frase cifrada: " + resultado);
                }  
                case 2 -> { 
                    //Filtrar
                    //Solicitar frase
                    System.out.print("Ingrese frase: ");
                    String frase = input.next();
                    
                    //Solicitar cantidad minima de letras
                    System.out.print("Ingrese cantidad mínima de letras que debe tener la palabra: ");
                    int cantMinima = input.nextInt();
                    
                    frase = frase + " "; //Para hacer que el ciclo evalue hasta la ultima palabra aunque no tenga espacio 
                    String palabra = "";
                    System.out.println("Palabras que cumplen la cantidad minima de " + cantMinima + " letras:");
                    
                    //Recorrer cada cáracter de la frase
                    for (int contador = 0; contador < frase.length(); contador++) {
                        char caracter = frase.charAt(contador);
                        
                        if (caracter != ' '){
                            palabra += caracter;  //acumular caracteres
                        } else {
                            int letras = 0;
                            for (int contar = 0; contar < palabra.length(); contar++) {
                                char letra = palabra.charAt(contar);

                                if ((letra >= 'A' && letra <= 'Z') || (letra >= 'a' && letra <= 'z')){ //Contar solo letras (ignorando simbolos o numeros)
                                    letras++;
                                }
                            }
                            
                            if (letras >= cantMinima){
                                System.out.println(palabra);
                            } 
                            
                            palabra = ""; //Reiniciar variable para siguiente palabra
                        }
                    }  
                }     
                case 4 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción invalida. Intentelo nuevamente.");
                    
            }   

        } while (opcion != 4);
 
    }
    
}
