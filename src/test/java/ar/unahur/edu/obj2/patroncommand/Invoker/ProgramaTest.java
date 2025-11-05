package ar.unahur.edu.obj2.patroncommand.Invoker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unahur.edu.obj2.patroncommand.Microcontrolador.Microcontrolador;
import ar.unahur.edu.obj2.patroncommand.Microcontrolador.Programable;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Add;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Lod;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Lodv;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Nop;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Str;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Swap;

public class ProgramaTest {
    private Programa p = new Programa();
    private Programable micro = new Microcontrolador();

    @BeforeEach()
    void setUp(){
        p.vaciarLista();
        p.resetearMicro(micro);
    }

    @Test
    void avanzar3PosicionesElProgramCounter(){
        p.agregarOperacion(new Nop()); //Preparacion
        p.agregarOperacion(new Nop()); //Preparacion
        p.agregarOperacion(new Nop()); //Preparacion

        p.ejecutar(micro); //Ejecutar
 
        assertEquals(3, micro.getProgramCounter()); //Asegurar

    }

    @Test
    void sumar20Mas17YObtener37EnAcumuladorA(){
        p.agregarOperacion(new Lodv(20));
        p.agregarOperacion(new Swap());
        p.agregarOperacion(new Lodv(17));
        p.agregarOperacion(new Add());

        p.ejecutar(micro);

        assertEquals(37, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        assertEquals(4, micro.getProgramCounter());
    }

    @Test
    void sumar2Mas8Mas5EnAcumuladorA(){
        p.agregarOperacion(new Lodv(2)); //cargamos 2 en valor A
        p.agregarOperacion(new Str(0)); //Guarda en la posicion 0 el 2
        p.agregarOperacion(new Lodv(8)); //carga 8 en A

        p.agregarOperacion(new Swap()); //Invierte el A y el B, quedan 0 en A y 8 en B
        p.agregarOperacion(new Lodv(5)); //carga 5 en A
        p.agregarOperacion(new Add()); // Suma los valores y queda el resultrado en A y 0 en B

        p.agregarOperacion(new Swap()); //Invierte A y B, que 0 en A y el resultado de la primera en B
        p.agregarOperacion(new Lod(0)); //
        p.agregarOperacion(new Add());

        p.ejecutar(micro);
        assertEquals(15, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());

    }


    
}
