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
