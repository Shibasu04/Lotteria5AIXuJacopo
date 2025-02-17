/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author jacopo xu
 */
public class Lotteria {
    /**
     * @param args the command line arguments
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
       Scanner Scanner = new Scanner(System.in);

       try{
        //Richiesta input all'utente della dimensione della matrice
        System.out.println("Inserisci il numero della dimensione della matrice dei numeri da estrarre: ");
        final int n = Scanner.nextInt();

        // Comunicazione avvio lotteria
        System.out.println("Avvio lotteria");
        
        // Istanza ed avvio del thread Estrazione
        Estrazione e = new Estrazione(n);
        e.start();
        e.join();
        
        // Istanza di alcuni thread Giocatore
        Giocatore g1 = new Giocatore(1, "Giacopo", e);
        Giocatore g2 = new Giocatore(2, "Ksu", e);
        Giocatore g3 = new Giocatore(3, "XuBuhan", e);
        Giocatore g4 = new Giocatore(4, "cinese", e);
        Giocatore g5 = new Giocatore(5, "Shibasu", e);
        
        // Avvio dei thread Giocatori
        g1.start();
        g1.join();

        g2.start();
        g2.join();

        g3.start();
        g3.join();
        
        g4.start();
        g4.join();
        
        g5.start();
        g5.join();
        // Comunicazione fine lotteria
        e.stampaVincitori(); // stampa dei vincitori
        System.out.println("Fine del gioco");
    }
    catch (InputMismatchException e) {
        System.out.println("Numero non valido");
    } finally {
        Scanner.close(); // Chiusura del scanner
    }
    }
}
   