# Hexagonal
Um projeto feito para exemplificar o uso da arquitetura Hexagonal em um fluxo de pesquisa de endereço por cep e posterior cadastro de Cliente.
Para a busca do endereço foi usado wiremock. Para mensageria foi usado o Kafka.

## Tecnologias

- Kotlin
- Spring Boot
- Gradle
- MongoDB
- Kafka
- Docker

## Executando a aplicação

Em um terminal execute:
> docker-compose up -d

## Visualizando as mensagens no Kafka
No navegador acesse:
> http://localhost:9000/

## Endpoints
Todos os endpoints estão na collection do postman na raiz do projeto.

## Principais conceitos da Arquitetura Hexagonal
A arquitetura hexagonal, também conhecida como Ports and Adapters, foi proposta por Alistair Cockburn com o objetivo de tornar sistemas mais modulares, desacoplados e testáveis. Aqui vão os principais conceitos:

🧩 1. Domínio no centro
* O núcleo da aplicação é a lógica de negócio pura, independente de qualquer tecnologia externa.
* Essa camada é isolada de frameworks, bancos de dados, interfaces gráficas, etc.

🔌 2. Portas (Ports)
* São interfaces que definem os contratos de entrada e saída da aplicação.

Existem dois tipos:
* Portas de entrada (driven ports): representam as ações que a aplicação pode executar (ex: CriarPedidoUseCase).
* Portas de saída (driving ports): representam as dependências da aplicação para interagir com o mundo externo (ex: NotificadorEmail, RepositorioCliente).

🔄 3. Adaptadores (Adapters)
* Implementam as portas para conectar o domínio ao mundo externo.

Exemplos:
* Um adapter de entrada pode ser um controller REST ou CLI.
* Um adapter de saída pode ser um repositório JPA, um cliente HTTP, um produtor Kafka etc.

🧠 4. Inversão de dependência
* O núcleo da aplicação não conhece seus adaptadores.
* Os adaptadores é que sabem das portas e implementam suas interfaces.
* Isso permite testar o domínio isoladamente.

📦 5. Independência tecnológica
* A arquitetura facilita trocar frameworks, bancos, mensageria etc, pois essas tecnologias estão nos adaptadores.
* O domínio continua intacto se você mudar de Spring para Micronaut, por exemplo.
