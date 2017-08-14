package co.edu.udea.ps.p1;

import static org.junit.Assert.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

import org.junit.Test;

public class CalculatorTest {

	@Test
    public void insertarNumeroDouble() {
        //Arrange
        double numero =  Math.random();
        String parametro = Double.toString(numero);
        Calculator calculadorPrueba = new Calculator();
        //Act
        calculadorPrueba.insertarNumero(parametro);
        //Assert
        assertTrue(numero == calculadorPrueba.ultimoNumero());
    }

	@Test
    public void insertarCaracteresDiferentesANumeros(){
        //Arrange
        Calculator calculadorPrueba = new Calculator();
        String parametro = getRandomString();
        boolean result = true;
        //Act
        try {
            calculadorPrueba.insertarNumero(parametro);
        }catch (NumberFormatException e){
            result = false;
        }
        //Assert
        assertTrue(result);
    }

	@Test
	public void calcularMedia(){
        //Arrange
        int cantidadNumeros = 10;
        double sumatoria = 0, numero, media;
        Calculator calculadorPrueba = new Calculator();
        //Act
        for(int i = 0; i < cantidadNumeros; i++){
            numero = Math.random();
            sumatoria = sumatoria + numero;
            calculadorPrueba.insertarNumero(Double.toString(numero));
        }
        media = sumatoria/((double)cantidadNumeros);
        //Assert
        assertTrue(media == calculadorPrueba.getMedia());
    }

	@Test
	public void calcularMediaVacia(){
        //Arrange
        Calculator calculadorPrueba = new Calculator();
        double result;
        //Act
        result = calculadorPrueba.getMedia();
        //Assert
        assertFalse(Double.isNaN(result));
    }

	@Test
	public void calcularDesviacionEstandar(){
        //Arrange
        double desviacionEstandarEsperada, desviacionEstandar = 0, numero, sumatoriaMedia = 0, media = 0, sumatoriaDesviacion = 0;
        Calculator calculadorPrueba = new Calculator();
        String [] numeros = new String[10];
        //Act
        for(int i = 0; i < 10; i++) {
            numero = Math.random();
            sumatoriaMedia = sumatoriaMedia + numero;
            numeros[i] = Double.toString(numero);
            calculadorPrueba.insertarNumero(numeros[i]);
        }
        media = sumatoriaMedia/((double)numeros.length);
        for(int i = 0; i < 10; i++){
            sumatoriaDesviacion = sumatoriaDesviacion + Math.pow((Double.parseDouble(numeros[i]) - media), 2);
        }
        desviacionEstandarEsperada = formatoNumero6Decimales(Math.sqrt(sumatoriaDesviacion/((double)numeros.length-1)));
        desviacionEstandar = calculadorPrueba.getDesviacionEstandar();
        //Assert
        assertTrue(desviacionEstandarEsperada == desviacionEstandar);
    }

	@Test
	public void calcularDesviacionEstandarVacia(){
        //Arrange
        double result;
        Calculator calculadorPrueba = new Calculator();
        //Act
        result = calculadorPrueba.getDesviacionEstandar();
        //Assert
        assertFalse(Double.isNaN(result));
    }

    private String getRandomString(){
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;
    }

    private double formatoNumero6Decimales(double numero){
        DecimalFormat df = new DecimalFormat("#.######");
        df.setRoundingMode(RoundingMode.CEILING);
        return Double.parseDouble(df.format(numero).replace(',','.'));
    }
}
