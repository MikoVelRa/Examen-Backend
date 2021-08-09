package examen_base;

public class Persona {

    //Declaración e inicialización de atributos por defecto.
    private String nombre = "";
    private int edad = 0;
    private String NSS;
    private Sexo sexo = Sexo.H;
    private double peso = 0.0;
    private double altura = 0.0;
    private double IMC = 0.0; //Atributo añadido

    //Definición del constructor
    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        
        //Asginación de valor a sexo si el valor de este es válido
        if(comprobarSexo(sexo)){
            this.sexo = Sexo.valueOf(String.valueOf(sexo));
        } else{
            this.sexo = Sexo.valueOf("NV");
        }
        this.peso = peso;
        this.altura = altura;

        //El NSS se genera con base a un método en especial
        this.NSS = generarNSS();
    }      

    //Cálculo del Indice de Masa Corporal (IMC)
    public int calcularIMC() {
        IMC = peso / Math.pow(altura, 2);
        
        if(sexo.getDescripcion() == "Hombre"){
            if(IMC < 20){
                return -1;
            } else if(IMC >=20 && IMC <=25){
                return 0;
            } else{
                return 1;
            }
        } else {
            if(IMC < 19){
                return -1;
            } else if(IMC >=19 && IMC <=24){
                return 0;
            } else{
                return 1;
            }
        }
    }
    
    //Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
//        if(comprobarSexo(sexo)){
//            this.sexo = Sexo.valueOf(String.valueOf(sexo));
//        } else{
//            this.sexo = Sexo.valueOf("NV");
//        }
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    //Método para determinar si es mayor de edad
    public boolean esMayorDeEdad(){
        return edad >= 18;
    }
    
    //Comprobamos si el sexo introducido es correcto (NO asignación)
    private boolean comprobarSexo(char sexo){
        if(sexo == 'H' || sexo == 'M'){
            return true;
        }
        return false;
    }           
    
    //Generamos el NSS de 8 dígitos
    private String generarNSS() {        
        String cadena = "";
        for(int i = 1; i <= 8; i++){
              if(i % 2 == 1){
                  cadena += generarLetrasRandom();
              } else{
                  cadena += generarNumerosRandom();
              }
        }
        return cadena;
    }
    
    //Generamos números aleatorios del 0-9
    private char generarNumerosRandom() {
        return (char) Math.floor(Math.random() * (57 - 48+1) + 48);
    }
    
    //Generamos letras aleatorias de la A-Z
    private char generarLetrasRandom() {
        return (char) Math.floor(Math.random() * (90 - 65+1) + 65);
    }

    @Override
    public String toString() {
        return  "nombre: " + nombre + 
                "\n edad: " + edad + " años" + 
                "\n NSS: " + NSS + 
                "\n sexo: " + sexo.getDescripcion() + 
                "\n peso: " + peso + " kg." +
                "\n altura: " + altura + " m." + 
                "\n IMC: "+ IMC + " kg.";
    }

}
