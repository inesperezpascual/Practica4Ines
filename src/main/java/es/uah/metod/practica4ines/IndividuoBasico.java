package es.uah.metod.practica4ines;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IndividuoBasico extends Individuo{


    public IndividuoBasico(int id, int generacion, int turnosVida, double probReproduccion,
                           double probClonacion, double probMuerte, int tipo){
        super(id, generacion, turnosVida, probReproduccion, probClonacion, probMuerte, tipo);
    }

    //@Override
    public List<Integer> moveIB(int maxalt, int maxanch) {
        Random random = new Random();
        int direccionalt = random.nextInt(0, maxalt);
        int direccionanc = random.nextInt(0,maxanch);
        List<Integer> direcciones = new ArrayList<>();
        direcciones.add(direccionalt);
        direcciones.add(direccionanc);
        return direcciones;
    }

    @Override
    public String toString() {
        return "IB";
    }

}
