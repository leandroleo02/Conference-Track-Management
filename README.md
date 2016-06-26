# README #

Este README terá todos os passos necessários para compilar, testar e executar a aplicação.

### Problema: ###

Conference Track Management

### Descrição (em inglês): ###

You are planning a big programming conference and have received many proposals which have passed the initial screen process but you're having trouble fitting them into the time constraints of the day -- there are so many possibilities! So you write a program to do it for you.

* The conference has multiple tracks each of which has a morning and afternoon session.
* Each session contains multiple talks.
* Morning sessions begin at 9am and must finish by 12 noon, for lunch.
* Afternoon sessions begin at 1pm and must finish in time for the networking event.
* The networking event can start no earlier than 4:00 and no later than 5:00.
* No talk title has numbers in it.
* All talk lengths are either in minutes (not hours) or lightning (5 minutes).
* Presenters will be very punctual; there needs to be no gap between sessions.
 
Note that depending on how you choose to complete this problem, your solution may give a different ordering or combination of talks into tracks. This is acceptable; you don’t need to exactly duplicate the sample output given here.

### Solução adotada ###

Após analisar o problema, percebi que Sessions (com tempo disponível limitado) e *Talks* (com cada uma com um tempo de duração), se pareciam muito com mochilas e itens, respectivamente.

Foi então que percebi que poderia utilizar a problemática do algoritmo da mochila, o famoso *Knapsack algorithm*.

Utilizei uma variação deste algoritmo, onde ao invés de me retornar o valor máximo possível que se pode adicionar à mochila, este me retorna o itens que poderiam ser adicionados à ela. Dessa forma, consigo selecionar as *Talks* que irão para a *Session*.

O restante do modelo ficou bem simples e coeso com a proposta do problema.

### Como configurar? ###

Toda configuração da aplicação será feita via Maven. Neste caso será necessário tê-lo configurado na máquina.
Caso não tenha, basta seguir as instruções no link abaixo:

Maven site: https://maven.apache.org/

Com o maven propriamente instalado e configurado no computador, basta seguir os passos a seguir:

Serão mostradas 2 (duas) maneiras de compilar e executar a aplicação. A primeira, será utilizando o *maven exec*. Este basicamente executa uma classe que tenha o método *main*. 




* Summary of set up
* Configuration
* Dependencies
* Database configuration
* How to run tests
* Deployment instructions

### Contribution guidelines ###

* Writing tests
* Code review
* Other guidelines

### Who do I talk to? ###

* Repo owner or admin
* Other community or team contact