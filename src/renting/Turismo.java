
package renting;

final public class Turismo extends Vehicles {
    private int plazas;
    private double extra=1.5;
    
    public Turismo (String matricula, String tipo, int diesLloguer, int plazas){
        super(matricula, tipo, diesLloguer);
        this.plazas=plazas;
    }
    
    public double precioFinal(){
        precioFinal=(this.precioBase*this.diesLloguer)*(extra*plazas);
        return precioFinal;
    }
    
    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }
}
