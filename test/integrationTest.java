/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Calcul.calcul;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projet.projet;

/**
 *
 * @author vincent
 */
public class integrationTest
{

    public integrationTest()
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello()
    {
        projet proj2 = new projet("projet 2", -7500, 4, 0.1);
        proj2.addCashflow(3000);
        proj2.addCashflow(5000);
        proj2.addCashflow(1200);
        proj2.addCashflow(4000);

        double npv2 = calcul.CalculateNPV(proj2);
        double irr = calcul.CalculateIRR(proj2, 0.1);
        System.out.println("npv de " + proj2.getName() + " : " + npv2);
        System.out.println("IRR de " + proj2.getName() + " : " + irr);
    }
}
