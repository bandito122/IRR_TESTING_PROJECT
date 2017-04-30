/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calcul;

import projet.projet;

/**
 *
 * @author vincent
 */
public class calcul
{

    /**
     * Calcul le coefficient NPV d'un projet
     *
     * @param project projet dont on souhaite avoir le coefficient NPV
     * @return coefficient NPV
     */
    public static double CalculateNPV(projet project)
    {
        double npv = 0;
        double rendement = project.getTauxActualisation();
        int periode = project.getPeriode();

        for (int i = 0; i <= periode; i++)
        {
            npv += project.getCashflow(i) * Math.pow((1 + rendement), -i);
        }

        return npv;
    }

    public static double CalculateIRR(projet project, double rend)
    {
        double diff = 1;
        while (Math.abs(diff) > 0.00001)
        {
            rend = rend - (project.function(rend) / project.derivee(rend));
            diff = project.function(rend);
        }
        return rend;
    }
}
