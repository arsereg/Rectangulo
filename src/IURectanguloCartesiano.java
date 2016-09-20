import java.io.*;

public class IURectanguloCartesiano {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    
    static int cantRectang = 0;
    static int MAX_CANT_RECTANG = 3;
    static int rectanSeleccionado = -1;
    static Rectangulo[] listaRectan = new Rectangulo[MAX_CANT_RECTANG];
    
    public static void main(String[] args)throws java.io.IOException {
        int accion = 0;
        do{
            out.println("Digite 1 para crear un rectángulo");
            out.println("Digite 2 para Seleccionar un rectangulo");
            out.println("Digite 3 para modificar la base");
            out.println("Digite 4 para modificar la altura");
            out.println("Digite 5 para calcular el area");
            out.println("Digite 6 para calcular el perimetro");
            out.println("Digite 7 para conocer la altura");
            out.println("Digite 8 para conocer la base");
            out.println("Digite 9 para conocer la posición en X");
            out.println("Digite 10 para conocer la posicion en Y");
            out.println("Digite 11 para conocer la posición de ambos ejes");
            out.println("Digite 12 para mover el eje X");
            out.println("Digite 13 para mover el eje Y");
            out.println("Digite 14 para mover ambos ejes");
            out.println("Digite 15 para desplazar el eje X");
            out.println("Digite 16 para desplazar el eje y");
            out.println("Digite 17 para desplazar ambos ");
            out.println("Digite 18 para conocer el color");
            out.println("Digite 19 para cambiar el color");
            out.println("Digite 20 para conocer el estado");
            out.println("Digite 21 para salir");
            accion = Integer.parseInt(in.readLine());
            if(accion == 1 || accion == 21){
                if(accion == 21){
                    desplegarSalida();
                }else{
                    if(comprobarEspaciosRect()){
                        crearRectangulo();
                    }else{
                        desplegarErrorMaxRectang();
                    }
                }
            }else{
                
                if(accion == 2){
                    if(verificarRectangCreados()){
                        seleccionarRectang();
                    }else{
                        desplegarErrorCantRect();
                    }
                }else{                
                    if(verificarRectanguloSeleccionado() != -1){
                        switch(accion){
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
                                desplegarAltura();
                                break;
                                
                            case 8:
                                desplegarBase();
                                break;
                            case 9:
                                conocerX();
                                break;
                            case 10:
                                conocerY();
                                break;
                            case 11:
                                conocerPosicion();
                                break;
                            case 12:
                                moverX();
                                break;
                            case 13:
                                moverY();
                                break;
                            case 14:
                                moverAmbosEjes();
                                break;
                            case 15:
                                desplazarX();
                                break;
                            case 16:
                                desplazarY();
                                break;
                            case 17:
                                desplazarAmbos();
                                break;
                            case 18:
                                obtenerColor();
                                break;
                            case 19: 
                                cambiarColor();
                                break;
                            case 20:
                                desplegarEstado();
                                break;
                        }
                    }else{
                        desplegarErrorSeleccion();
                    }
                }
            
            }
        }while(accion != 21);
        
        
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
        mostrarRectangulosCreados(); 
        boolean seleccionRealizada = false;
        int seleccion = -1;
        do{
            seleccion = Integer.parseInt(in.readLine());
            if(seleccion < 0 || seleccion > 3){
                out.println("**************************************");
                out.println("Debe seleccionar un cuadrado existente");
                out.println("**************************************");
            }else{
                rectanSeleccionado = seleccion -1;
                seleccionRealizada = true;
            }
        }while(!seleccionRealizada);
        
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
    
    static String conocerX(){
        double coord = listaRectan[rectanSeleccionado].getX();
        String resul = "*****\nCoordenada X: " + coord + "\n*****";
        out.println(resul);
        return resul;
    }
    
    static String conocerY(){
        double coord = listaRectan[rectanSeleccionado].getY();
        String resul = "*****\nCoordenada Y: " + coord + "\n*****";
        out.println(resul);
        return resul;
    }
    
    static void conocerPosicion(){
        conocerX();
        conocerY();
    }
    
    static void moverY()throws java.io.IOException{
        out.println("Digite la nueva coordenada a la cual desea mover el Rectangulo en el eje Y:");
        double coordY = Double.parseDouble(in.readLine());
        boolean resul = listaRectan[rectanSeleccionado].moverY(coordY);
        String msj;
        if(resul){
            msj = "Cambio realizado";
        }else{
            msj = "Cambio no realizado. Por favor introduzca un numero mayor o igual a 0";
        }
        out.println();
        out.println(msj);
        out.println();
    }
    
    static void moverX()throws java.io.IOException{
        out.println("Digite la nueva coordenada a la cual desea mover el Rectangulo en el eje X:");
        double coordX = Double.parseDouble(in.readLine());
        boolean resul = listaRectan[rectanSeleccionado].moverX(coordX);
        String msj;
        if(resul){
            msj = "Cambio Realizado";
        }else{
            msj = "Cambio no realizado. Por favor introduzca un numero mayor o igual a 0";
        }
        out.println();
        out.println(msj);
        out.println();
    }
    
    static int mensajeMoverConObjeto()throws java.io.IOException{
        out.println();
        out.println("*****");
        out.println("Digite 1 para mover el rectangulo utilizando coordenadas");
        out.println("Digite 2 para mover el rectangulo utilizando otro objeto");
        out.println("*****");
        out.println();
        int seleccion = -1;
        do{
            seleccion = Integer.parseInt(in.readLine());
        }while(seleccion < 0 || seleccion > 2);
        return seleccion;
    }
    
    static double mensajeMoverCoordenadaX()throws java.io.IOException{
        out.println();
        out.println("*****");
        out.println("Digite la coordenada X");
        out.println("*****");
        out.println();
        double coordX = -1;
        do{
            coordX = Double.parseDouble(in.readLine());
            if(coordX < 0){
                out.println("Por favor digite un numero mayor a 0");
            }
        }while(coordX < 0);
        double resul = coordX;
        return resul;
    }
    
    static double mensajeMoverCoordenadaY()throws java.io.IOException{
        out.println();
        out.println("*****");
        out.println("Digite la coordenada Y");
        out.println("*****");
        out.println();
        double coordY = -1;
        do{
            coordY = Double.parseDouble(in.readLine());
            if(coordY < 0){
                out.println("Por favor digite un numero mayor a 0");
            }
        }while(coordY < 0);
        double resul = coordY;
        return resul;
    }

    static void mostrarRectangulosCreados(){
        int i = 1;
        while( i <= cantRectang){
            out.println("");
            out.println("***********");
            out.println("Digite " + i + " para seleccionar el cuadrado " + i);
            out.println("***********");
            out.println("");
            i++;
        }
    }
    
    static void moverAmbosEjes()throws java.io.IOException{
        double cantidadRectangulos = obtenerCantRectangCreados();
        int accion = -1;
        double coordX;
        double coordY;
        if(cantidadRectangulos > 1){
            do{
                accion = mensajeMoverConObjeto();
            }while(accion != 1 && accion != 2 && accion != 0);
            switch(accion){
                case 1:
                    coordX = mensajeMoverCoordenadaX();
                    coordY = mensajeMoverCoordenadaY();
                    listaRectan[rectanSeleccionado].mover(coordX, coordY);
                    break;
                case 2:
                    moverUsandoObjeto();
                    break;
                case 0:
                    out.println("Accion cancelada");
                    break;
            }
        }else{
            coordX = mensajeMoverCoordenadaX();
            coordY = mensajeMoverCoordenadaY();
            listaRectan[rectanSeleccionado].mover(coordX, coordY);
        }
    }
    
    static void moverUsandoObjeto()throws java.io.IOException{
        out.println("");
        out.println("");
        out.println("En este momento tiene seleccionado el rectangulo " + (rectanSeleccionado + 1));
        out.println("Se le mostrarán todos los rectangulos. Por favor seleccione uno para mover el rectangulo seleccionado a esa posicion");
        out.println("");
        mostrarRectangulosCreados();
        int seleccion = -1;
        do{
            seleccion = Integer.parseInt(in.readLine()) -1;
        }while(seleccion < 0 && seleccion > obtenerCantRectangCreados());
        if(seleccion != rectanSeleccionado){
            listaRectan[rectanSeleccionado].mover(listaRectan[seleccion]);
            out.println();
            out.println("*****");
            out.println("Se ha movido el rectangulo " + (rectanSeleccionado + 1) + " a la posicion del rectangulo " + (seleccion + 1));
            out.println("*****");
            out.println();
        }else{
            out.println("No se puede utilizar el mismo rectangulo como referencia. Por favor seleccione uno diferente.");
        }
    }
    
    static boolean desplazarX()throws java.io.IOException{
        out.println();
        out.println("Digite la cantidad que desea desplazar el rectangulo seleccionado en el eje X");
        out.println();
        double coord = Double.parseDouble(in.readLine());
        boolean cambioRealizado = listaRectan[rectanSeleccionado].desplazarX(coord);
        if(cambioRealizado){
            out.println();
            out.println("El rectangulo se desplazo " + coord + " en X");
            out.println();
        }else{
            out.println();
            out.println("El rectangulo no se pudo desplazar. Intentelo de nuevo");
            out.println();
        }
        return cambioRealizado;
    }
    
    static boolean desplazarX(double pX)throws java.io.IOException{
        double coord = pX;
        boolean cambioRealizado = listaRectan[rectanSeleccionado].desplazarX(coord);
        if(cambioRealizado){
            out.println();
            out.println("El rectangulo se desplazo " + coord + " en X");
            out.println();
        }else{
            out.println();
            out.println("El rectangulo no se pudo desplazar. Intentelo de nuevo");
            out.println();
        }
        return cambioRealizado;
    }
    
    static boolean desplazarY()throws java.io.IOException{
        out.println();
        out.println("Digite la cantidad que desea desplazar el rectangulo seleccionado en el eje Y");
        out.println();
        double coord = Double.parseDouble(in.readLine());
        boolean cambioRealizado = listaRectan[rectanSeleccionado].desplazarY(coord);
        if(cambioRealizado){
            out.println();
            out.println("El rectangulo se desplazo " + coord + " en Y");
            out.println();
        }else{
            out.println();
            out.println("El rectangulo no se pudo desplazar. Intentelo de nuevo");
            out.println();
        }
        return cambioRealizado;
    }
    
    static boolean desplazarY(double pY)throws java.io.IOException{
        double coord = pY;
        boolean cambioRealizado = listaRectan[rectanSeleccionado].desplazarY(coord);
        if(cambioRealizado){
            out.println();
            out.println("El rectangulo se desplazo " + coord + " en Y");
            out.println();
        }else{
            out.println();
            out.println("El rectangulo no se pudo desplazar. Intentelo de nuevo");
            out.println();
        }
        return cambioRealizado;
    }
    
    static void desplazarAmbos()throws java.io.IOException{
        out.println("Digite cuanto desea desplazar el eje X del rectangulo " + (rectanSeleccionado + 1));
        boolean xValido = false;
        double despX, despY;
        do{
            despX = Double.parseDouble(in.readLine());
            xValido = listaRectan[rectanSeleccionado].verificarXValido(despX);
            if(!xValido){
                out.println("No puede ingresar un numero tan bajo. Por favor ingrese un número más alto");
            }
        }while(!xValido);
        
        out.println("Digite cuanto desea desplazar el eje Y del rectangulo " + (rectanSeleccionado + 1));
        
        boolean yValido = false;
        do{
            despY = Double.parseDouble(in.readLine());
            yValido = listaRectan[rectanSeleccionado].verificarXValido(despY);
            if(!yValido){
                out.println("No puede ingresar un numero tan bajo. Por favor ingrese un número más alto");
            }
        }while(!yValido);        
        desplazarX(despX);
        desplazarY(despY);
    }
    
    static void obtenerColor(){
        String color = listaRectan[rectanSeleccionado].getColor();
        out.println();
        out.println("El color del rectangulo " + (rectanSeleccionado + 1) + " es: " + color);
        out.println();
    }
    
    static void cambiarColor()throws java.io.IOException{
        out.println("");
        out.println("Escriba el nuevo color del rectangulo:");
        out.println("");
        String color = in.readLine();
        listaRectan[rectanSeleccionado].setColor(color);
        out.println();
        out.println("El color del rectangulo " + (rectanSeleccionado + 1) + " se ha definido en " + color);
        out.println();
    }
    
}

