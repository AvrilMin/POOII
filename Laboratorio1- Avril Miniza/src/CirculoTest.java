/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Avril
 */


//PREGUNTA 3 
public class CirculoTest {
    public static void main(String[] args) {
        // Utilizando el constructor por defecto
        Circulo c1 = new Circulo();
        System.out.println("Circulo 1 (Constructor por defecto):");
        System.out.println("Radio = " + c1.getRadio());
        System.out.println("Area = " + c1.getArea());
        System.out.println();
        
        // Utilizando el constructor sobrecargado con radio = 6.55
        Circulo c2 = new Circulo(6.55);
        System.out.println("Circulo 2 (Constructor sobrecargado con radio 6.55):");
        System.out.println("Radio = " + c2.getRadio());
        System.out.println("Area = " + c2.getArea());
       
        //c1.radio=42.0
        //System.out.println(c1.radio), 
    }
}


