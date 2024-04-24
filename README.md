<div align="center">
  <h1 align="center">Programação concorrente com Java</h1>
</div>

Nesse repositório estão algumas soluções para problemas de concorrência famosos da área de programação. Foi utilizada a linguagem Java junto com a ferramenta de interface Javafx.

## Simulação entre trens
Nesse problema há 2 trens, os quais irão passar por uma intersecção entre seus trilhos. O programa utiliza um semáforo para travar a região crítica (a intersecção) com o intuito de evitar que os trens colidam.
<img></img>

## Problema do produtor/consumidor
Nesse problema há dois agentes, um produtor que irá disponibilizar livros e um consumir que irá os alugar. Temos que implemetar essa situação de forma que, se a pilha de livros estiver cheia, o produtor não poderá disponibilizar mais livros e que, se a pilha de livros estiver vazia, o consumidor não poderá alugar mais livros. Assim, foram utilizados 3 semáforos, um para quando a pilha estiver vazia, outro para quando a pilha estiver cheia e, por fim, um terceiro semáforo para que o produtor e consumidor não acessem a pilha ao mesmo tempo.
<img></img>

## Jantar dos Filósofos
Aqui, há 5 filósofos sentados a mesa, prontos para comerem seus respectivos pratos. Cada filósofo necessita de dois garfos para comerem seus macarrões, porém, para cada filósofo, seu garfo a esquerda é compartilhado com o filósofo sentado a sua esquerda e seu garfo a direita é compartilhado com o filósofo sentado a sua direita. Ou seja, há mais filósofos do que garfos, assim deve haver um revezamento para que todos comam mas que não fique um filosofo sem comer ou que coma por tempo demais. filósofos que sentam um ao lado do outro não podem comer ao mesmo tempo, mas filósofos que não compoartilham garfos podem comer ao mesmo tempo.
<img></img>

## Problema dos leitores e escritores

## Trânsito autônomo
