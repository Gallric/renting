package renting;

public abstract class Vehicles {

    protected String matricula, tipo;
    protected int diesLloguer, precioBase = 50;
    protected double precioFinal;

    public Vehicles(String matricula, String tipo, int diesLloguer) {
        this.matricula = matricula;
        this.tipo = tipo;
        this.diesLloguer = diesLloguer;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getDiesLloguer() {
        return diesLloguer;
    }

    public void setDiesLloguer(int diesLloguer) {
        this.diesLloguer = diesLloguer;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public abstract double precioFinal();
}
