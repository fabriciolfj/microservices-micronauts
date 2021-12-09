# Microservices com Micronauts
### Cliente http
- Para efetuar uma requisição http, micronaut disponibiliza a lib httpclient, bem simuilar a do java 14.
- Exemplo de requisição:

```
var dto = InventoryMapper.toDto(product);
var client = HttpClient.create(new URL(host));
var result= client.toBlocking().retrieve(HttpRequest.POST("/api/v1/inventories/entrance", dto), InventoryResponseDTO.class);
```
