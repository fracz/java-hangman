# HANGMAN

Nasz klient potrzebuje grę *Hangman* w języku Java.

Gra jest bardzo prosta:

* losuje słowo i wyświetla "kreskami" ile to słowo ma liter
* mogę zgadywać czy dana litera pojawiła się w słowie
* jeśli trafiłem, gra odkrywa gdzie ta litera pojawia się w słowie (wszystkie wystąpienia)
* jeśli  nie trafiłem, infografika przedstawiająca status gry przybliża mnie do przegranej
* jeśli zgadnę wszystkie litery w słowie przed wykorzystaniem wszystkich prób - wygrywam
* jeśli nie uda mi się - przegrywam

Zasoby na ten projekt są limitowane. Otrzymane finansowanie pozwala nam poświęcić na ten projekt
3 godziny pracy maksymalnie trojga programistów. Zarząd liczy na Wasz sukces! **Opóźnienie nie wchodzi w grę.**

Żeby było łatwiej, otrzymujecie projekt animacji z działu grafików. Nasz lingwista
opracował listę słów do użycia w grze, a nasz specjalista ds. wizjonerstwa dodatkowo 
narysował koncepcję oczekiwanego produktu. Prawie wszystko jest więc gotowe. Wystarczy dodać trochę kodu.

![Success](https://raw.githubusercontent.com/fracz/java-hangman/master/img/success.gif)

![Failure](https://raw.githubusercontent.com/fracz/java-hangman/master/img/fail.gif)

# Jak to zrobić?

To już chyba wiesz?

Ale na wszelki wypadek:

1. Jedna osoba z pary forkuje ten projekt.
2. W ustawieniach repozytorium dodaje drugiej prawa zapisu do projektu (*Settings -> Collaborators -> Add people*). **Zaproszone osoby muszą zaakceptować zaproszenie!**
3. Obydwie osoby klonują sforkowane repozytorium na komputer, importują do IDE i patrzą co jest w środku.
4. Razem projektujecie implementację i ustalacie podział prac.
5. Pracujecie, wykorzystując wszystko co poznaliście w Javie do tej pory oraz system kontroli wersji.

**Przed ustalonym wyżej deadlinem specjalista ds. koordynacji projektów sprawdzi i oceni postęp prac i jakość implementacji.**

Do dzieła!

# NOWE WYMAGANIA!

Klient oczekuje jeszcze kilku funkcjonalności. Nie powinno to być problemem, bo przecież zaprojektowaliście
kod tak, by był [otwarty na rozszerzanie, ale zamknięty na modyfikacje](https://pl.wikipedia.org/wiki/Zasada_otwarte-zamkni%C4%99te),
prawda?

* gra powinna pozwalać na wybór długości słowa
* gra powinna pozwolić na podanie słowa, które ma być zagadką w kolejnej grze 
  (dzięki temu można uruchomić grę dla kogoś z wymyślonym przez siebie słowem)
* gra powinna umieć zapytać o słowo do gry z serwisu 
  [Wordnik](http://api.wordnik.com/v4/words.json/randomWords?hasDictionaryDef=true&minCorpusCount=0&minLength=5&maxLength=15&limit=1&api_key=a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5)
  zamiast z podanego pliku
  
