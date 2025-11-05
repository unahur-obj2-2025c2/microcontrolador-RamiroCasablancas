package ar.unahur.edu.obj2.patroncommand.Microcontrolador;

import java.util.Arrays;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.Excepciones.FueraDeRangoDeMemoriaException;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Operable;

public class Microcontrolador implements Programable {
    private Integer acumuladorA = 0;
    private Integer acumuladorB = 0;
    private Integer programCounter = 0;
    private List<Integer> memoria = Arrays.asList(new Integer[1024]);
    
    public Microcontrolador() {
        this.reset();
    }

    @Override
    public void run(List<Operable> operaciones) {
        operaciones.forEach(operacion -> operacion.execute(this));
    }

    @Override
    public void incProgramCounter() {
        programCounter += 1;
    }

    @Override
    public Integer getProgramCounter() {
        return programCounter;
    }

    @Override
    public void setAcumuladorA(Integer value) {
        acumuladorA = value;
    }

    @Override
    public Integer getAcumuladorA() {
        return acumuladorA;
    }

    @Override
    public void setAcumuladorB(Integer value) {
        acumuladorB = value;
    }

    @Override
    public Integer getAcumuladorB() {
        return acumuladorB;
    }

    @Override
    public void setAddr(Integer addr) {
        estaDentroDelRangoDeMemoria(addr);
        memoria.set(addr, acumuladorA); //Para guardar en un lugar especifi8co de la lista, lo primerop seria el indice(el lugar) y lo segundo seria el dato a guardar
    }
    
    @Override
    public Integer getAddr(Integer addr) {
        this.estaDentroDelRangoDeMemoria(addr);
        return memoria.get(addr);
    }
    private void  estaDentroDelRangoDeMemoria(Integer direccionDeMemoria){
            if(direccionDeMemoria < 0 || direccionDeMemoria >= memoria.size()){
                throw new FueraDeRangoDeMemoriaException();
            }
    }

    @Override
    public void reset() {
        acumuladorA = 0;
        acumuladorB = 0;
        programCounter = 0;
        memoria = Arrays.asList(new Integer[1024]);
    }

}
