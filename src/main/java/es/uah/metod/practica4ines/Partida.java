package es.uah.metod.practica4ines;


import java.util.ArrayList;

public class Partida {
    public ArrayList<Celda> listaceldas = new ArrayList<>();
    public ParameterDataModel originalcopy;

    public Partida() {
        this.listaceldas = new ArrayList<>();
        this.originalcopy = new ParameterDataModel(0,0,1,0,0,0,0,0,0,0,0,0,
                                                    0,0,0,0,0,0,0);
    }

    public ArrayList<Celda> getListaceldas() {
        return listaceldas;
    }

    public void setListaceldas(ArrayList<Celda> listaceldas) {
        this.listaceldas = listaceldas;
    }

    public ParameterDataModel getOriginalcopy() {
        return originalcopy;
    }

    public void setOriginalcopy(ParameterDataModel originalcopy) {
        this.originalcopy = originalcopy;
    }
}
