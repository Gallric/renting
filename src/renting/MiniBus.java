package renting;

final public class MiniBus extends Vehicles {

    private int plazas, extra = 2;

    public MiniBus(String matricula,String tipo, int diesLloguer, int plazas) {
        super(matricula, tipo, diesLloguer);
        this.plazas = plazas;
    }

    public double precioFinal() {
        precioFinal = (this.precioBase * this.diesLloguer) + (extra * plazas);
        return precioFinal;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public int getExtra() {
        return extra;
    }

    public void setExtra(int extra) {
        this.extra = extra;
    }

}
