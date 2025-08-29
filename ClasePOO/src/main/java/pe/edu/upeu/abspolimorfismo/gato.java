package pe.edu.upeu.abspolimorfismo;

public class gato extends Animal{

    private String tipo ="Mascota:\n";

    @Override
    public void emitirSonido() {
        System.out.println("dame pescaoooo!!!!!!.....digo,miauu");
    }

    @Override
    public void dormir (){
        super.dormir();
        System.out.println(super.tipo);
        System.out.println(this.tipo);
        System.out.println("deja oee ... 5 min mas zzzZZZZ");


    }


}
