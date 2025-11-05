package ar.unahur.edu.obj2.patroncommand.Operaciones;

import ar.unahur.edu.obj2.patroncommand.Microcontrolador.Programable;

public class Lod extends Comando {
    private final Integer addr; //direccion de memoria
    
    public Lod(Integer addr) {
        this.addr = addr;
    }

    @Override
    protected void doExecute(Programable micro) {
        micro.setAcumuladorA(micro.getAddr(addr));
    }
    
}
