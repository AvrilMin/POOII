/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Avril
 */

//PREGUNTA 1
public class Circulo {
    private double radio;
    private String color;

    // Constructor por defecto 
    public Circulo() {
       this.radio = 12.5;
       this.color = "azul";
    }

    // Constructor con un argumento para establecer el radio
    public Circulo(double radio) {
       this.radio = radio;
       this.color = "azul"; // Mantiene el color predeterminado
    }

    // Método para obtener el radio
    public double getRadio() {
       return radio;
    }

    // Método para calcular el área del círculo
    public double getArea() {
       return radio * radio * Math.PI;
    }

}

