package es.uah.metod.practica4ines;

import java.util.List;

public class IndividuoAvanzado extends Individuo{


    public IndividuoAvanzado(int id, int generacion, int turnosVida, double probReproduccion,
                             double probClonacion, double probMuerte, int tipo){
        super(id, generacion, turnosVida, probReproduccion, probClonacion, probMuerte, tipo);
    }

    //@Override
    public void moveIA(int maximo, int minimo) {} //Luego tienes que poner que devuelve List<Integer>

    @Override
    public String toString() {
        return "IA";
    }


}
