package org.ej2.modelo

import java.time.LocalDate

class Pelicula(
    val titulo: String,
    val descripcion: String,
    val fechaEstreno: LocalDate,
    val directores: List<String>,
    val actores: List<String>,
    val rating: Float
        )

class PeliculaDTO(pelicula : Pelicula) {
    val titulo: String = pelicula.titulo
    val descripcion: String = pelicula.descripcion
    val fechaEstreno: LocalDate = pelicula.fechaEstreno
    val directores: List<String> = pelicula.directores
    val actores: List<String> = pelicula.actores
    val rating: Float = pelicula.rating
}