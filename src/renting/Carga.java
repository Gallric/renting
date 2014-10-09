package renting;

final public class Carga extends Vehicles {

    private double extra, pma;

    public double getPma() {
        return pma;
    }

    public void setPma(double pma) {
        this.pma = pma;
    }

    public double precioFinal() {
        extra = 20 * pma;
        precioFinal = (this.precioBase * this.diesLloguer) + extra;
        return precioFinal;
    }

    public Carga(String matricula,String tipo, int diesLloguer, int plazas) {
        super(matricula,tipo,diesLloguer);
        this.pma = pma/1000;
    }

}
