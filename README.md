Exercício de Programação 2:

Neste exercício você deverá implementar o método de cifração e decifração de chave pública e
privada RSA. Você não poderá utilizar implementações existentes na web ou em Java. Você
poderá usar:

1) A classe BIGINT, existente em Java, que armazena grandes inteiros.
2) A biblioteca de teoria dos números, existente em C++, chamada NTL (Number
Theory Library) ou a biblioteca de aritmética de precisão múltipla do GNU chamada
GMP (GNU Multiple Precision Arithmetic).

Em outras palavras, você pode usar estas implementações de funções de grandes inteiros para
manipular os seus dados e realizar aritmética modular, mas não use os métodos providos nestas
implementações para o cálculo de MDC, potência, achar números primos, etc. Você mesmo
deverá implementar estas funções.Note que Java provê ferramentas para a obtenção de números
aleatórios (randômicos) nos pacotes: java.util.random e java.security.SecureRandom. Do
mesmo modo, C++ provê os geradores de números aleatórios rand() e srand(). Porém, estes
geradores aleatórios providos por Java ou C++ não são seguros, pois utilizam o Método de
Congruência Linear (Linear Congruent Méthod). Para maior segurança, implemente o seu
próprio gerador de números aleatórios.

Na sua implementação do algoritmo RSA, assuma que os numeros primos têm pelo menos 500
bits (podendo ser bem maiores). Você deve escrever suas as funções especificadas abaixo:

1) Uma função para achar grandes números primos, dado o número de bits como entrada.
2) Uma função para calcular o MDC de dois números inteiros grandes.
3) Uma função para produzir uma chave aleatória para cifração, tendo como entrada os dois
números primos grandes p e q utilizados no algoritmo RSA.
4) Uma função para produzir a chave de decifração, tendo como entrada a chave de cifração e
os dois números primos grandes utilizados p e q utilizados no algoritmo RSA.
5) Uma função para cifração de uma mensagem, dados a mensagem, a chave e o módulo n.
6) Uma função de decifração de uma mensagem, dados a mensagem cifrada, a chave de
decifração e o módulo n.

O que você precisa entregar:

a) Um programa que cifre um arquivo usando RSA, onde a entrada será um arquivo
com o texto em claro e outro arquivo com a chave para cifração.
b) Um programa que decifre um arquivo usando RSA, onde a entrada será um arquivo
com o texto cifrado e outro arquivo com a chave para decifração.
