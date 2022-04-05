# consumer-public-api Project

##Um projeto Quarkus.

 O pacote inicial do projeto foi gerado a partir do siter do quarkus.io que fonece um projeto base organizado e com as dependencias de nossa escolha.

para executar

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Empacontaodo e rodando a aplicacão


```shell script
mvn clean packege Dquarkus.profile=prod
```
apesar de poder ser compilada para binário esta aplicação não esta executando em binário. ela roda sobre a open-jdk-11 e esta sendo executada dentro de um docker presente neste arquivo.

## desafios:
Tive desafio especial e acabei por não buscar um solução definifiva para mapear para um objeto e uma lista, retornando uma string da resposta e filtrando no proprio front na listagem de apis. infelizmente o tempo não contribuiu para a busca de um solução efetiva.
apesar de retorar uma string no header e no body da requisição de login, não implementei o jwt que era o objetivo primário.
e existe uma dependencia que acabou pro quebrar os teste unitário, mas com a remoção das dependencias do jersey cliente os testes voltam a funcionar. ja existe uma solução para a incompatibildade.