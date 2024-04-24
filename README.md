<div align="center">
  <h1 align="center">Programação concorrente com Java</h1>
</div>

Nesse repositório estão algumas soluções para problemas de concorrência famosos da área de programação. Foi utilizada a linguagem Java junto com a ferramenta de interface Javafx.

## Simulação entre trens
Nesse problema há dois trens, os quais irão passar por uma intersecção entre seus trilhos. O programa utiliza um semáforo para travar a região crítica (a intersecção) com o intuito de evitar que os trens colidam.
<img></img>

## Problema do produtor/consumidor
Nesse problema há dois agentes, um produtor que irá disponibilizar livros e um consumir que irá os alugar. Temos que implemetar essa situação de forma que, se a pilha de livros estiver cheia, o produtor não poderá disponibilizar mais livros e que, se a pilha de livros estiver vazia, o consumidor não poderá alugar mais livros. Assim, foram utilizados 3 semáforos, um para quando a pilha estiver vazia, outro para quando a pilha estiver cheia e, por fim, um terceiro semáforo para que o produtor e consumidor não acessem a pilha ao mesmo tempo.
<img></img>
