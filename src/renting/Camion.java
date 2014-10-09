package renting;

final public class Camion extends Vehicles {

    public int extra = 40;

    public Camion(String matricula, String tipo, int diesLloguer) {
        super(matricula,tipo, diesLloguer);
    }

    public double precioFinal() {
        precioFinal = (this.precioBase * this.diesLloguer) + extra;
        return precioFinal;
    }
}
