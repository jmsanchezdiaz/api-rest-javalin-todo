package org.example

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import org.example.controllers.TasksController
import org.example.exceptions.NotFoundException

fun main(args: Array<String>) {
    val app = Javalin.create().start(5000)

    app.routes{
       crud("tasks/{id}", TasksController)
       path("tasks/{id}") {
            put { ctx -> TasksController.update(ctx, ctx.pathParam("id"))}
            path("/done") {
                put(TasksController::checkTask)
            }
            path("/undone") {
                put(TasksController::uncheckTask)
            }
        }
    }

    app.exception(NotFoundException::class.java) { _, ctx  -> ctx.status(404)}
    app.exception(RuntimeException::class.java) { _, ctx -> ctx.status(500)}

    app.error(404) { ctx -> ctx.result("No se ha encontrado el recursos que buscabas")}
    app.error(500) { ctx -> ctx.result("Ha ocurrido un error en el servidor")}
}

