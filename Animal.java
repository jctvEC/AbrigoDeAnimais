
package abrigodeanimais;


public class Animal {
    
    private int  contador;
    private final String tipo;
    
    
    public Animal(int contador, String tipo) {
        this.contador = contador;
        this.tipo = tipo;
    }

    public int getContador() {
        return this.contador;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
   

}
