# README #

This README would normally document whatever steps are necessary to get your application up and running.

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

Após analisar o problema, percebi que Sessions (com tempo disponível limitado) e Talks (com cada uma com um tempo de duração), se pareciam muito com mochilas e itens, respectivamente.

Foi então que percebi que poderia utilizar a problemática do algoritmo da mochila, o famoso Knapsack algorithm.

### How do I get set up? ###

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