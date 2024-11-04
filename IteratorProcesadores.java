package tpe;

import java.util.Iterator;

public class IteratorProcesadores<Processor> implements Iterator<Processor>{
    private Iterator<Processor> iteradorProcesador;

    public IteratorProcesadores(Iterator<Processor> iteradorProcesador) {
        this.iteradorProcesador = iteradorProcesador;
    }

    @Override
    public Processor next() {
        return iteradorProcesador.next();
    }

    @Override
    public boolean hasNext() {
        return iteradorProcesador.hasNext();
    }
}
