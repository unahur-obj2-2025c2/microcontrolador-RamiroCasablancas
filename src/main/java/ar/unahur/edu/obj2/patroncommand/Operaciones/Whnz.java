package ar.unahur.edu.obj2.patroncommand.Operaciones;

import java.util.List;

import ar.unahur.edu.obj2.patroncommand.Microcontrolador.Programable;

public class Whnz extends Composite {

    public Whnz(List<Operable> operaciones) {
        super(operaciones);
    }

    @Override
    protected void doExecute(Programable micro) {
        while(this.noEsCero(micro)){
            super.doExecute(micro);
        }
        
    }

}
