package rectangulo;
import java.io.*;

public class IURectangulo {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args)throws java.io.IOException {
        int accion = 0;
        do{
            out.println("Digite 1 para conocer la base");
            out.println("Digite 2 para concer la altura");
            out.println("Digite 3 para modificar la base");
            out.println("Digite 4 para modificar la altura");
            out.println("Digite 5 para calcular el area");
            out.println("Digite 6 para calcular el perimetro");
            out.println("Digite 7 para conocer el estado");
            out.println("Digite 8 para salir");
            accion = Integer.parseInt(in.readLine());
            switch(accion){
                case 1:
                    desplegarBase();
                    break;
                    
                case 2:
                    desplegarAltura();
                    break;
                
                case 3:
                    modificarBase();
                    break;
                    
                case 4:
                    modificarAltura();
                    break;
                    
                case 5:
                    desplegarArea();
                    break;
                    
                case 6:
                    desplegarPerimetro();
                    break;
                    
                case 7:
                    desplegarEstado();
                    break;
                    
                case 8:
                    break;
            }
        }while(accion != 8);
        
        
    }
    
    static void modificarBase()throws java.io.IOException{
        out.print("Digite la nueva base: ");
        int base = Integer.parseInt(in.readLine());
        RutinasRectangulo.modificarBase(base);
    }
    
    static void modificarAltura()throws java.io.IOException{
        out.println("Digite la nueva altura");
        int altura = Integer.parseInt(in.readLine());
        RutinasRectangulo.modificarAltura(altura);
    }
    
    static void desplegarBase()throws java.io.IOException{
        double base = RutinasRectangulo.conocerBase();
        out.println("La base es " + base);
    }
    
    static void desplegarAltura()throws java.io.IOException{
        double altura = RutinasRectangulo.conocerAltura();
        out.println("La altura es " + altura);
    }
    
    static void desplegarArea()throws java.io.IOException{
        double area = RutinasRectangulo.calcularArea();
        out.println("El area es " + area);
    }
    
    static void desplegarPerimetro()throws java.io.IOException{
        double perimetro = RutinasRectangulo.calcularPerimetro();
        out.println("El area es " + perimetro);
    }
    
    static void desplegarEstado()throws java.io.IOException{
        String estado = RutinasRectangulo.conocerEstado();
        out.println(estado);
    }
}

