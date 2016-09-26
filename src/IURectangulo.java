import java.io.*;

public class IURectangulo {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    
    static int cantRectang = 0;
    static int MAX_CANT_RECTANG = 3;
    static int rectanSeleccionado = -1;
    static Rectangulo[] listaRectan = new Rectangulo[MAX_CANT_RECTANG];
    
    public static void main(String[] args)throws java.io.IOException {
        int accion = 0;
        do{
            out.println("Digite 1 para conocer la base");
            out.println("Digite 2 para conocer la altura");
            out.println("Digite 3 para modificar la base");
            out.println("Digite 4 para modificar la altura");
            out.println("Digite 5 para calcular el area");
            out.println("Digite 6 para calcular el perimetro");
            out.println("Digite 7 para conocer el estado");
            out.println("Digite 8 para Seleccionar un rectangulo");
            out.println("Digite 9 para crear un rectángulo");
            out.println("Digite 10 para salir");
            accion = Integer.parseInt(in.readLine());
            if(accion == 9){
                if(comprobarEspaciosRect()){
                    crearRectangulo();
                }else{
                    desplegarErrorMaxRectang();
                }
                
            }else{
                
                if(accion == 8){
                    if(verificarRectangCreados()){
                        seleccionarRectang();
                    }else{
                        desplegarErrorCantRect();
                    }
                }else{                
                    if(verificarRectanguloSeleccionado() != -1){
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

                            case 10:
                                desplegarSalida();
                                break;
                        }
                    }else{
                        desplegarErrorSeleccion();
                    }
                }
            
            }
        }while(accion != 10);
        
        
    }
    
    public static void modificarBase()throws java.io.IOException{
        out.println("");
        out.println("****************");
        out.println("Digite la nueva base: ");
        out.println("****************");
        out.println("");
        double base = Double.parseDouble(in.readLine());
        modificarBase(base);
    }
    
    public static void modificarAltura()throws java.io.IOException{
        out.println("");
        out.println("****************");
        out.println("Digite la nueva altura");
        out.println("****************");
        out.println("");
        double altura = Double.parseDouble(in.readLine());
        modificarAltura(altura);
    }
    
    public static void desplegarBase(){
        double base = obtenerBase();
        out.println("-------------------");
        out.println("La base es " + base);
        out.println("-------------------");
    }
    
    public static void desplegarAltura(){
        double altura = obtenerAltura();
        out.println("|||||||||||||||||||");
        out.println("La altura es " + altura);
        out.println("|||||||||||||||||||");
    }
    
    public static void desplegarArea(){
        double area = obtenerArea();
        out.println("");
        out.println("*************************");
        out.println("El area es " + area);
        out.println("*************************");
        out.println("");
    }
    
    public static void desplegarPerimetro(){
        double perimetro = obtenerPerimetro();
        out.println("");
        out.println("*************************");
        out.println("El area es " + perimetro);
        out.println("*************************");
        out.println("");
    }
    
    public static void desplegarEstado(){
        String estado = estado();
        out.println(estado);
    }
    
    public static void crearRectangulo(){
        ingresarRectangulo();
        out.println("");
        out.println("*****");
        out.println("Rectangulo " + obtenerCantRectangCreados() + " creado");
        out.println("*****");
        out.println("");
    }
    
    public static void desplegarSalida(){
        out.println("Hasta pronto");
    }
    
    public static int verificarRectanguloSeleccionado(){
        int indice = obtenerIndice();
        return indice;
    }
    
    public static void desplegarErrorSeleccion(){
        out.println("");
        out.println("*************************");
        out.println("//////////////////////");
        out.println("ERROR: No ha seleccionado ningun rectangulo.");
        out.println("Por favor seleccione un rectangulo.");
        out.println("//////////////////////");
        out.println("*************************");
        out.println("");
    }
    
    public static void desplegarErrorMaxRectang(){
        out.println("");
        out.println("*********");
        out.println("////////////////");
        out.println("ERROR: Ha llegado al tope de rectangulos permitidos");
        out.println("////////////////");
        out.println("*********");
        out.println("");
    }
    
    public static boolean comprobarEspaciosRect(){
        boolean resul;
        int cantRectang = obtenerCantRectangCreados();
        int maxRectang = obtenerMaxCantRectang();
        if(cantRectang < maxRectang){
            resul = true;
        }else{
            resul = false;
        }
        return resul;    
    }
    
    public static void seleccionarRectang()throws java.io.IOException{
        int i = 1;
        int cantRectang = obtenerCantRectangCreados();
        while( i <= cantRectang){
            out.println("");
            out.println("***********");
            out.println("Digite " + i + " para seleccionar el cuadrado " + i);
            out.println("***********");
            out.println("");
            i++;
        }
        
        int seleccion;
        do{
            seleccion = Integer.parseInt(in.readLine());
            if(seleccion < 0 || seleccion > i){
                out.println("**************************************");
                out.println("Debe seleccionar un cuadrado existente");
                out.println("**************************************");
            }else{
                seleccionarRectang(seleccion - 1);
            }
        }while(seleccion < i && seleccion > cantRectang);
        
        out.println("");
        out.println("**********************");
        out.println("Rectangulo " + seleccion + " seleccionado");
        out.println("**********************");
        out.println("");
            
    }
    
    public static boolean verificarRectangCreados(){
        boolean resul;
        int cantRectang = obtenerCantRectangCreados();
        if(cantRectang > 0){
            resul = true;
        }else{
            resul = false;
        }
        return resul;
    }
    
    public static void desplegarErrorCantRect(){
        out.println("");
        out.println("*********");
        out.println("////////////////");
        out.println("ERROR: Debe crear al menos un cuadrado para poder seleccionar");
        out.println("////////////////");
        out.println("*********");
        out.println("");
    }
    
    static void ingresarRectangulo(){
        listaRectan[cantRectang] = new Rectangulo();
        cantRectang++;
    }
    
    static void modificarBase(double pbase){
        listaRectan[rectanSeleccionado].setBase(pbase);
    }
    
    static void modificarAltura(double paltura){
        listaRectan[rectanSeleccionado].setAltura(paltura);
    }
    
    static double obtenerBase(){
        double resul = listaRectan[rectanSeleccionado].getBase();
        return resul;
    }
    
    static double obtenerAltura(){
        double resul = listaRectan[rectanSeleccionado].getAltura();
        return resul;
    }
    
    static double obtenerArea(){
        double resul = listaRectan[rectanSeleccionado].calcularArea();
        return resul;
    }
    
    static double obtenerPerimetro(){
        double resul = listaRectan[rectanSeleccionado].calcularPerimetro();
        return resul;
    }
    
    static String estado(){
        String resul = listaRectan[rectanSeleccionado].toString();
        return resul;
    }
    
    static int obtenerCantRectangCreados(){
        int resul = cantRectang;
        return resul;
    }
    
    static int obtenerMaxCantRectang(){
        int resul = MAX_CANT_RECTANG;
        return resul;
    }
    
    static int obtenerIndice(){
        int resul = rectanSeleccionado;
        return resul;
    }
    
    static void seleccionarRectang(int pseleccion){
        rectanSeleccionado = pseleccion;
    }
}

