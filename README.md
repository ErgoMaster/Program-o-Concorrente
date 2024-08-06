<div align="center">
  <h1 align="center">Programação concorrente com Java</h1>
</div>

<div align="justify">
Nesse repositório estão algumas soluções para problemas de concorrência famosos da área de programação. Foi utilizada a linguagem Java junto com a ferramenta de interface Javafx. Esses trabalhos foram desenvolvidos por mim na disciplina de Programação Concorrente do curso de Ciência da Computação na UESB.
</div>

## Simulação entre trens
<div align="justify">
Nesse problema há 2 trens, os quais irão passar por uma intersecção entre seus trilhos. O programa utiliza um semáforo para travar a região crítica (a intersecção) com o intuito de evitar que os trens colidam.
</div>

## Problema do produtor/consumidor
<div align="justify">
Nesse problema há dois agentes, um produtor que irá disponibilizar livros e um consumir que irá os alugar. Temos que implemetar essa situação de forma que, se a pilha de livros estiver cheia, o produtor não poderá disponibilizar mais livros e que, se a pilha de livros estiver vazia, o consumidor não poderá alugar mais livros. Assim, foram utilizados 3 semáforos, um para quando a pilha estiver vazia, outro para quando a pilha estiver cheia e, por fim, um terceiro semáforo para que o produtor e consumidor não acessem a pilha ao mesmo tempo.
</div>

## Jantar dos Filósofos
<div align="justify">
Aqui, há 5 filósofos sentados a mesa, prontos para comerem seus respectivos pratos. Cada filósofo necessita de dois garfos para comerem seus macarrões, porém, para cada filósofo, seu garfo a esquerda é compartilhado com o filósofo sentado a sua esquerda e seu garfo a direita é compartilhado com o filósofo sentado a sua direita. Ou seja, há mais filósofos do que garfos, assim deve haver um revezamento para que todos comam mas que não fique um filosofo sem comer ou que coma por tempo demais. filósofos que sentam um ao lado do outro não podem comer ao mesmo tempo, mas filósofos que não compoartilham garfos podem comer ao mesmo tempo.
</div>

## Problema dos leitores e escritores
<div align="justify">
Aqui, há 1 escritor que será uma thread que irá disponibilizar livros para que 5 leitores possam sentar e ler. O escritor só pode modiicar a base de dados (os livros) quando não há leitores para se sentar e há um limite para a quantidade de leitores que podem ler simultâneamente. Foram utilizados 2 semáforos, um para travar a base de dados para que o escritor pare quando há um leitor lendo e outro para controlar a fila de leitores, para que não haja leitores demais. 
</div>

## Trânsito autônomo
<div align="justify">
Esse foi o último trabalho a ser desenvolvido, se trata de uma simulação de um trânsito autônomo onde numa cidade com várias ruas interconectadas onde há 7 carros que trafegam por essa cidade com percursos diferentes. Esses carros não podem passar um por cima do outro, ou seja, nas ruas em que compartilham seu percuso esses carros não podem passar ao mesmo tempo. Assim, foram utilizados semáforos para fazer com que um carro espere o outro passar por aquela rua, mas de forma que ele não espere demais.
</div>

## Ferramentas
- Linguagem: Java
- Interface: Javafx
- Style: SceneBuilder

## Para testar os projetos
<div align="justify">
Será necessária a instalação do Java e do Javafx. Procure o caminho da pasta "lib" do javafx e o copie. 

### Rode o programa
```shell
javac --module-path \"YourPath/lib\" --add-modules javafx.controls,javafx.fxml Principal.java
```
```shell
java --module-path \"YourPath/lib\" --add-modules javafx.controls,javafx.fxml Principal
```
</div>
