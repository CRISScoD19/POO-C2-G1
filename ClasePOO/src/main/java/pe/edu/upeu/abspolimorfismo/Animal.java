package pe.edu.upeu.abspolimorfismo;

public abstract class Animal {
    protected String tipo= "Mi";
    public abstract void emitirSonido();

    public void dormir(){
        System.out.println("\ndespues de un rato");
        System.out.println("se duerme.........\n");
    }
}
