package es.uah.metod.practica4ines;

public class IndividuoNormal extends Individuo{

    public IndividuoNormal(int id, int generacion, int turnosVida, double probReproduccion,
                           double probClonacion, double probMuerte, int tipo){
        super(id, generacion, turnosVida, probReproduccion, probClonacion, probMuerte, tipo);
    }

    //@Override
    public void moveIN() {}

    @Override
    public String toString() {
        return "IN";
    }


}
