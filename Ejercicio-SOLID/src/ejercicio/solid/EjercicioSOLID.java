/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio.solid;

/**
 *
 * @author Avril
 */

/* -------------------------------ANTES----------------------------------
public class EjercicioSOLID {

    // Clase Empleado
    class Empleado { 
        private String nombre; 
        private String tipo; 
        private double salario; 
    
        public Empleado(String nombre, String tipo, double salario) { 
            this.nombre = nombre; 
            this.tipo = tipo; 
            this.salario = salario; 
        } 
    
        public double calcularPago() { 
            if (tipo.equals("Gerente")) { 
                return salario + 1000; // Bono para gerentes 
            } else if (tipo.equals("Desarrollador")) { 
                return salario; 
            } else if (tipo.equals("Practicante")) { 
                return salario * 0.5; // Practicantes reciben medio salario 
            } 
            return salario; 
        } 
    
        public void guardarEnBaseDeDatos() { 
            System.out.println("Guardando empleado " + nombre + " en la base de datos..."); 
        } 
    
        public void generarReporte() { 
            System.out.println("Generando reporte para el empleado " + nombre + "..."); 
        } 
    } 

    // Clase SistemaGestionEmpleados
    class SistemaGestionEmpleados { 
        public void procesarEmpleado(Empleado empleado) { 
            double pago = empleado.calcularPago(); 
            System.out.println("Pago calculado: " + pago); 
            empleado.guardarEnBaseDeDatos(); 
            empleado.generarReporte(); 
        } 
    } 

    // Clase principal Main
    public static void main(String[] args) { 
        EjercicioSOLID app = new EjercicioSOLID();
        Empleado gerente = app.new Empleado("Juan", "Gerente", 5000); 
        Empleado desarrollador = app.new Empleado("Ana", "Desarrollador", 3000); 
        Empleado practicante = app.new Empleado("Luis", "Practicante", 1000); 
        SistemaGestionEmpleados sistema = app.new SistemaGestionEmpleados(); 
        sistema.procesarEmpleado(gerente); 
        sistema.procesarEmpleado(desarrollador); 
        sistema.procesarEmpleado(practicante); 
    } 
}

*/

/*
    VIOLACIONES DE LOS PRINCIPIOS SOLID

    1. IDENTIFICAR LAS VIOLACIONES DE LOS PRINCIPIOS SOLID 
        
       a) PRINCIPIO DE RESPONSABILIDAD ÚNICA(SRP) : La clase Empleado tiene más de una responsabilidad(generar reportes, guardar en base de datos, calcular pago), esto viola el SRP, ya que debería solo tener una razón para cambiar.
          -- Solución --
          Separar las responsabilidades en diferentes clases 

       b) PRINCIPIO ABIERTO/CERRADO (OCP): El método calcularPago() usa if--else para cada tipo de empleado y eso viola el OCP porque cuando se quiera agregar un nuevo empleado se va a tener que cambiar la clase Empleado.
           -- Solución --
           Usar polimorfismo y herencia: Debe haber una subclase para cada tipo de empleado
       c) PRINCIPIO DE SUSTITUCIÓN DE LISKOV (LSP): Empleado tiene lógica dentreo de calcularPago() que depende del tipo de empleado, entonces si queremos reemplazar un empleado por otro el comportamiento no es predecible ya que no se puede confiar en que el cálculo de pago siga un comportamiento consistente 
           -- Solución --
           Definir una nueva clase abstracta Empleado y hacer que Gerente, Desarrollador y Practicante la extiendan

        d) Principio de Inversión de Dependencia(DIP): La clase SistemaGestionEmpleados depende de Empleado
            --Solución--
            Hacer que SistemaGestionEmpleados trabaje con la interfaz Empleado en lugar de que dependa de una clase concreta.

*/



//-------------------------------------------NUEVO------------------------------------------------------------

public class EjercicioSOLID {
    abstract class Empleado {
        protected String nombre;
        protected double salario;
        
        public Empleado(String nombre, double salario){
            this.nombre = nombre;
            this.salario = salario;
        }
        
        //MÉTODO ABSTRACTO PARA SER IMPLEMENTADO POR CADA TIPO DE EMPLEADO
        
        public abstract double calcularPago();
        
        public String getNombre(){
            return nombre;
        }
    }
    
    //CLASE GERENTE
    class Gerente extends Empleado {
        
        public Gerente(String nombre, double salario){
            super(nombre,salario);
        }
        
        @Override
        public double calcularPago(){
            return salario + 1000;
        }
    }
    
    //CLASE DESARROLLADOR QUE EXTIENDE EMPLEADO

    class Desarrollador extends Empleado {
        
        public Desarrollador(String nombre, double salario){
            super(nombre,salario);
        }
        
        @Override
        public double calcularPago(){
            return salario;
        }
    }
    
    //CLASE PRACTICANTE QUE EXTIENDE EMPLEADO
    
    class Practicante extends Empleado {
        
        public Practicante(String nombre, double salario){
            super(nombre,salario);
        }
        
        @Override
        public double calcularPago(){
            return salario *0.5;
        }
    }
    
    
    //CLASE PARA GUARDAR EL EMPLEADO EN LA BASE DE DATOS
    class BaseDeDatos{
        public void guardarEmpleado(Empleado empleado){
            System.out.println("Guardando " + empleado.getNombre() + " en la base de datos...");
        }
    }

    //CLASE PARA GENERAR RESPORTES
    class GeneradorReportes{
        public void generarReporte(Empleado empleado){
            System.out.println("Generando reporte para " + empleado.getNombre() + "...");
        }
    }
    
    
    // Clase principal Main
    public static void main(String[] args) {
        EjercicioSOLID app = new EjercicioSOLID();
        
        // Creando instancias de empleados
        Empleado gerente = app.new Gerente("Juan", 5000);
        Empleado desarrollador = app.new Desarrollador("Ana", 3000);
        Empleado practicante = app.new Practicante("Luis", 1000);

        // Creando instancias de las clases de gestión
        BaseDeDatos baseDeDatos = app.new BaseDeDatos();
        GeneradorReportes generadorReportes = app.new GeneradorReportes();
        
        
        // Procesando empleados
        baseDeDatos.guardarEmpleado(gerente);
        baseDeDatos.guardarEmpleado(desarrollador);
        baseDeDatos.guardarEmpleado(practicante);
        
        generadorReportes.generarReporte(gerente);
        generadorReportes.generarReporte(desarrollador);
        generadorReportes.generarReporte(practicante);

        // Mostrando los pagos calculados
        System.out.println("Pago Gerente: " + gerente.calcularPago());
        System.out.println("Pago Desarrollador: " + desarrollador.calcularPago());
        System.out.println("Pago Practicante: " + practicante.calcularPago());
        
    }
}

