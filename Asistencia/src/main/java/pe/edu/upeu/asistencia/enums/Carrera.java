package pe.edu.upeu.asistencia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor

public enum Carrera {
    SISTEMAS(Facultad.FIA, "Sistemas"),
    CIVIL(Facultad.FIA,"civil"),
    AMBIENTAL(Facultad.FIA,"ambiental"),

    ADMINISTRACION(Facultad.FCE,"administración"),
    CONTABILIDAD(Facultad.FCE,"contabilidad"),

    EFERMERIA(Facultad.FCS,"enfermería"),
    NUTRICION(Facultad.FCS,"nutrición"),

    EDUCACION(Facultad.FACIHED,"educación"),

    GENERAL(Facultad.GENERAL,"general"),
    ;

    private Facultad facultad;
    private String descripcion;

    @Override
    public String toString() {
        return descripcion;
    }
}
