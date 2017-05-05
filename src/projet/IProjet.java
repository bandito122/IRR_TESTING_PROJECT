/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

/**
 *
 * @author vincent
 */

/*
*   classe inutilisée créée uniquement pour des tests de mock
*/
public interface IProjet {
    String getName();
    int getPeriode();
    double getTauxActualisation();
    double getCashflow(int periode);
}
