package ar.unahur.edu.obj2.patroncommand.Invoker;

import java.util.ArrayList;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.Microcontrolador.Programable;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Operable;

public class Programa {
    List<Operable> operaciones;

    public Programa() {
        this.operaciones = new ArrayList<>();
    }
    public void agregarOperacion(Operable operacion){
        operaciones.add(operacion);
    }
    public void agregarOperaciones(List<Operable> operaciones){
        operaciones.addAll(operaciones);
    }
    public void vaciarLista(){
        operaciones.clear();
    }
    public void ejecutar(Programable micro){
        micro.run(operaciones);
    }

    public void resetearMicro(Programable micro){
        micro.reset();
    }
    
}
