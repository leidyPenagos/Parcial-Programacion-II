/*
 *Clase de Pruebas Unitarias para la clase de Gestion
 */
package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Model.CallNotMinutes;
import Model.CardNotExisting;
import Model.CardPhone;
import Model.ManagementCardPhone;

/**
 *
 * @author JairoArmando
 */
public class ManagementCardPhoneTest {
    
    private ManagementCardPhone mngCard;
    
    /**
     * Escenario para instnaciar el objeto y agregar tarjetas SIM
     */
    private void setupEscenarie(){
        mngCard = new ManagementCardPhone( );
        mngCard.addCard( "NC100", 2000 );
        mngCard.addCard( "NC200", 1500 );
        mngCard.addCard( "IN100", 3000, 10.0 );
        mngCard.addCard( "IN200", 4000, 20.0 );
        mngCard.addCard( "IN300", 5000, 30.0 );
        mngCard.addCard( "NC200", 480 );
        mngCard.addCard( "IN100", 4000, 10.0 );
    }
    
    /**
     * Caso de Prueba para verificar el tamaño del arreglo de SIMS CARD
     */
    @Test
    public void testSize(){
        setupEscenarie( );
        assertEquals( 5, mngCard.getCardPhones().size( ) );
        mngCard.addCard( "NC2001", 480 );
        mngCard.addCard( "IN1001", 4000, 10.0 );
        assertEquals( 7, mngCard.getCardPhones().size( ) );
    }
    
    /**
     * Caso de Prueba para agregar SIMS CARD
     */
    @Test
    public void testAddCard(){
        setupEscenarie( );
        assertFalse(mngCard.addCard( "NC100", 89 ));
        assertFalse( mngCard.addCard( "IN300", 50, 30.0 ) );
        assertTrue(mngCard.addCard( "NC1030", 89 ));
        assertTrue( mngCard.addCard( "IN3300", 50, 30.0 ) );
    }
    
    /**
     * Caso de Prueba para recargas a través de la clase de gestión
     */
    @Test
    public void testRecharging( ){
        setupEscenarie( );
        assertTrue( mngCard.rechargingCard( "NC100", 1000 ) );
      //  assertEquals( 3000, mngCard.findCard( "NC100").getResidue( ), 0.01 );
        assertFalse( mngCard.rechargingCard( "NB786", 110) );
        
        assertTrue( mngCard.rechargingCard( "IN300", 1000 ) );
        assertEquals( 6000, mngCard.findCard( "IN300").getResidue( ), 0.01 );
    }
    
    /**
     * Caso de Prueba para llamadas a través de la clase de gestión
     */
    @Test
    public void testCalling(){
        setupEscenarie( );
        try{
            mngCard.callingPhone( "NC100", (byte) 5 );
            assertEquals( 5, mngCard.findCard("NC100").getTotalMinutes() );
            assertEquals( 1825, mngCard.findCard("NC100").getResidue(), 0.01 );
            mngCard.callingPhone( "NC100", (byte) 500 );
            mngCard.callingPhone( "NNXXX", (byte) 500 );
            
            mngCard.callingPhone( "IN100", (byte) 10 );
            assertEquals( 10, mngCard.findCard("IN100").getTotalMinutes() );
            assertEquals( 2460, mngCard.findCard("IN100").getResidue(), 0.01 );
        }
        catch( CardNotExisting | CallNotMinutes e ){
            
        }
        
    }
    
    /**
     * Caso de Prueba para verificar los saldos de las SIM CARD
     */
    @Test
    public void testTotally(){
        setupEscenarie( );
        assertEquals( 15500, mngCard.totallingCardPhones(), 0.01 );
    }
}
