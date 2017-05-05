/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import Calcul.calcul;
import java.util.Hashtable;

/**
 *
 * @author vincent
 */
public class projet {
    
    /**
     * variable qui stocke le nom du projet
     */
    private String nom;
    /**
     * variable qui contient les flux net pour chaque années du projet
     * la première entrée est l'investissement initial (année 0)
     */
    private Hashtable<Integer,Double> cashflow;
    /**
     * le nombre d'années du projet
     */
    private int periode;
    /**
     * le rendement par année, aussi appelé le taux d'actualisation
     */
    private double rendement;
    /**
     * variable permettant de stocker le npv
     */
    private double npv;
    
    /**
     * variable permettant de stocker le irr
     */
    private double irr;
    
    public projet()
    {
        
    }
    /**
     * Constructeur d'initialisation
     * @param n nom du projet
     * @param flux une hashtable contenant les flux
     * @param p période du projet
     * @param rend taux d'actualisation considéré par année
     */
    public projet(String n,Hashtable<Integer,Double> flux,int p,double rend)
    {
        nom = n;
        cashflow = flux;
        periode = p;
        rendement = rend;
    }
    /**
     * constructeur d'initialisation
     * @param n nom du projet
     * @param invest investissement de base du projet (année 0)
     * @param p période du projet
     * @param rend taux d'actualisation considéré (par année)
     */
    public projet(String n,double invest,int p,double rend)
    {
        nom = n;
        cashflow = new Hashtable<Integer,Double>();
        cashflow.put(0, invest);
        periode = p;
        rendement = rend;
    }
    
    /**
     * ajout d'un flux pour l'année suivante
     * @param flux flux à ajouter
     */
    public void addCashflow(double flux)
    {
        int p = cashflow.size();
        cashflow.put(p, flux);
    }
    
    /**
     * Permet d'obtenir le taux d'actualisation du projet
     * @return le taux d'actualisation
     */
    public double getTauxActualisation()
    {
        return rendement;
    }
    
    /**
     * Periode de récupérer la durée du projet
     * @return la durée du projet
     */
    public int getPeriode()
    {
        return periode;
    }
    
    /**
     * Retourne l'ensemble des flux financier net
     * @return les flux financier sous forme de hashtable
     */
    public Hashtable<Integer,Double> getCashflow()
    {
        return cashflow;
    }
    
    /**
     * Permet d'obtenir un flux financier net pour une période (année) spécifique
     * @param periode la période à laquelle on veut obtenir le flux financier
     * @return la valeur du flux financier
     */
    public double getCashflow(int periode)
    {
        return cashflow.get(periode);
    }
    
    /**
     * Permet de récuprér le nom du projet
     * @return le nom du projet sous forme de String
     */
    public String getName()
    {
        return nom;
    }
    
    /**
     * Permet de récupérer le NPV du projet
     * @return le npv sous forme de double
     */
    public double getNPV()
    {
        return npv;
    }
    
    /**
     * Permet de founir le NPV du projet avec les données actuelles de ce dernier
     */
    public void CalculateNPV()
    {
        this.npv = calcul.CalculateNPV(this);
    }
    
    /**
     * Permet de fournir l'IRR du projet avec les données actuelles de ce dernier
     * @param taux taux d'actualisation estimé
     */
    public void CalculateIRR(double taux)
    {
        this.irr = calcul.CalculateIRR(this, taux);
    }
    /**
     * Permet de récupérer le IRR
     * @return le irr sous forme de double
     */
    public double getIRR()
    {
        return irr;
    }
    
    /**
     * Fonction représentée par l'ensemble des flux dont on veut calculer le résultats pour une valeur spécifique
     * @param x valeur pour laquelle on souhaite calculer la fonction
     * @return renvoi la fonction évaluée pour la valeur donnée
     */
    public double function(double x)
    {
        double res = cashflow.get(0);
        
        for(int i=1;i<cashflow.size();i++)
        {
            res += cashflow.get(i)*Math.pow((1+x), -i);
        }
        return res;
    }
    
    /**
     * Dérivée de la fonction représentée par l'ensemble des flux financier dont on veut calculer le résultat pour une valeur spécifique
     * @param x valeur pour laquelle on souhaite calculer la dérivée de la fonction
     * @return renvoi la fonction évaluée pour la valeur donnée
     */
    public double derivee(double x)
    {
        double res = cashflow.get(0);
        
        for(int i=1;i<cashflow.size();i++)
        {
            res += (cashflow.get(i)*(-i))*Math.pow((1+x), (-1-i));
        }
        return res;
    }
    
    
    /**
     * Méthode pour renvoyer une représentation de l'objet sous forme de string
     * @return représentation sous forme de chaine de caractère
     */
    @Override
    public String toString()
    {
        return "nom :" + nom + " | période : "+periode+" | taux d'actualisation : "+rendement;
    }

}
