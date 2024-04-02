package org.example.sylvio;
import org.example.sylvio.controllers.CarrosController;

import static spark.Spark.*;




public class Main {
    private static final int port = 2131;
    private static final CarrosController carrosController = new CarrosController();


    public static void main(String[] args) {
        port(port);
        get("/", (req, res) -> "Server Ligado!");

        path("/carros", () -> {
            get("", carrosController::getAll);
            get("/:id", carrosController::read);
            post("", carrosController::insert);
            put("/:id", carrosController::update);
            patch("/:id", carrosController::upgrade);
            delete("/:id", carrosController::delete);
        });

    }
}