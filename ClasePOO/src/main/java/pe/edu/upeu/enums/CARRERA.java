package pe.edu.upeu.enums;

enum FACULTAD{
    FIA,
    FCE,
    FACIHED,
    FCS,
}

public enum CARRERA {
    Sistemas(FACULTAD.FIA),
    Arquitectura(FACULTAD.FIA),
    Civil(FACULTAD.FIA),
    Ambiental(FACULTAD.FIA),

    Administracion(FACULTAD.FCE),
    Contabilidad(FACULTAD.FCS);

    FACULTAD facultad;

    CARRERA(FACULTAD facultad){
        this.facultad= facultad;
    }
}
