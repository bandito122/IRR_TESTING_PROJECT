/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.Hashtable;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vincent
 */
public class projetTest
{

    public projetTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    /**
     * Test of addCashflow method, of class projet.
     */
    @Test
    public void testAddCashflow()
    {
        System.out.println("addCashflow");
        double flux = 10.0;
        projet instance = new projet("test", -15, 1, 0.1);
        instance.addCashflow(flux);
        // TODO review the generated test code and remove the default call to fail.
        Hashtable result = instance.getCashflow();
        /*for(int i=0;i<result.size();i++)
         System.out.println("cashflows : "+result.get(i));
         */
        /*
         if((double)result.get(0) == -15 && (double)result.get(1)==flux)
         System.out.println("add cashflow OK");
         else
         System.out.println("add cashflow not OK");
         */
        assertEquals(-15, (double) result.get(0), 0);

    }

    /**
     * Test of getTauxActualisation method, of class projet.
     */
    @Test
    public void testGetTauxActualisation()
    {
        System.out.println("getTauxActualisation");
        projet instance = new projet("test", -15, 1, 0.1);
        double result = instance.getTauxActualisation();
        // TODO review the generated test code and remove the default call to fail.
        if (result == 0.1)
        {
            System.out.println("getTauxActualisation OK");
        }
        else
        {
            System.out.println("getTauxActualisation not OK");
        }
        assertEquals(0.1, result, 0);
    }

    /**
     * Test of getPeriode method, of class projet.
     */
    @Test
    public void testGetPeriode()
    {
        System.out.println("getPeriode");
        projet instance = new projet("test", -15, 1, 0.1);
        int result = instance.getPeriode();
        // TODO review the generated test code and remove the default call to fail.
        //System.out.println("periode : " +result);
        /*if(result == 1)
         System.out.println("getPeriode OK");
         else
         System.out.println("getPeriode not OK");
         */
        assertEquals(1, result, 0);
    }

    /**
     * Test of getCashflow method, of class projet.
     */
    @Test
    public void testGetCashflow_0args()
    {
        System.out.println("getCashflow without args");
        projet instance = new projet("test", -15, 1, 0.1);
        double flux = 10.0;
        instance.addCashflow(flux);
        Hashtable result = instance.getCashflow();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        /*
         for(int i=0;i<result.size();i++)
         System.out.println("cashflow "+(i+1)+" : "+result.get(i));
         */
        /*
         if((double)result.get(0) == -15 && (double)result.get(1)==flux)
         System.out.println("getcashflow without args OK");
         else
         System.out.println("getcashflow without args not OK");
         */
        assertEquals(-15, (double) result.get(0), 0);
        assertEquals(flux, (double) result.get(1), 0);
    }

    /**
     * Test of getCashflow method, of class projet.
     */
    @Test
    public void testGetCashflow_int()
    {
        System.out.println("getCashflow with args");
        int periode = 0;
        projet instance = new projet("test", -15, 0, 0.1);
        double result = instance.getCashflow(periode);
        // TODO review the generated test code and remove the default call to fail.
        /*if(result==-15)
         System.out.println("getcashflow with args OK");
         else
         System.out.println("getcashflow with args not OK");
         */
        assertEquals(-15, result, 0);
    }

    /**
     * Test of getName method, of class projet.
     */
    @Test
    public void testGetName()
    {
        System.out.println("getName");
        projet instance = new projet("test", -15, 1, 0.1);
        //String expResult = "";
        String result = instance.getName();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        /*if(result.equals("test"))
         System.out.println("getName OK");
         else
         System.out.println("getName not OK");
         */
        assertEquals("test", result);
    }

    /**
     * Test of function method, of class projet.
     */
    @Test
    public void testFunction()
    {
        System.out.println("function");
        double x = 1;
        projet instance = new projet("test", -15, 1, 0.1);
        double flux = 10.0;
        instance.addCashflow(flux);
        double result = instance.function(x);
        // TODO review the generated test code and remove the default call to fail.
        //System.out.println("resultat de la foncion avec x=1 : "+result);
        /*if(result ==-10)
         System.out.println("function OK");
         else
         System.out.println("function not OK");
         */
        assertEquals(-10, result, 0.0000001);
    }

    /**
     * Test of derivee method, of class projet.
     */
    @Test
    public void testDerivee()
    {
        System.out.println("derivee");
        double x = 1;
        projet instance = new projet("test", -15, 1, 0.1);
        double flux = 10.0;
        instance.addCashflow(flux);
        double result = instance.derivee(x);
        // TODO review the generated test code and remove the default call to fail.
        //System.out.println("resultat de la foncion avec x=1 : "+result);
        assertEquals(-17.5, result, 0.000001);
    }

}
