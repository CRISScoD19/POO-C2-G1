package pe.edu.upeu.claseinterface;

public class Loro implements Animal{
    @Override
    public void emitirSonido() {
        System.out.println("Holaaaa...... gru ... Holaaaa");
    }

    @Override
    public void dormir() {
        System.out.println("zzzzzz.....zzzzz..zzzzz.z..z..z");
    }
}
