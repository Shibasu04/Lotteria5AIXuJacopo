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
class Estrazione extends Thread {
    // attributi
    private int[][] matriceNumeri;
    private int n;
    private int[] vincitori;
    private int numeroVincitori;
    
    // Metodo costruttore
    public Estrazione(int n) {
        this.matriceNumeri = new int[n][n];
        this.n = n;
        this.vincitori = new int[3];
        this.numeroVincitori = 0;
    }

    // Metodo per visualizzare la matrice dei numeri estratti
    public void stampaMatrice() {
        System.out.println("Matrice estratta:");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matriceNumeri[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Metodo per visualizzare i vincitori dell'estrazione
    public void stampaVincitori() {
        System.out.println("Vincitori:");
        if (numeroVincitori == 0) {
            System.out.println("Nessun vincitore.");
        } else {
            for (int i = 0; i < numeroVincitori; i++) {
                System.out.println("Giocatore " + vincitori[i] + " ha vinto!");
            }
        }
    }

    // Metodo per verificare il numero scelto dal giocatore
    public void verifica(int numero, int idGiocatore, String nomeGiocatore) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (numero == matriceNumeri[i][j]) {
                    System.out.println("Giocatore " + idGiocatore + ", " + nomeGiocatore + " ha scelto il numero " + numero + " e ha vinto!");
                    // Salva il vincitore nell'array
                    vincitori[numeroVincitori] = idGiocatore;
                    if(numeroVincitori < 3){ //Controllo del numero massimo dei vincitori
                        numeroVincitori++; 
                    }
                    return;  // Esci subito dopo aver trovato il numero
                }
            }
        }
        // Se il numero non viene trovato, questo blocco viene eseguito
        System.out.println("Giocatore " + idGiocatore + ", " + nomeGiocatore + " ha scelto il numero " + numero + " e ha perso.");
    }
    

    // Metodo per eseguire il thread
    @Override
    public void run() {
        System.out.println("Inizio estrazione numero casuale");
        Random random = new Random();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matriceNumeri[i][j] = random.nextInt(25)+1;
            }
        }
        try {
            Thread.sleep(2000); // Simula il tempo necessario per l'estrazione
        } catch (InterruptedException ex) {
            Logger.getLogger(Estrazione.class.getName()).log(Level.SEVERE, null, ex);
        }
        stampaMatrice();
        System.out.println("Fine estrazione\n");
    }
}