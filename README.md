# API de Produtos: Encontre as Ofertas Imperdíveis

Este é um projeto simples que consome uma API de produtos e exibe os produtos com preço abaixo de R$ 30 como "imperdíveis". O projeto é desenvolvido em Java com Spring Boot.

## Serviço ConsomeApi

O serviço ConsomeApi é responsável por fazer requisições HTTP para obter os dados da API de produtos.

<div style="text-align: center;">
    <img src="https://github.com/leonardojfrenner/ConsumoAPI/assets/115934024/0500f0a1-903d-42d7-a666-775586ae27f9" width="700px" />
</div>

### Funcionamento

O serviço utiliza a classe `HttpClient` do Java 11 para fazer a requisição GET para a API. Aqui está um resumo do funcionamento:

1. Cria uma instância de `HttpClient`.
2. Constrói uma requisição HTTP GET com a URL fornecida.
3. Envia a requisição síncrona utilizando o método `send()` da classe `HttpClient`.
4. Verifica o código de status da resposta:
   - Se o código for 200 (OK), retorna o corpo da resposta como uma String.
   - Se o código não for 200, lança uma exceção informando o erro.
5. Captura e trata exceções de IO e interrupção de thread, se necessário.

### Utilização

Para usar o serviço ConsomeApi em seu projeto, siga estas etapas:

1. Instancie um objeto `ConsomeApi`.
2. Chame o método `obterDados()` passando a URL da API como parâmetro.
3. O método retornará os dados da API como uma String.

Exemplo de uso:

```java
ConsomeApi apiConsumer = new ConsomeApi();
String dados = apiConsumer.obterDados("https://api.escuelajs.co/api/v1/products/");
````

<div style="text-align: center;">
    <img src="https://github.com/leonardojfrenner/ConsumoAPI/assets/115934024/4790d099-ce66-4c0d-b22e-77afd906a05f" width="700px" />
</div>

## Exceções

O serviço trata as seguintes exceções:

- **IOException**: Erro de IO ao fazer a requisição para a API.
- **InterruptedException**: A thread foi interrompida ao fazer a requisição para a API.

Em caso de exceção, o serviço lança uma `RuntimeException` com uma mensagem descritiva do erro.

## Funcionalidade Adicional

Além de listar os produtos "imperdíveis", agora o projeto exibe o preço desses produtos. O preço é exibido ao lado do nome do produto, entre parênteses.

```java
String title = product.get("title").asText().toUpperCase();
double price = product.get("price").asDouble();
return title + " - IMPERDÍVEL! (R$" + price + ")";
```

<div style="text-align: center;">
     <img src="https://github.com/leonardojfrenner/ConsumoAPI/assets/115934024/587bf1fb-1ab5-4ec8-b100-476a927373e6" width="700px" />
</div>

## Autor

Este projeto foi desenvolvido por [Leonardo Renner](https://www.linkedin.com/in/leonardo-josé) com o objetivo de atender aos requisitos funcionais estabelecidos pela empresa.

### Objetivo do Projeto
A empresa deseja apresentar os nomes dos produtos que custam menos de R$ 30 como "imperdíveis" e em promoção para atrair a atenção dos clientes.

### Requisitos Funcionais
- A aplicação deve consumir a API fornecida pela empresa para obter informações sobre os produtos: [API de produtos](https://api.escuelajs.co/api/v1/products/)
- A aplicação deve filtrar os produtos que custam menos de R$ 30.
- Os nomes dos produtos filtrados devem ser apresentados em uma lista de "Imperdíveis", todos escritos em maiúsculas.

Este projeto cumpre os requisitos funcionais estabelecidos pela empresa, fornecendo uma solução para destacar os produtos em promoção e atrair os clientes.




