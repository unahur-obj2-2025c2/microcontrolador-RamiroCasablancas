package ar.unahur.edu.obj2.patroncommand.Operaciones;

import ar.unahur.edu.obj2.patroncommand.Microcontrolador.Programable;

public class Swap extends Comando {

    @Override
    public void doExecute(Programable micro) {
        Integer acumA = micro.getAcumuladorA();
        micro.setAcumuladorA(micro.getAcumuladorB());
        micro.setAcumuladorB(acumA);
    }

}
