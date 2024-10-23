/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jacopo xu
 */
class Giocatore extends Thread {
    // attributi
    private String nomeGiocatore;
    private int idGiocatore;
    private int numero;
    private Estrazione estrazione;
    
    // Metodo costruttore
    public Giocatore(int idGiocatore, String nomeGiocatore, Estrazione estrazione) {
        this.idGiocatore = idGiocatore;
        this.nomeGiocatore = nomeGiocatore;
        this.estrazione = estrazione;
        Random random = new Random();
        this.numero = random.nextInt(25)+1;
    }

    // Metodo per eseguire il thread
    @Override
    public void run() {
        System.out.println("Inizio Giocatore" + this.idGiocatore + ", " + this.nomeGiocatore);
        // conto alla rovescia per simulare i tempi per la verifica
        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Giocatore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // verifica del risultato
        estrazione.verifica(numero, idGiocatore, nomeGiocatore);
        
        // stampa fine verifica
        System.out.println(nomeGiocatore + " ha verificato il suo numero");
        System.out.println("Fine Giocatore" + this.idGiocatore + ", " + this.nomeGiocatore + "\n");
    }
}
