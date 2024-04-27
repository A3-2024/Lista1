

<img src="https://github.com/S4-2024/Lista1/blob/main/imagens/ESTRUTURAS%20DE%20DADOS%20E%20ALGORITMOS.png">

<h4 align="center" >    
   
[![Gabrielle Soares- 422221763](https://img.shields.io/badge/Gabrielle_Soares-422221763-pink?style=for-the-badge&logo=github&logoColor=pinkr)](https://github.com/gabriellesote)
[![ Anna Clara - 422142003](https://img.shields.io/static/v1?label=+Anna+Clara&message=422142003&color=C683D7&style=for-the-badge&logo=github&logoColor=C683D7)](https://github.com/byasun)

</h4>

<h4 align="center" > <em> Professores: Rafaela Moreira & Daniel Poyatos  </em>  </h4>

# Sobre


***Tema:*** Esta atividade foca na resolução de um desafio específico enfrentado por uma empresa fictícia.
<br>
***Objetivo:*** Utilizar os conhecimentos adquiridos em sala de aula sobre algoritmos de ordenação e programação em Java, de forma abrangente.

Em nosso projeto, optamos por implementar os algoritmos de SelectionSort e BubbleSort, devido à sua simplicidade e eficácia na resolução do problema.
<br>

### BubbleSort
O algoritmo de ordenação Bubblesort visa percorrer um conjunto de elementos várias vezes, e a cada viagem, o algoritmo "flutua" para o topo o maior elemento da sequência. Ele verifica a ordem dos dados dois a dois, e trocando-os de lugar se necessário.




##### Complexidade





| Complexidade pior caso  |  O(n²) |
| - | -|
| Complexidade caso médio	| O(n²)  |
| Complexidade melhor caso	|  O(n) 	|


##### Implementação (Java) 

```
for (int i = 0; i < caracteres.length - 1; i++) {
            for (int j = 0; j < caracteres.length - i - 1; j++) {
                if (caracteres[j] > caracteres[j + 1]) {
                    char temp = caracteres[j];
                    caracteres[j] = caracteres[j + 1];
                    caracteres[j + 1] = temp;
                }
            }
        }
```



### SelectionSort

O algoritmo de ordenação SelectionSort visa sempre passar o menor valor do vetor para a primeira posição (ou maior, depende da necessidade), depois o do segundo menor valor para a posição, e assim continuadamente com os <em> n-1 </em> elementos restantes, até finalizar. Ele é composto por dois laços, um laço externo e outro interno. O externo serve para controlar o índice inicial e o interno percorre todo o vetor. 

| Complexidade pior caso    	|  O(n²) |
|---	|---	|
| Complexidade caso médio	   | O(n²)  |
| Complexidade melhor caso	|  O(n²) 	|

```
for (int i = 0; i < nomes.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nomes.size(); j++) {
                if (nomes.get(j).length() < nomes.get(minIndex).length()) {
                    minIndex = j;
                }
            }
```


<details>
<summary>  <h2> 👾 Sobre a lista  </h2> </summary>

<h3 align="center" >

[![PDF](https://img.shields.io/badge/PDF-pink?style=for-the-badge&logo=github&logoColor=white+)](https://github.com/S4-2024/Lista1/blob/main/arquivos/EDAAA3ListadeExerccios1_20240415175717.pdf)
</h3>
 
 
<p>
Uma empresa de aplicativos de jogos, contratou você para desenvolver uma
solução para o seguinte problema:
</p>

* Dado o arquivo “JogosDesordenados.csv” contendo nomes de jogos
classificados em:
<ol>
 <li>Ação</li>
 <li>Cartas</li>
 <li>Corrida</li>
 <li>Estratégia</li>
 <li>RPG</li>
 <li>Esportes</li>
 <li>Palavras</li>
 <li>Quebra-Cabeça</li>
</ol>

* Deseja-se ordená-lo de duas formas: pela classificação e pela avaliação.
* Para fazer as ordenações, utilize dois algoritmos diferentes. Ex:
SelectionSort, BubbleSort.
* Crie um menu com as seguintes opções:

<span style="color:blue">   [1] Ler arquivo <br>
   [2] Ordenar em Categoria <br>
   [3] Ordenar em Avaliação <br>
   [4] Sair
 </span>.

<p>
→ Opção 1: 
 
* Ler o arquivo “JogosDesordenados.csv” e salvar os dados em um
vetor do tipo Item. Item é uma classe com os atributos:
     * Jogos(String): corresponde aos jogos mais acessados na Web (primeira coluna do arquivo).
     * Categoria(String): corresponde às categorias dos jogos (segunda coluna do arquivo).
     * Avaliacao(double): corresponde à avaliação dos usuários em relação aos jogos, varia de 0 e 5 (terceira coluna do arquivo).

→ Opção 2: <br>
 
* Ordenar o nome dos jogos pela categoria (ordem alfabética).
* Salvar o vetor de Item ordenado em um arquivo denominado: “JogosOrdenadosporCategoria.csv”.

→ Opção 3: <br>
 
*  Ordenar o nome dos jogos de acordo com a avaliação (ordem decrescente) de cada uma das categorias.
*  Salvar o vetor de Item ordenado em um arquivo denominado: “JogosOrdenadosporAvaliacao.csv”.

→ Opção 4: <br>
 * Fechar o programa.


 
</p>
</details>


 <h2> Resolução </h2>
 
[![Códigos](https://img.shields.io/badge/Códigos-blueviolet?style=for-the-badge&logo=github&logoColor=white+)](https://github.com/S4-2024/Lista1/tree/main/src)
 

  

