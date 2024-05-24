package es.uah.metod.practica4ines;


import java.util.ArrayList;

import static es.uah.metod.practica4ines.MainApplication.log;

public class Partida {
    private int idIndividuos;
    private int idRecursos;
    private int turnoPartida;
    private ArrayList<IndividuoBasico> listaIndivBasicos = new ArrayList<>();
    private ArrayList<IndividuoNormal> listaIndivNormales = new ArrayList<>();
    private ArrayList<IndividuoAvanzado> listaIndivAvanzados = new ArrayList<>();
    private ArrayList<Recurso> listaRecursos = new ArrayList<>();
    private ArrayList<Direccion> listaDireccIndiv = new ArrayList<>();
    private ArrayList<Direccion> listaDireccRecur = new ArrayList<>();
    private ParameterDataModel originalcopy;


    public Partida() {
        this.originalcopy = new ParameterDataModel(0,0,1,0,0,0,0,0,0,0,0,0,
                                                    0,0,0,0,0,0,0);
    }

    public void ordenarEnListas(ArrayList<Celda> listaceldas){
        for (Celda celda : listaceldas) {
            for (Individuo individuo : celda.getIndividuos()){
                if (individuo.getTipo() == 0) {
                    listaIndivBasicos.add((IndividuoBasico) individuo);
                    listaDireccIndiv.add(new Direccion(individuo.getId(), celda.getColumna(), celda.getFila()));
                } else if (individuo.getTipo() == 1) {
                    listaIndivNormales.add((IndividuoNormal) individuo);
                    listaDireccIndiv.add(new Direccion(individuo.getId(), celda.getColumna(), celda.getFila()));
                } else if (individuo.getTipo() == 2) {
                    listaIndivAvanzados.add((IndividuoAvanzado) individuo);
                    listaDireccIndiv.add(new Direccion(individuo.getId(), celda.getColumna(), celda.getFila()));
                }
            }
            for (Recurso recurso : celda.getRecursos()){
                listaRecursos.add(recurso);
                listaDireccRecur.add(new Direccion(recurso.getId(), celda.getColumna(),celda.getFila()));
            }
        }
    }

    public void desordenarEnListas(ArrayList<Celda> listaceldas) {
        for (int i = 0; i < originalcopy.getColumnas(); i++) {
            for (int j = 0; j < originalcopy.getFilas(); j++) {
                Celda celda = new Celda(i, j);
                listaceldas.add(celda);
            }
        }
        for (IndividuoBasico individuoBasico : listaIndivBasicos) {
            for (Direccion direccion : listaDireccIndiv) {
                if (individuoBasico.getId() == direccion.getId()) {
                    Celda celda = getCeldaenDireccion(direccion.getColumnaCelda(),direccion.getFilaCelda(), listaceldas);
                    celda.agregarIndividuo(individuoBasico);
                }
            }
        }
        for (IndividuoNormal individuoNormal : listaIndivNormales) {
            for (Direccion direccion : listaDireccIndiv) {
                if (individuoNormal.getId() == direccion.getId()) {
                    Celda celda = getCeldaenDireccion(direccion.getColumnaCelda(),direccion.getFilaCelda(), listaceldas);
                    celda.agregarIndividuo(individuoNormal);
                }
            }
        }
        for (IndividuoAvanzado individuoAvanzado : listaIndivAvanzados) {
            for (Direccion direccion : listaDireccIndiv) {
                if (individuoAvanzado.getId() == direccion.getId()) {
                    Celda celda = getCeldaenDireccion(direccion.getColumnaCelda(),direccion.getFilaCelda(), listaceldas);
                    celda.agregarIndividuo(individuoAvanzado);
                }
            }
        }

        for (Recurso recurso : listaRecursos) {
            for (Direccion direccion : listaDireccRecur) {
                if (recurso.getId() == direccion.getId()) {
                    Celda celda = getCeldaenDireccion(direccion.getColumnaCelda(),direccion.getFilaCelda(), listaceldas);
                    celda.agregarRecurso(recurso);
                }
            }
        }
    }

    public Celda getCeldaenDireccion(int columna, int fila, ArrayList<Celda> listaceldas) {
        try {
            for (Celda celda : listaceldas) {
                if (celda.getColumna() == columna && celda.getFila() == fila) {
                    return celda;
                }
            }
            return null;
        } catch (NullPointerException e) {
            log.error("Error: Se encontró una referencia nula en la lista de celdas.");
            System.err.println("Error: Se encontró una referencia nula en la lista de celdas.");
            e.printStackTrace();
            return null;

        } catch (Exception e) {
            log.error("Error al buscar celda en dirección.");
            System.err.println("Error al buscar celda en dirección.");
            e.printStackTrace();
            return null;
        }

    }


    public ParameterDataModel getOriginalcopy() {
        return originalcopy;
    }

    public void setOriginalcopy(ParameterDataModel originalcopy) {
        this.originalcopy = originalcopy;
    }

    public int getIdIndividuos() {
        return idIndividuos;
    }

    public void setIdIndividuos(int idIndividuos) {
        this.idIndividuos = idIndividuos;
    }

    public int getIdRecursos() {
        return idRecursos;
    }

    public void setIdRecursos(int idRecursos) {
        this.idRecursos = idRecursos;
    }

    public int getTurnoPartida() {
        return turnoPartida;
    }

    public void setTurnoPartida(int turnoPartida) {
        this.turnoPartida = turnoPartida;
    }

}
