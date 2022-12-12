# Challenge-FOH

### Descripcion:
Challenge creado para la administración de clientes mediante un CRUD, así también
como el cálculo de la cantidad de nombres de clientes cuya cantidad de caracteres
corresponda a un número primo.

### Contrato Swagger:
https://app.swaggerhub.com/apis/FELIPEARIASID/challenge-foh/1.0.1

### GET 

```
curl --location --request GET 'http://34.83.38.67:8080/customer' \
--header 'Content-Type: application/json'
```

### POST 

```
curl --location --request POST 'http://34.83.38.67:8080/customer' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Felipe",
    "lastName": "Arias",
    "address": "Calle 14",
    "email": "FelipeArias@gmail.com",
    "phoneNumber": "123456"
}'
```

### GET 

```
curl --location --request GET 'http://34.83.38.67:8080/customer/primes' \
--header 'Content-Type: application/json'
```

## Deseables:
 - Paginación cuando al momento de retornar una lista
 - Crear entidad para customer primes para devolver la cantidad de nombres primos como un atributo y una lista con dichos nombres
 Nota: inicialmente se había hecho un algoritmo de complejidad O(n2) con el response mensionado en el deseable, pero al momento de refactorizar se quitó dicho response para llegar con el plazo establecido
 -Borrado logico para el endpoint DELETE se deberia agregar un atributo enable y el delete lo deberia deshabilitar
