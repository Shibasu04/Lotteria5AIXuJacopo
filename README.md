<h1 align="center">Lotteria</h1>

<p align="center" style="font-family: monospace">Jacopo Xu <a href="https://github.com/Shibasu04">@Shibasu04</a></p>
<p align="center" style="font-family: monospace">Corso TPSIT <a href="https://www.avoltapg.edu.it/">ITTS A. Volta (PG)</a></p>
<p align="center" style="font-family: monospace">Template del file README.md ispirato da <a href="https://github.com/matbagnoletti">@matbagnoletti</a></p>

# Lotteria

## Scopo del progetto
Il progetto "Lotteria" è un'applicazione Java che simula un gioco di lotteria. I giocatori scelgono un numero casuale e partecipano all'estrazione di numeri casuali. L'obiettivo è determinare quali giocatori hanno scelto un numero corrispondente a uno dei numeri estratti. Il gioco si conclude con la visualizzazione dei vincitori e dei numeri estratti.

## Classi principali

### Estrazione
La classe `Estrazione` estende `Thread` e rappresenta l'operazione di estrazione dei numeri.

#### Metodi principali:
- **Costruttore:** Inizializza una matrice di numeri estratti, il numero di giocatori e l'array dei vincitori.
- **stampaMatrice():** Stampa la matrice dei numeri estratti.
- **stampaVincitori():** Visualizza i vincitori dell'estrazione. Se non ci sono vincitori, viene mostrato un messaggio appropriato.
- **verifica(int numero, int idGiocatore, String nomeGiocatore):** 
  - Questo metodo verifica se il numero scelto dal giocatore è presente nella matrice dei numeri estratti.
  - Scorre la matrice e confronta ogni numero con quello fornito dal giocatore.
  - Se il numero è trovato, stampa un messaggio di vittoria, salva l'ID del giocatore nell'array `vincitori`, incrementa il contatore dei vincitori e termina la ricerca.
  - Se il numero non viene trovato, stampa un messaggio di sconfitta.
  - Limita il numero massimo di vincitori a 3.

### Giocatore
La classe `Giocatore` estende `Thread` e rappresenta un giocatore nel gioco.

#### Metodi principali:
- **Costruttore:** Inizializza l'ID del giocatore, il nome e il numero casuale scelto.
- **run():** Metodo che esegue il thread del giocatore, simula un conto alla rovescia prima di verificare il numero scelto e chiama il metodo `verifica` della classe `Estrazione`.

## Riferimenti alle librerie
Il progetto utilizza le seguenti librerie Java:
- `java.util.Random` per generare numeri casuali.
- `java.util.logging` per gestire la registrazione delle eccezioni.

## Scenari alternativi di funzionamento
1. **Nessun vincitore:** Se nessun giocatore sceglie un numero che corrisponde a quelli estratti, il programma stamperà "Nessun vincitore."
2. **Interruzione dei thread:** Se un thread è interrotto durante l'esecuzione, verrà registrato un messaggio di errore nel logger, ma il programma continuerà a funzionare.
3. **Numeri duplicati:** Se nella matrice di numeri estratti ci sono numeri duplicati, il programma non avrà problemi, poiché il metodo `verifica` è progettato per trovare il numero anche se è presente più di una volta.

## Commento dell'esecuzione
L'esecuzione del programma inizia con il messaggio "Avvio lotteria". Viene quindi avviato un thread per l'estrazione dei numeri, seguito da un conto alla rovescia per ogni giocatore prima che verifichi il proprio numero. Al termine della verifica, vengono mostrati i numeri estratti e i vincitori, con un messaggio finale "Fine del gioco". I messaggi stampati nel terminale guidano l'utente attraverso il processo di gioco, rendendo l'esperienza interattiva e chiara.
