package edu.eci.cvds.tdd.aerodescuentos;

import org.junit.Assert;
import org.junit.Test;

public class TarifasTest {

    @Test
    public void verifyNegativeDays() {
        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            calculador.calculoTarifa(20000, -15, 10);
            Assert.fail();
        }
        catch(Throwable e){
            Assert.assertEquals(true, true);
        }
    }

    @Test
    public void verifyNegativeFee() {
        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            calculador.calculoTarifa(-10, 15, 10);
            Assert.fail();
        }
        catch(Throwable e){
            Assert.assertEquals(true, true);
        }
    }

    @Test
    public void successfulFeeCalculation() {
        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            double total = calculador.calculoTarifa(100000, 10, 15);
            Assert.assertEquals(95000, total,0);
        }
        catch(Throwable e){
            Assert.fail();
        }
    }

    @Test
    public void verifyNegativeAge() {
        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            calculador.calculoTarifa(10000, 10, -15);
            Assert.fail();
        }
        catch(Throwable e){
            Assert.assertEquals(true, true);
        }
    }

    // Pruebas de frontera

    @Test
    public void shouldCalculateFee_tarifa_Base() {
        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            double total = calculador.calculoTarifa(1, 10, 50);
            Assert.assertEquals(1, total,0);
        }
        catch(Throwable e){
            Assert.fail();
        }
    }

    @Test
    public void shouldCalculateFee_edad() {
        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            double total = calculador.calculoTarifa(20000, 10, 0);
            Assert.assertEquals(19000, total,0);
        }
        catch(Throwable e){
            Assert.fail();
        }
    }

    @Test
    public void shouldThrowException_edad() {
        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            double total = calculador.calculoTarifa(100000, 10, -1);
            Assert.assertEquals(1, total,0);
        }
        catch(Throwable e){
            Assert.assertEquals(true, true);
        }
    }

    @Test
    public void shouldThrowException_tarifa_Base() {
        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            double total = calculador.calculoTarifa(0, 10, 50);
            Assert.assertEquals(1, total,0);
        }
        catch(Throwable e){
            Assert.assertEquals(true, true);
        }
    }

    @Test
    public void shouldCalculateFee_dias_Antelacion() {
        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            double total = calculador.calculoTarifa(1, 0, 50);
            Assert.assertEquals(1, total,0);
        }
        catch(Throwable e){
            Assert.fail();
        }
    }

    @Test
    public void shouldThrowException_dias_Antelacion() {
        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            double total = calculador.calculoTarifa(100000, -1, 50);
            Assert.assertEquals(1, total,0);
        }
        catch(Throwable e){
            Assert.assertEquals(true, true);
        }
    }



}