# Pacman

Pac-Man Adventure is a game where players control Pac-Man, 
a yellow character, as he navigates a maze, eating dots and avoiding ghosts. 

The objective is to find the key and leave the maze while avoiding the ghosts that pursue Pac-Man. 
Players must strategically maneuver Pac-Man through the maze to collect score.

## Install

### Maven
Standart way to compile and play the game is to use Maven tool:
```bash
mvn package
```

It should compile the project, create program documentation and create .jar file.
After .jar file is created, in order to launch the game use:

```bash
java -jar .\target\pacman-1.0.jar
```

### Makefile

There is also non-standart way to play the game, which is using Makefile.

If you are using **Windows**, run:

```bash
make -f Makefile
```

For **unix-based** systems (We used Ubuntu) run:

```bash
make
```

This should compile and run application right away. Good luck!

## Plan [CZ]

Vedoucí týmu: *Oleksandr Turytsia, xturyt00*<br/>
Člen týmu: *Kambulat Alakaev, xalaka00*<br/>

#### Seznam požadavků
Priority: Nejvyšší priorita = 5, nejnižší priorita = 1
Stavy: ✔️- splněno, ❌ - nesplněno
|Priorita|Požadavek|Vlastník (má na starosti)|Předpokládaný termín|Stav|
|---|---|---|---|---|
|5|Vytvořit spravnou strukturu složek podle zadání|O. Turytsia|15.04.2023|✔️|
|5|Vytvořit záklandní menu (Main screen). Najit vhodné sprity pro duchy a panačka|O. Turytsia|16.04.2023|✔️|
|5|Vzít projekt z druhého zadání a připojit ho do naší hry|K. Alakaev|16.04.2023|✔️|
|4|Vytvořit rozhraní pro vyběr mapy|O. Turytsia|17.04.2023|✔️|
|5|Implementovat observer aby změny (např. pohyp panačka) byly viditelné na uživatelskem rozhraní|K. Alakaev, O. Turytsia|18.04.2023|✔️|
|5|Implementovat počet žívotů u pakmana a body v bludiště|K. Alakaev|21.04.2023|✔️|
|2|Přidat do každé mapy svůj popis|O. Turytsia|23.04.2023|❌|
|5|Realizovat pohyb duchů, připojit počet životů a body do uživatelského rozhraní|K. Alakaev, O. Turytsia|23.04.2023|✔️|
|5|Implementace algoritmu A* pro samostatný pohyb panačka|K. Alakaev|24.04.2023|✔️|
|5|Implementace rozrhaní když pacman hru vyhrá nebo prohrá|O. Turytsia|24.04.2023|✔️|
|5|Realizovat logování ve hře|K. Alakaev|27.04.2023|✔️|
|5|Vytvořit rozhraní pro vyběr uložené hry s logováním, napojit logování do UI|O. Turytsia|28.04.2023|✔️|
|4|Upravy pohybu panačka při logování obraceně. Další drobné upravy ohledně funkčnosti projektu|O. Turytsia|30.04.2023|✔️|
|3|Přidat pom.xml aby fungoval Maven v projektu. Přidat základní komentáře pro programovou dokumentace|O. Turytsia|31.04.2023|✔️|
|5|Aktualizovat pom.xml, upravit komentáře aby kompiloval programovou dokumentace|K. Alakaev|04.05.2023|✔️|
|5|Testování a verifikace projektu. Odevzdání.|K. Alakaev, O. Turytsia|07.05.2023|✔️|