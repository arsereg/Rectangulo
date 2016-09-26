/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangulo;

public class RutinasRectangulo {
    
    private static double base = 2;
    private static double altura = 1;
    
    static double calcularArea(){
        double resultado = base * altura;
        return resultado;
    }
    
    static double calcularPerimetro(){
        double resultado = base * 2 + altura * 2;
        return resultado;
    }
    
    static void modificarBase(double pbase){
        base = pbase;
    }
    
    static void modificarAltura(double paltura){
        altura = paltura;
    }
    
    static double conocerBase(){
        double resultado = base;
        return resultado;
    }
    
    static double conocerAltura(){
        double resultado = altura;
        return resultado;
    }
    
    static String conocerEstado(){
        String baseRectangulo = "La base es " + base + "\n";
        String alturaRectangulo = "La altura es " + altura + "\n";
        String perimetro = "El perimetro es " + calcularPerimetro() + ", ";
        String area = "El area es " + calcularArea();
        String resultado = baseRectangulo + alturaRectangulo + perimetro + area;
        return resultado;
    }
    
}
