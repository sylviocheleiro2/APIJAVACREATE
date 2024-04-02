package org.example.sylvio.controllers;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import org.example.sylvio.models.Carro;
import org.example.sylvio.repositories.CarrosRepository;

public class CarrosController {

    CarrosRepository carrosRepository = new CarrosRepository();
    Gson gson = new Gson();

    public String getAll(Request req, Response res) {
        int limit = 5;
        int offset = 0;

        String queryLimit = req.queryParams("limit");
        if (queryLimit != null) {
            try {
                limit = Integer.parseInt(queryLimit);
                if (limit > 30)
                    limit = 30;
            } catch (NumberFormatException exception) {
            }
        }

        String queryOffset = req.queryParams("offset");
        if (queryOffset != null)
            offset = Integer.parseInt(queryOffset);

        var carros = carrosRepository.list(limit, offset);
        return response(carros, res);
    }

    public String read(Request req, Response res) {
        var idStr = req.params("id");
        var id = Long.parseLong(idStr);
        Carro carro = carrosRepository.read(id);
        if (carro != null) {
            return response(carro, res);
        } else {
            res.status(404);
            return "Carro não encontrado";
        }
    }

    public  String insert(Request req, Response res) {
        var reqBody = req.body();
        var body = gson.fromJson(reqBody, Carro.class);
        Carro carro = carrosRepository.insert(body);
        return response(carro, res);
    }

    public  String update(Request req, Response res) {
        var idStr = req.params("id");
        var id = Long.parseLong(idStr);

        var bodyStr = req.body();
        var body = gson.fromJson(bodyStr, Carro.class);
        Carro carro = carrosRepository.update(id, body);

        if(carro != null) {
            return response(carro, res);
        } else {
            res.status(404);
            return "Carro não encontrado";
        }
    }

    public  String upgrade(Request req, Response res) {
        var idStr = req.params("id");
        var id = Long.parseLong(idStr);

        var bodyStr = req.body();
        var body = gson.fromJson(bodyStr, Carro.class);
        Carro carro = carrosRepository.upgrade(id, body);

        if(carro != null) {
            return response(carro, res);
        } else {
            res.status(404);
            return "Carro não encontrado";
        }
    }

    public  String delete(Request req, Response res) {
        var idStr = req.params("id");
        var id = Long.parseLong(idStr);

        Carro carro = carrosRepository.delete(id);
        if(carro != null) {
            return response(carro, res);
        } else {
            res.status(404);
            return "Carro não encontrado";
        }
    }

    private String response(Object body, Response res) {
        String bodyJson = gson.toJson(body);
        res.type("application/json");
        return bodyJson;
    }
}
