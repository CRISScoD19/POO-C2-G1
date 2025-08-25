package pe.edu.upeu.claseinterface;

public class Perro implements Animal{
    @Override
    public void emitirSonido() {
        System.out.println("guauuuuu ..... guauuuuuuuuuuu");
    }

    @Override
    public void dormir() {
        System.out.println("zzzzzzz.....zzzzz.z..z.z.z.zzzzz");

    }
}
