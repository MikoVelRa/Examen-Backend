package examen_base;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Examen_Base {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            //Solicitamos datos al usuario//        
            System.out.println(">> CÁLCULO DE IMC <<");

            System.out.print("Introduzca su nombre: ");
            String nombre = input.nextLine();

            System.out.print("Introduzca su edad: ");
            int edad = input.nextInt();

            if (edad < 0) {
                throw new Exception("El valor introducido no puede ser menor a cero");
            }

            System.out.print("Introduzca su sexo (H / Hombre - M / Mujer): ");
            char sexo = input.next().charAt(0);

            System.out.print("Introduzca su peso: ");
            double peso = input.nextDouble();
            

            if (peso < 3.00) {
                throw new Exception("El valor introducido para el peso es muy bajo, inserte un valor válido.");
            }

            System.out.print("Introduzca su altura: ");
            double altura = input.nextDouble();

            if (altura < 1.00) {
                throw new Exception("La estatura es muy baja, inserte un valor válido.");
            }

            System.out.println();
            
            //Instancia del objeto
            Persona person = new Persona(nombre, edad, Character.toUpperCase(sexo), peso, altura);            

            //Cálculo de IMC
            int imc = person.calcularIMC();

            System.out.println(">>> INFORMACIÓN DE LA PERSONA <<<");
            
            //Mostramos toda la información de la persona.
            System.out.println(person);
            
            System.out.println("Observaciones:");
            
            //Mostramos si es mayor de edad
            if (person.esMayorDeEdad()) {
                System.out.println("*Usted es mayor de edad");
            } else {
                System.out.println("*Usted es menor de edad");
            }

            //Mostramos el status de su IMC al usuario
            if (imc < 0) {
                System.out.println("*Usted se encuentra por debajo de su peso, vaya y consulte a un nutriólogo");
            } else if (imc == 0) {
                System.out.println("*Usted se encuentra en su peso ideal, manténgase en ese estado.");
            } else {
                System.out.println("*Usted se encuentra por encima de su peso, vaya y consulte a un nutriólogo");
            }
        } catch (InputMismatchException e) {
            System.err.println("Introduzca los datos correctamente, intente de nuevo");
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
