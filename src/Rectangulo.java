public class Rectangulo {

    private double base = 2;
    private double altura = 1;
    
    public double calcularArea(){
        double resultado = base * altura;
        return resultado;
    }
    
    public double calcularPerimetro(){
        double resultado = base * 2 + altura * 2;
        return resultado;
    }
    
    public void setBase(double pbase){
        base = pbase;
    }
    
    public void setAltura(double paltura){
        altura = paltura;
    }
    
    public double getBase(){
        double resultado = base;
        return resultado;
    }
    
    public double getAltura(){
        double resultado = altura;
        return resultado;
    }
    
    public String toString(){
        String baseRectangulo = "******************\n" + "Base: " + base + "\n" + "******************\n";
        String alturaRectangulo = "Altura: " + altura + "\n" + "******************\n";
        String resul = baseRectangulo + alturaRectangulo;
        return resul;
    }
    
}
