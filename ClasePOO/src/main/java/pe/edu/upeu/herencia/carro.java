package pe.edu.upeu.herencia;

public class carro extends Vehiculo {

    String modelo = "camioneta";
    String color = "blanco";

    void caracteristicas(){
        System.out.println("las caracteristicas del carro son :");
        System.out.println("modelo"+marca);
        System.out.println("marca"+modelo);
        System.out.println("color"+color);

    }
    public static void main (String []args){
        carro carro = new carro();
        carro.caracteristicas();
        carro.sonido();
    }
}
