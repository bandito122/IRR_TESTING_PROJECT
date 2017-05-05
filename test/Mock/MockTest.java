package Mock;


import Calcul.calcul;
import junit.framework.TestCase;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import projet.IProjet;
import projet.projet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vincent
 */
public class MockTest extends TestCase{
    
    //Mockery context = new Mockery();
    Mockery context = new Mockery(){{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};
    
    public void testCalculNPV()
    {
        //set up
        projet project = context.mock(projet.class);
        
        
        //expectation de ce que doit renvoyer le mock
        context.checking(new Expectations(){{
            oneOf(project).getTauxActualisation();
            will(returnValue(0.1));
            oneOf(project).getPeriode();
            will(returnValue(2));
            oneOf(project).getCashflow(0);
            will(returnValue(-2000.0));
            oneOf(project).getCashflow(1);
            will(returnValue(1500.0));
            oneOf(project).getCashflow(2);
            will(returnValue(1500.0));
        }});
        
        //exécution de la méthode à tester
        calcul.CalculateNPV((projet)project);
        
        //vérification
        context.assertIsSatisfied();
    }
    
}
