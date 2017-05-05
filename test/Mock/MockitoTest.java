/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mock;
import Calcul.calcul;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.*;
import projet.projet;
/**
 *
 * @author vincent
 */
public class MockitoTest {
    
    @Test
   public void testCalculNPV()
   {
       projet project = mock(projet.class);
       when(project.getTauxActualisation()).thenReturn(0.1);
       when(project.getPeriode()).thenReturn(2);
       when(project.getCashflow(0)).thenReturn(-2000.0);
       when(project.getCashflow(1)).thenReturn(1500.0);
       when(project.getCashflow(2)).thenReturn(1500.0);
       
       //603.305785
       double res = calcul.CalculateNPV(project);
       assertEquals(603.305785, res, 0.000001);
    }
}
