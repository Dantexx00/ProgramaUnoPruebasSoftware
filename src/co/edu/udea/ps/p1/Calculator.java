package co.edu.udea.ps.p1;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Calculator {

    private LinkedList listaNumeros;

    public Calculator() {
        this.listaNumeros = new LinkedList();
    }

    public void insertarNumero(String cadena){
        double numeroDouble;
        if(esNumero(cadena)){
            numeroDouble = Double.parseDouble(cadena);
            listaNumeros.agregarNumero(numeroDouble);
        }
    }

    public double ultimoNumero(){
        return listaNumeros.ultimoNumero();
    }

    private boolean esNumero(String cadena){
        boolean insercionCorrecta = true;
        try{
            Double.parseDouble(cadena);
        }catch (NumberFormatException e){
            insercionCorrecta = false;
        }
        return insercionCorrecta;
    }

    public double getMedia(){
        double media = 0, sumatoria, cantidadNumeros;
        sumatoria = listaNumeros.getSumatoria();
        cantidadNumeros = listaNumeros.cantidadNumeros();
        if(cantidadNumeros > 0) {
            media = sumatoria / cantidadNumeros;
        }
        return media;
    }

    public double getDesviacionEstandar() {
        double media, sumatoria = 0, cantidadNumeros, desviacionEstandar, numero, aux, result = 0;
        cantidadNumeros = listaNumeros.cantidadNumeros();
        if(cantidadNumeros > 1) {
            media = getMedia();
            Node recorrer = listaNumeros.primero();
            do {
                numero = recorrer.getNumero() - media;
                sumatoria = sumatoria + Math.pow(numero, 2);
                recorrer = recorrer.getSiguiente();
            } while (recorrer != null);
            aux = sumatoria / (cantidadNumeros - 1);
            desviacionEstandar = Math.sqrt(aux);
            result = formatoNumero6Decimales(desviacionEstandar);
        }
        return result;
    }

    private double formatoNumero6Decimales(double numero){
        DecimalFormat df = new DecimalFormat("#.######");
        df.setRoundingMode(RoundingMode.CEILING);
        return Double.parseDouble(df.format(numero).replace(',','.'));
    }
}
