/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ejemplohilos;

/**
 *
 * @author AEM by Alejandro Esteban Martinez de la Casa
 * @version 1.0
 * Created on 3 oct 2024
 *
 */
public class CuentaBancaria {
    private class Deposito{
        protected double cantidad;
        protected String moneda="Euro";        
    }
    
    Deposito elDeposito;
    
    public CuentaBancaria(double cantidad, String moneda){
        Deposito deposito = elDeposito;
        this.elDeposito.cantidad=cantidad;
        this.elDeposito.moneda=moneda;
    }
}
