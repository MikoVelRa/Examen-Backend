package examen_base;
public enum Sexo {
    
    H("Hombre"), 
    M("Mujer"),
    NV("Sexo no válido");
    
    private String descripcion;

    private Sexo(String descripcion) {
        this.descripcion = descripcion;
    }

    //Regresamos la descripción del enum de acuerdo al entry.
    public String getDescripcion() {
        return descripcion;
    }
    
}
