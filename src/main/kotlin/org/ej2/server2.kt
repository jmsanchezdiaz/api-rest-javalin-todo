package org.ej2

import io.javalin.Javalin
import org.ej2.controllers.PeliculaController

fun main() {
    val app = Javalin.create().start(5000)

    app.get("searchBy", PeliculaController::getSearchedMovies)
    app.get("ranking", PeliculaController::getRatedMovies)
}