package pe.edu.upeu.claseinterface;

public class ClaseGeneral {


    public static void main(String[] args) {
        Animal animal;
        animal= new Perro();
        animal.emitirSonido();
        animal.dormir();

        animal= new Loro();
        animal.dormir();
        animal.emitirSonido();

    }
}
