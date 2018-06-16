# Testowanie aplikacji JAVA 2017-2018
## Projekt 1 (JUnit, narzędzie Hamcrest oraz MAVEN) 

| Travis CI Status |
|:--:|
[![Build Status](https://travis-ci.com/kkulewski/java-tdd.svg?token=raYvD9MwETMyAUKsjNr7&branch=delombok)](https://travis-ci.com/kkulewski/java-tdd)
-----------------------
### REGUŁY GRY

1. Wybieramy **jedno** z poniższych zadań. Zadania różnią się poziomem trudności i są inaczej punkto-
wane. 

2. Każdy projekt ma być wykonany przy użyciu narzędzia Maven! Projekt **nie powinien zawierać pliku jar oraz folderu
target**.

3. Przesyłanie projektu będzie odbywało się przy pomocy utworzenia Issue w swoim repozytorium. Utworzenie Issue wiąże się z oddanym projektem. Wszelkie zmiany po Issue będą obcinane.

**TERMIN: 09.04.2018**

- **Spóźnienia** z terminem będą wiązały się z **mniejszą ilością punktów**.
- **Maksymalny deadline** to **13.04.2018** i wtedy obowiązuje **50%** punktów z projektu. A więc dzień zwłoki oznacza obniżenie progu o **10%**. Po tym terminie projekty liczone są na **0%**!
- Projekt, w którym nie będzie wykonywało się polecenie **mvn test** będzie liczony na **0%**!
- Ponadto pod ocenę będzie brany styl projektu: jak zapisane są testy i jak sprawdzane są asercje.
- Testy powinny wykorzystywać wiele różnych asercji (a nie tylko assertEquals)!
- Ponadto po sprawdzeniu projektu należy go obronić: będą to krótkie pytania i ewentualne drobne
zmiany w kodzie podane przez prowadzącego!

-----------------------

**PROJEKT 4** (15 pkt) 

Napiszmy program, który pozwalać będzie na przemieszczanie się statkiem po morzu. Morze ma wyspy na które statek nie może wpłynąć.
Wymagania do tego programu są następujące:
- Określone są punkt początkowy(x,y) statku oraz jego kierunek (N -> północ, S -> południe, E -> wschód, W -> zachód).
- Dodaj obsługę poleceń przesuwających statek naprzód (n) i wstecz (w).
- Dodaj polecenia powodujące obrót statku w lewo (l) i prawo (p).
- Statek przyjmuje łańcuch znaków z poleceniami (literami: n,w,l,p oznaczającymi odpowiednio naprzód,
wstecz, lewo, prawo).
- Dodaj obsługę wykrywania lądu. Wykrywanie powinno odbywać się przed każdym ruchem na
nową pozycję. Jeśli polecenie wymaga wpłynięcia na ląd, statek ma anulować ruch, pozostać
na obecnej pozycji i zgłosić napotkane przeszkody.
- Dodaj możliwość zapisu mapy do pliku oraz odtworzenia mapy z pliku.

Pod ocenę będą brane pod uwagę następujące elementy:
- (1 pkt) Kompilacja i uruchomienie bezbłędne projektu.
- (2 pkt) Uwzględnienie powyższych wymagań.
- (5 pkt) Przypadki testowe.
- (1 pkt) Użycie różnych asercji.
- (1 pkt) Uwzględnienie wyjątków.
- (1 pkt) Zastosowanie biblioteki Hamcrest.
- (1 pkt) Pokrycie kodu.
- (1 pkt) Styl kodu.
- (1 pkt) Zastosowanie metodyki TDD.
- (1 pkt) Zastosowanie testów parametrycznych.

Ponadto dodatkowo pod uwagę będą brane następujące elementy: 

- (1 pkt) Użycie biblioteki AssertJ.
- (1 pkt) Skonfigurowanie TravisCI do automatycznego budowania projektu.
- (1 pkt) Zastosowanie testów parametrycznych przy użyciu plików testowych.
- (1 pkt) Zastosowanie JAVA 8 lub wyżej.
- (2 pkt) Zastosowanie dodatkowych różnych wymagań do gry.
- (2 pkt) Użycie innych technologii nie pokazywanych na zajęciach.

Ponadto pod ocenę jest brane również: (Brak tych elementów: -1 pkt za
podpunkt od obowiązkowej punktacji zadania!)
- Historia projektu w repozytorium.
- Ocena opisu commitów 
- Stan repozytorium (żeby nie był śmietnikiem!!!)
