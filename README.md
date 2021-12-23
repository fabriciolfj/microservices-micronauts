# Microservices com Micronauts
### Cliente http
- Para efetuar uma requisição http, micronaut disponibiliza a lib httpclient, bem simuilar a do java 14.
- Exemplo de requisição:

```
var dto = InventoryMapper.toDto(product);
var client = HttpClient.create(new URL(host));
var result= client.toBlocking().retrieve(HttpRequest.POST("/api/v1/inventories/entrance", dto), InventoryResponseDTO.class);
```
### Tratativas de exceção
- o spring utilizamos o @ControllerHandler na classe de tratativa de exceção, e nessa tratavamos várias exceções
- já no micronaut, criamos um handler para cada exceção, apenas implementando a interface ExceptionHandler, passa a nossa exceção e o response.
- exemplo de handler customizado

```
@Produces
@Singleton
@Requires(classes = {InventoryNotFoundException.class, ExceptionHandler.class})
public class InventoryNotFoundExceptionHandler implements ExceptionHandler<InventoryNotFoundException, HttpResponse> {

    @Override
    public HttpResponse handle(HttpRequest request, InventoryNotFoundException exception) {
        JsonError error = new JsonError(exception.getMessage());
        error.path("/" + request.getPath());
        error.link(Link.SELF, Link.of(request.getUri()));

        return HttpResponse.badRequest().body(error);
    }
}

```
### Arquitetura de eventos
- a arquitetura de eventos precisa por uma comunicação assincrona, reativa a alguma mudança de estado que precisa ser notificado.
- para atender esses pontos, possui os elementos abaixo:
  - event: é uma mudança de estado no sistema que precisar ser notificado.
  - event producer: serviço ou sistema que detecta a mudança de estado e gera um evento para outros serviços 
  - consumidor de event: serviço ou sistema que recebe o evento, que é notificado
  - event brocker: o intermediário entre quem produz e recebe o evento

#### Estratégia de implementação
- pub/sub: um produtor cria os eventos, o broker encaminha esses eventos para suas filas, os consumidores destas filas os recebem
- streaming de eventos: o produtor de eventos os encaminha ao broker, o brocker os inserem em uma transmissão de eventos, o consumidor fica "ouvindo" essa transmissão, e pegando os eventos que vão chegando.

#### Configuração externalizada
- micronaut possui recursos para trabalhar com configuração externalizada, com apoio do Consul da hashicorp.
- dentro do consult, utiliza-se o recurso chave/valor.

#### Gateway, retry e fallback
- para retentativas podemos utilizar o Retryable e para circuit breaker o CircuitBreaker
- caso utilize o httpclient junto com um discovery, não precisamos especificar o ip e port do servico chamado, apenas indicar seu nome no client id. Exemplo:  @Client(id = "product-service")

#### Implantação da aplicação
- micronauts utiliza o jib, uma lib da google que facilita a criação de imagem docker, de aplicações feitas em java (maven ou gradle).

### Observabilidade
- Observabilidade em micro serviços é a junção de:
  - monitoramento: ver o desempenho do microservice e se ele esta up
  - logging centralizado: armazenar os registros dos serviços
  - tracing: ver o percurso de uma requisição, por quais serviços ela passou


#### Logging elk
- é um agragador de registros, que funciona da seguinte forma:
  - logstash coleta os logs, filtra e os transforma
  - elasticsearch armazena os logs
  - kibana é a UI que o usuário utiliza para visualizar os logs 

#### Tracing
- um tracing é a representação do percurso de uma requisição a uma malha de serviços
- um tracing é composto por spans, cada span é um traço de dados que passou por um componente ou serviço
- um span pode ter outros spans abaixo dele
