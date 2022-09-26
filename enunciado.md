## Ejercicio 2: IMDB

Programar una API REST que permita buscar dentro un gran catálogo de películas.

Película:

* Título
* Descripción
* Fecha de estreno
* Directores
* Actores
* Rating

Protocolo

> No se pedirá un protocolo de CRUD, con lo cual puede crear el catálogo dentro de la aplicación.
> Los directores y actores pueden ser listas de _strings_, no es necesario modelarlo.

* `GET /searchBy?title={title}&description={description}&directors={director1,director2,...}&actors={actor1,actor2,...}`
    - Busca dentro del catálogo
    - Algunos ítems pueden tener contenido vacío
    - Internamente se deberían aplicar un criterio de "relevancia"
        * Primero los que matchean con todo
        * Luego los que matchean por título
        * Luego los que matchean por descripción
        * etc...
* `GET /ranking?min_rating={rating}&limit={limit}`
    - Trae las películas ordenadas por rating descendiente (de mayor a menor)
    - Opcionalmente se puede definir un valor mínimo de rating que deben cumplir las películas
    - Opcionalmente se puede definir un límite de películas a traer