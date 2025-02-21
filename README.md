# oopd-gu-chalmers Lab 1
MOTIVERING LABB 3

Coupling: Vi har i så hög grad som möjligt försökt att undvika att klasser är beroende av varandra på ett sådant sätt att förändringar i en klass leder till att vi måste rekonstruera en annan klass. Därför har vi delat upp ansvaret i interfaces och i förälder klasser så att exempelvis Volvo och Saab ärver ifrån en förälder klass hellre än att de själva ska implementera logiken. 

Cohesion: Vi har siktat på att skapa många små metoder för att kunna användas i programmet som byggstenar, dvs när vi vidareutvecklar programmet eller stöter på fel måste vi inte ändra hela klassen utan kan istället bygga om de mindre delarna. Detta gör klasserna flexibla för förändring och felhantering men också för utveckling och underhåll. Vi strävar i vårt program efter “high cohesion” vilket vi uppnår genom att låta modulerna inom våra klasser lösa deras uppgifter själva utan att behöva anropa andra klasser. Car Controller som styr bilarna har många kopplingar till de olika klasserna men detta ser vi som något bra i och med att Car Controller verkar lite som en Main klass.

Dependency Inversion Principle: I denna labb (3) så introducerades car controller som funkar likt ett huvudprogram genom att ha interface för Moveable och Loadable går det att med säkerhet skriva kod som vi vet kommer att vara implementerad och vilka parametrar som tas in i metoder. Detta gör att Car Controller inte längre är lika beroende av övriga klasser som anropas och används. Det går alltså bra att ändra i klasserna utan att det blir fel i Car controller, detta gör det enklare att underhålla och testa. Att implementera 
interfaces gör det också enklare att testa klasser som ärver från exempelvis car eftersom att man vet säkert att metoderna kommer att finnas där och hur de används. 

Vilka ansvarsområden har våra klasser?

Move och moveable
Moveable är ett interface som gör att alla subklasser som implementerar moveable tvingas också att implementera dess metoder. Därför finns logiken för dess metoder i den direkta abstrakta subklasser Car som i sin tur har subklasser som bara anropar sin supers metod för move. 
Car 
I den abstrakta klassen Car finns all generell logik som är för fordon i programmet. Så som hur många dörrar, vilken färg och vad det är för modell. Men även logiken för att gasa, bromsa, starta och stanna. Men klassen innehåller även getters och setters för att hantera hastighet och accelerationer. Alla subklasser till car har olika typer av acceleration och overrideas i klasserna separat. 
Saab96
Hanterar logiken för turbo on/off och dess egna acceleration har en egen konstruktor som delvis bygger på sin supers(Car) konstruktor . 
Volvo240
Hanterar egen logik för acceleration i förhållande till egen trim factor. Har en egen konstruktor som, likt saab, delvis bygger på sin supers(Car) konstruktor.
Truck
Den abstrakta klassen truck hanterar logik för att höja och sänka någon typ av ramp, 

Scania
Egen implementering av move eftersom att det finns regler för hur man får starta och köra med rampen nere. 

CarCarrier
Hanterar load funktionalitet för att ha bilar lagrade. 

CarRepairShop
Hanterar också funktionalitet för att ha bilar lagrade men på ett generiskt sätt. 
Frågor för upg 2
Vilka beroenden är nödvändiga?
Beroenden mellan (Saab,Volvo) och Car är nödvändiga eftersom vi inte vill kunna skapa dessa utan att följa Cars struktur. CarController, Peterbilt är beroende av Car men de hanterar inte så mycket runt Car vilket vi anser vara ett svagt nödvändigt beroende som inte stö. Detta hade kunnat hanteras som CarRepairShop gör genom en generisk lista som inte är beroende av Car. 

Vilka klasser är beroende av varandra som inte borde vara det?
CarControllerTest är beroende av Saab och Volvo vilket inte är nödvändigt. CarCarrier hanterar just nu bilar eftersom den lastar i och ur, denna logiken bör flyttas därifrån till en klass som endast hanterar lastning och avlastning. 

Finns det starkare beroenden än nödvändigt?
I CarCarrier och i CarController är listorna med Car direkt beroende av klassen car. Man hade istället kunnat göra en generisk lista. 
Kan ni identifiera några brott mot övriga designprinciper vi pratat om i kursen?
 Klassen car bryter idag mot regeln om separation of concerns när den hanterar både bilobjekt och koordinater. Car kommer nu att ha flera anledningar till förändring, till exempel att vi vill ändra på hur bilarna gasar men också om vi vill ändra koordinatsystemet. Lösningsförslag på detta är att ha en till klass över car som hanterar detta, som då car ärver ifrån. 



UML diagram för uppgift 2:
https://lucid.app/lucidchart/93eb620a-f2a4-44e8-a465-f9b676865e7c/edit?viewport_loc=-2258%2C-1585%2C4657%2C2468%2C0_0&invitationId=inv_3e07c6b8-2349-469e-a607-f06fcda223ec


Analys av klasser med avseende på Separation of Concern (SoC) och Single Responsibility Principle (SRP)
Det finns följande ansvarsområden:
Hastighetlogik - Hantering av acceleration, bromsning och hastighetsbegränsningar.
Körninglogik - Hantering av rörelse, rikning och koordinater
Ramp/dörrlogik - Kontroll av rampen/dörrens position och begränsnigar för rörelse
Storagelogik - Hantering av lagring av fordon
In/utlämningar av bilar - Processen för ta emot och lämna ut bilar i CarRepairShop klassen. 

Just nu är våra klasser ansvariga för flera av dessa områden vilket bryter mot Single Responsibility Principle. Ett exempel är att CarCarrier klassen som är ansvarig för både körning, lagring av bilar och rampstyrning. Detta gör klassen svårare att underhålla och modifiera eftersom förändringar i ett ansvarsområde kan påverka andra delar av koden. Det gör även koden svårare att förstå och testa eftersom varje klass har flera ansvarsområden. 

Just nu hanterar Car klassen både hastighetslogik och körningslogik. Därav skapar vi en separat klass kallat Movement som hanterar fordonets rörelse och riktning. 
Truck och subklasserna Scania och CarCarrier klassen hanterar både körningslogik och rampstyrning. Därav flyttar vi rampens logik till en separat klass Ramp.
CarRepairShop och CarCarrierTruck hanterar både lagringslogik och därför flyttar vi logiken för det i en separat klass Storage.

Motivera, i termer av de principer vi gått igenom, varför era förbättringar verkligen är förbättringar.
Nu ansvarar varje klass för ett enskilt ansvarsoområde vilket gör att vi bättre följer  Single Responsibility Principle. Fordonslogiken och gränssnittet är nu separerade, vilket innebär att en förändring i en modul inte påverkar den andra. Därmed har vi uppnått Separation of Concern.

Refaktoriseringsplan

Flytta ut körning logiken från Car klassen till en separat klass som kallas Movement. I Car kommer movment att fieldas, därmed kan movements metoder anropas och i mån av behov. Särskilt med tanke på Scania och CarCarrier som har extra restriktioner på rörelse på grund av ramplogiken. På detta viset är koden enklare att testa och car hanterar bara billlogik(SoC & SRP). Det är även bra för framtida utveckling om man vill lägga till saker som inte bilar men som ändå ska kunna röra på sig. Exempelvis cyklar eller människor. 
Flytta ut ramplogiken från Truck till en separat klass Ramp. Skapa en ramp instans i Truck så att den använder Ramp för ramplogiken istället för internt. Samt anpassa relevanta metoder i Scania och CarCarrier. Då garanterar man att metoderna är implementerade. Det blir även lättare att testa och ändra i framtiden. (DIP) Detta är även mer lokiskt än ett arv eftersom att en lastbil inte är en ramp utan har en ramp. 
Flytta ut lagringslogiken från CarCarrier och CarRepairShop till en separat generisk abstrakt klass Storage. Se till att lägga till metoderna removeLast() och removeFirst() för anpassa till subklassernas skilda utlämningslogiker. Ändra relevanta metoder i CarCarrier och CarRepairShop.
En ny klass model, Model, införs som följer design principerna av att ha en controller, en view och en model. Model har då koll på billistan var bilarna ska ritas ut, vilken bild som hör till vilken bil etc. 


Finns det några delar av planen som går att utföra parallellt?
Ja flera delar kan genomföras parallelt eftersom förändringarna påverkar helt olika delar av koden. I vårat fall är vi tre som jobbar så exempelvis skulle vi kunna jobba med varsinn punkt i refaktoriseringsplanen och sedan snacka ihop oss och ta oss an den som blev kvar tillsammans.


Slutgiltigt uml diagram(det till höger)
https://lucid.app/lucidchart/8a5a43f4-411c-4644-80eb-5c7049643f83/edit?viewport_loc=-1575%2C-2625%2C10394%2C5094%2C0_0&invitationId=inv_cfdcaa81-b566-4325-97a9-a5a5b92478f7


