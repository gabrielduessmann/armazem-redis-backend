
## Requisitos
* JDK 11
* Maven
* Redis

## Instalação

### Build
```console
$ mvn clean install -DskipTests
```

### Running

```console
$ mvn spring-boot:run
```

## Banco de dados

* Para executar este projeto, é necessário utilizar um banco de dados Redis para salvar os registros.
* A porta padrão utilizada no projeto foi a 6379. Caso precise alterar, realiza alteração no arquivo: `src/main/java/com/armazem/redis/config/RedisConfig.java`

