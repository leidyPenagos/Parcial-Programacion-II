
/*
 * Clase de Pruebas para instancias de CardPhone
 */
package Test;

import Model.CardPhone;
import Model.CardPhoneInternational;
import Model.CardPhoneNational;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JairoArmando
 */
public class CardPhoneTest {
    
    private CardPhone national;
    private CardPhone international;
    
    /**
     * Escenario uno para tarjetas Nacionales
     */
    private void setupEscenarieOne( ){
        national = new CardPhoneNational("CN110", 1500 );
    }
    
    /**
     * Escenario dos para tarjetas Interacionales
     */
    private void setupEscenarieTwo( ){
        international = new CardPhoneInternational("CI210", 2000, 30.0 );
    }
    
    /**
     * Caso de prueba para el método de residuo o saldo inicial de las tarjetas
     */
    @Test
    public void testFindCardResidue( ){
        //Pruebas tarjeta Nacional
        setupEscenarieOne( );
        assertEquals(1500, national.getResidue( ), 0.01 );
        
        //Pruebas tarjeta Internacional
        setupEscenarieTwo( );
        assertEquals(2000, international.getResidue( ), 0.01 );
    }
    
    /**
     * Caso de prueba para el método de minutos consumidos iniciales
     */
    @Test
    public void testValidateMinutes( ){
        //Pruebas tarjeta Nacional
        setupEscenarieOne( );
        assertEquals(0, national.getTotalMinutes( ) );
        
        //Pruebas tarjeta Internacional
        setupEscenarieTwo( );
        assertEquals(0, international.getTotalMinutes( ) );
    }
    
    /**
     * Caso de Prueba para recargas
     */
    @Test
    public void testRecharging( ){
        //Pruebas tarjeta Nacional
        setupEscenarieOne( );
        national.rechargingCard( 1500 );
        assertEquals(3000, national.getResidue(), 0.01 );
        
        //Pruebas tarjeta Internacional
        setupEscenarieTwo( );
        international.rechargingCard( 3200 );
        assertEquals( 5200, international.getResidue(), 0.01 );
    }
    
    /**
     * Caso de prueba para la realizació de llamadas
     */
    @Test
    public void testCalling(){
        //Pruebas tarjeta Nacional
        setupEscenarieOne( );
        assertTrue( national.callingPhone( ( byte )10 ) );
        assertEquals(1150, national.getResidue(), 0.01 );
        assertEquals( 10, national.getTotalMinutes( ) );
        
        assertFalse( national.callingPhone( ( byte )100 ) );
        assertEquals(1150, national.getResidue(), 0.01 );
        assertEquals( 10, national.getTotalMinutes( ) );
        
        //Pruebas tarjeta Internacional
        setupEscenarieTwo( );
        assertFalse( international.callingPhone( (byte) 40 ) );
        assertTrue( international.callingPhone( (byte) 3 ) );
        assertEquals( 3, international.getTotalMinutes( ) );
        assertEquals( 1820, international.getResidue(), 0.01 );
        
        assertTrue( international.callingPhone( (byte) 10 ) );
        assertEquals( 13, international.getTotalMinutes( ) );
        assertEquals( 1400, international.getResidue(), 0.01 );
        
    }
    
}
