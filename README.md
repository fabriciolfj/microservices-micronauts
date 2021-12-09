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
### Segurança
