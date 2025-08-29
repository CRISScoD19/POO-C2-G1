package pe.edu.upeu.enums;

enum GENERO{
    femenino,masculino
}
public class Estudiante {
    String codigo;
    String nombre;
    String apellido;
    String carrera;
    GENERO genero;

    public Estudiante(String codigo, String nombre, String apellido, GENERO genero, CARRERA carrera) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.carrera = carrera.name();
    }



    public static void main(String[] args) {
        Estudiante e = new Estudiante("202511810","criss","cctt",GENERO.masculino, CARRERA.Sistemas);
        System.out.println(e.codigo+" "+e.genero+" "+e.carrera);
        System.out.println(e.nombre+" "+e.apellido);

        for (CARRERA c: CARRERA.values()){
            System.out.println(c);
        }
    }
}