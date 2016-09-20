public class Rectangulo {

    private double base = 2;
    private double altura = 1;
    private double x = 1;
    private double y = 1;
    private String color = "Negro";
    
    public boolean setX(double pposicion){
        boolean resultado;
        if(pposicion >= 0){
            x = pposicion;
            resultado = true;
        }else{
            resultado = false;
        }
        return resultado;
    }
    
    public void setColor(String pcolor){
        color = pcolor;
    }
    
    public String getColor(){
        String resul = color;
        return resul;
    }
    
    public double getX(){
        double resul = x;
        return resul;
    }
    
    public double getY(){
        double resul = y;
        return resul;
    }
    
    public boolean setY(Double pposicion){
        boolean resultado;
        if(pposicion >= 0){
            y = pposicion;
            resultado = true;
        }else{
            resultado = false;
        }
        return resultado;
    }
    
    public boolean desplazarY(double pdesp){
        double actualY = this.getY();
        double newPos = actualY + pdesp;
        boolean resul;
        if(newPos >= 0){
            this.setY(newPos);
            resul = true;
        }else{
            resul = false;
        }
        return resul;
    }
    
    public boolean desplazarX(double pdesp){
        double actualX = this.getX();
        double newPos = actualX + pdesp;
        boolean resul;
        if(newPos >= 0){
            this.setX(newPos);
            resul = true;
        }else{
            resul = false;
        }
        return resul;
    }
    
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
        String baseRectangulo = "******************\n" + "Base: " + this.getBase() + "\n" + "******************\n";
        String alturaRectangulo = "Altura: " + this.getAltura() + "\n" + "******************\n";
        String xRectangulo = "Posicion X: " + this.getX() + "\n" + "******************\n";
        String yRectangulo = "Posicion Y: " + this.getY() + "\n" + "******************\n";
        String colorRectangulo = "Color: " + getColor() + "\n" + "******************\n";
        String resul = baseRectangulo + alturaRectangulo + xRectangulo + yRectangulo + colorRectangulo;
        return resul;
    }
    
    public boolean verificarXValido(double px){
        boolean resul;
        double actualX = getX();
        
        if(px > 0){
            resul = true;
        }else{
            if((actualX + px) > 0){
                resul = true;
            }else{
                resul = false;
            }
        }
        return resul;
    }
    
    public boolean verificarYValido(double px){
        boolean resul;
        double actualY = getY();
        
        if(px > 0){
            resul = true;
        }else{
            if((actualY + px) > 0){
                resul = true;
            }else{
                resul = false;
            }
        }
        return resul;
    }
    
    public boolean moverY(double py){
        boolean resul;
        
        if(py >= 0){
            this.setY(py);
            resul = true;
        }else{
            resul = false;
        }
        return resul;
    }
    
    public boolean moverX(double px){
        boolean resul;
        
        if(px >= 0){
            this.setX(px);
            resul = true;
        }else{
            resul = false;
        }
        return resul;
    }
    
    public boolean mover(double px, double py){
        boolean xValido = x > 0;
        boolean yValido = y > 0;
        boolean coordValida = xValido && yValido;
        boolean resul;
        if(coordValida){
            moverX(px);
            moverY(py);
            resul = true;
        }else{
            resul = false;
        }
        return resul;
    }
    
    public boolean mover(Rectangulo rect){
        double x = rect.getX();
        double y = rect.getY();
        mover(x, y);
        return true;
    }
    
}
