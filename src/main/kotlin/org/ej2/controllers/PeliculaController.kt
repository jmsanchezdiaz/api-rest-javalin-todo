package org.ej2.controllers

import io.javalin.http.Context
import org.ej2.modelo.Pelicula
import org.ej2.modelo.PeliculaDTO
import java.time.LocalDate
import java.util.*

object PeliculaController {
    val movies: List<Pelicula> =
        listOf(
            Pelicula(
                "The Batman",
                "El caballero de la noche tiene que limpiar las calles de ciudad gotica.",
                LocalDate.now(),
                listOf("Matt reeves"),
                listOf("Robert Pattinson", "Zoe Kravitz", "Paul Dano"),
                9.8f
            ),
            Pelicula(
                "Joker",
                "Historia de origen del joker",
                LocalDate.now(),
                listOf("Todd Phillips"),
                listOf("Joaquin Phoenix", "Robert DeNiro"),
                9.8f
            ),

        )

    fun getSearchedMovies(ctx: Context) {
        val titleBy = ctx.queryParam("title")
        val descriptionBy = ctx.queryParam("description")


        //Si no se provee de un query params devolver todas?? o lanzar una excepcion
        var filteredMovies: List<Pelicula> = movies;

        if(!Objects.isNull(titleBy)) {
            filteredMovies = filteredMovies.filter { mov -> mov.titulo.equals(titleBy) }
        }

        if(!Objects.isNull(descriptionBy)) {
            filteredMovies = filteredMovies.filter { mov -> mov.descripcion == descriptionBy }
        }


        filteredMovies.forEach { pel -> println(pel.titulo)}
        ctx.json(filteredMovies.map { mov -> PeliculaDTO(mov)})
    }

    fun getRatedMovies(ctx: Context) {

    }
}
