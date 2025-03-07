Uppgift 2: Model-View-Controller
Användargränssnittet ni utgick från i del 3 var en ansats till implementation av Model-View-Controller Pattern, men där gränsdragningen mellan model, view, controller och applikation inte var något vidare genomtänkt (för att inte säga usel).
Vilka avvikelser från MVC-idealet kan ni identifiera i det ursprungliga användargränssnittet? Vad borde ha gjorts smartare, dummare eller tunnare?
Svar: I det ursprungliga användargränssnittet saknas en implementering av en modell, något som vi hade med i vår reaktoriseringsplan. Det närmsta som fanns en modell var CarPanel. Den är inte beroende av View eller Controller vilket är bra. 
En del av logiken (den smarta delen) låg i Controllern, till exempel hantering av billistan. Detta borde ligga i modellen som ska hantera allt det smarta. En del andra smarta delar av vår Controller borde flyttas till modellen för att göra Controller tunnare. View har även en del logik, den räknar bland annat ut en setLocation vilket även detta borde hanteras av modellen för att göra View “dummare” BORDE DEN DET?. För att köra programmet startas Controller filen vilket den inte bör hantera. Detta borde istället köras av en Applikation som har en Main funktion. 


Vilka av dessa brister åtgärdade ni med er nya design från del 3? Hur då? Vilka brister åtgärdade ni inte?
Svar: Model får en egen klass som hanterar visuella element och dess positioner. Därför följer det med SRP och SoC men också MVC-idealet. Car controller blir endast en controller och slutar att hantera modell logiken som fanns där sedan tidigare. Vi åtgärdades inte problemet med en applikation 
Rita ett nytt UML-diagram som beskriver en förbättrad design med avseende på MVC.
Svar: 

Observer, Factory Method, State, Composite. För vart och ett av dessa fyra designmönster, svara på följande frågor: 

Finns det något ställe i er design där ni redan använder detta pattern, avsiktligt eller oavsiktligt? Vilka designproblem löste ni genom att använda det?
Observer: Saab prenumererar på TurboOn och alla bilar prenumererar på startAll och stopAll. Detta skulle isåfall göras med ett “subscriber interface” med en update metod som alla bilar ärver av och en “publisher” klass dit CarController skickar nya state. Här skulle observer pattern kunna förbättra vår design. Detta förbättrar Open Closed principle eftersom det är lättare att lägga till fler bilar som subscribers till exempel om volvo vill börja använda turboOn. 
Borde carController steget tas bort? Att ha model direkt i carview?

Finns det något ställe där ni kan förbättra er design genom att använda detta design pattern? 
Om inte, varför skulle er design inte förbättras av att använda det?

Factory Method: I nuläget använder vi inte Factory Method men genom att skapa exempelvis en Vehicle factory kan vi göra koden mindre couplad men även göra det betydligt lättare att utöka med fler fordon. Vi skulle kunna förbättra sättet vi skapar bilar. Nu skapas alla med new funktioner i Applkation men detta hade kunnat flyttas till VechileFactory klassens ansvar och följer därmed mer SRP och SoC. 

Om inte, varför skulle er design inte förbättras av att använda det?

State: Vi har redan state på ett par ställen i vår kod. Direction, ramp (för Carcarrier) och turboOn. Direction har fyra states som representerar de fyra väderstrecken för att flytta bilarna. Ramp hos CarCarrier har två states, uppe eller nere dessa states ändrar beteendet hos lastbilen. När rampen är nere går det inte att köra iväg. TurboOn är som ramp med två lägen på eller av som bestämmer hastigheten hos våra Saab bilar. Vi hade kunnat ändra hur bilarna startar och stannar genom state. Istället för en startEngine och stopEngine hade vi kunnat ha en metod med ett state som är på eller av. 

Composite: 
Ja vi använder en form av composite i våran design. I CarReparShop och CarCarrier klassen använder vi Storage<T> för att hantera en samling av bilar. Dessa klasser fungerar som en en abstraktion och hanterar samlingen utan att behöva känna till detaljerna kring lagring. I vår design fungerar Car som Leaf och Storage som Composite då den kan innehålla flera bilar.

Vi skulle kunna förstärka Composite designmönstret genom att skapa en Vehicle klass som både Car och Truck kan implementera. Då skulle CarCarrier och CarRepairShop kunna hantera en lista av Vehicle istället för endast Car. Det blir bättre generalisering då CarCarrier och CarRepairShop blir mer flexibla och kan hantera olika fordon utan att kräva separata listor. Även ökad återanvändbarhet om vi i framtiden vill lägga till flera fordonsklasser. 

https://lucid.app/lucidchart/2a8b3364-523c-4dcb-9e67-bbe704ba4614/edit?viewport_loc=-3132%2C-1144%2C3218%2C1706%2C0_0&invitationId=inv_d35ab4fc-5ec9-45df-9951-e3268f80abd9
 

Refaktoriseringsplan!! 

Göra en Vehicle klass och flytta ut relevanta delar från Car klassen
Lägg till en vehicle factory som har i uppgift att skapa och returnera antingen bestämda bilar eller en slumpmässigt utvald sort.
Skapa en announcer som objekt kan prenumerera på för att få uppdateringar enligt observer design patter. Där ska man få info om att starta turbo on off som saab exempelvis. 

