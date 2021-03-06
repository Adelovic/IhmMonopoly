
package model;

import model.carreaux.propriete.ProprieteConstructible;
import model.carreaux.Carreau;
import model.carreaux.propriete.Compagnie;
import model.carreaux.propriete.Gare;
import java.util.ArrayList;
public class Joueur 
{
    private String nomJoueur;
    private int cash = 1500;
    private int[] dernierDes;
    private Carreau positionCourante;
    private ArrayList<Gare> gares = new ArrayList<Gare>();
    private ArrayList<ProprieteConstructible> proprietes = new ArrayList<ProprieteConstructible>();
    private ArrayList<Compagnie> compagnies = new ArrayList<Compagnie>();
    private boolean enPrison;
    
    private int tourPrison;
    
    public Joueur(String nomJoueur)
    {
        this.nomJoueur = nomJoueur;
    }
    
    
    //Getters
    public ArrayList<Gare> getGares(){ return gares; }

    public ArrayList<ProprieteConstructible> getProprietes(){ return proprietes;}

    public ArrayList<Compagnie> getCompagnies() {return compagnies;}
         
    public String getNom() { return nomJoueur; }
    
    public int getNbGares() { return gares.size(); }
    
    public int getNbCompagnies()  { return compagnies.size(); }
    
    public int getNbProprieteAConstruire() { return proprietes.size(); }
    
    public int getCash() { return this.cash; }
    
    public int[] getDernierDes() { return this.dernierDes; }
    
    
    public void payerA(Joueur joueur, int montant)
    {
        int aPrendre = this.getCash() > montant ? montant : this.getCash();
        this.removeCash(montant); // Le cash du joueur peut passer en dessous de 0
        joueur.addCash(aPrendre);     
    }
    public void setPositionCourante(Carreau carreau) 
    {
        this.positionCourante = carreau;
    }
    
    public void setDernierDes(int[] dernierDes) 
    {
        this.dernierDes = dernierDes;
    }
    
    public Carreau getPositionCourante() 
    {
        return this.positionCourante;
    }
    public void modifierCash(int cash)
    {
        cash += cash;
        if (cash < 0) 
        {
            cash = 0;
        }
    }
    
    public void addCash(int cash) 
    {
        this.cash += cash;
    }
    
    public void removeCash(int cash) 
    {
        this.cash -= cash;
    }
    
    public void addGare(Gare g) 
    {
        gares.add(g);
    }
    
    public void addProprieteAConstruire(ProprieteConstructible p) 
    {
        proprietes.add(p);
    }
    
    public void addCompagnie(Compagnie c) 
    {
        compagnies.add(c);
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public boolean isEnPrison() 
    {
        return enPrison;
    }

    public void setEnPrison(boolean enPrison) 
    {
        this.enPrison = enPrison;
    }
    
    public boolean doubleDes()
    {
        return dernierDes[0] == dernierDes[1];
    }

    public int getTourPrison() 
    {
        return tourPrison;
    }

    public void setTourPrison(int tourPrison) 
    {
        this.tourPrison = tourPrison;
    }
    
    public void addTourPrison()
    {
        tourPrison ++;
    }
    
    public int getNbMaisons()
    {
        int nbMaisons = 0;
        for (ProprieteConstructible p : getProprietes()) 
        {
            nbMaisons += p.getNbMaisons();
        }
        return nbMaisons;
    }
    
    public int getNbHotels()
    {
        int nbHotels = 0;
        for (ProprieteConstructible p : getProprietes()) 
        {
            nbHotels += p.getNbHotels();
        }
        return nbHotels;
    }
    

}