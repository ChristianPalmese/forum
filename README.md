L'esercizio consiste nel creare un'applicazione desktop che simula un forum di discussione. Gli utenti possono iscriversi, creare thread di discussione e lasciare messaggi all'interno dei thread. Ogni messaggio include informazioni sull'utente che lo ha inviato, il testo del messaggio, la data di invio e il numero di like ricevuti.

Con questo sistema è possibile inserire, modificare,eliminare e ricercare le informazioni relativa ad Utente,Thread e Messaggio. Il sistema permette inoltre la generazione di statistiche basate sulla frequenza degli argomenti.

Il progetto è stato implementato in Java versione 17 e, in particolare, è stato usato il framework Spring-boot.

Le entita sono persistite su un database mySQL e in Java sono state modellate mediante l'utilizzo dell'Entity Manager. Sono state utilizzate le annotazioni Spring-Data-JPA; mentre la parte rest è stata sviluppata mediante l'utilizzo di Spring-boot-starter-web.

Per migliorare la leggibilità del codice e ridurre la sua verbosità, è stata integrata l'estensione Lombok, che automatizza la generazione di getter, setter e costruttori.
