package org.example.sylvio.repositories;

import org.example.sylvio.models.Carro;

import java.util.ArrayList;
import java.util.List;

public class CarrosRepository {
    private List<Carro> carros = new ArrayList<>();
    long lastId = 10;

    public CarrosRepository() {
        carros.add(new Carro(1, "Camaro", "Chevrolet", "2005"));
        carros.add(new Carro(2, "Mustang", "Ford", "2008"));
        carros.add(new Carro(3, "Corolla", "Toyota", "2012"));
        carros.add(new Carro(4, "Civic", "Honda", "2010"));
        carros.add(new Carro(5, "Fusion", "Ford", "2015"));
        carros.add(new Carro(6, "A3", "Audi", "2014"));
        carros.add(new Carro(7, "Model S", "Tesla", "2017"));
        carros.add(new Carro(8, "911", "Porsche", "2016"));
        carros.add(new Carro(9, "Accord", "Honda", "2013"));
        carros.add(new Carro(10, "Wrangler", "Jeep", "2019"));
    }

    public List<Carro> list(int limit, int offset) {
        if (offset > carros.size() - 1) {
            return new ArrayList<>();
        }
        if (limit > carros.size() && offset == 0) {
            return carros;
        } else {
            List<Carro> responseList = new ArrayList<Carro>();
            for (int i = offset; i < offset + limit;  i++) {
                responseList.add(carros.get(i));
            }
            return responseList;
        }
    }

    public Carro read(long id) {
        for (Carro carro : carros) {
            if (carro.getId() == id)
                return carro;
        }
        return null;
    }



    public Carro insert(Carro carro) {
        carro.setId(++lastId);
        carros.add(carro);
        return carro;
    }

    public Carro update(long id, Carro carro) {
        Carro newCarro = null;
        for (Carro oldCarro: carros) {
            if (oldCarro.getId() == id) {

                oldCarro.setNome(carro.getNome());
                oldCarro.setData(carro.getData());
                oldCarro.setFabricante(carro.getFabricante());
                newCarro = oldCarro;
                break;
            }
        }
        return newCarro;
    }
    public Carro upgrade(long id, Carro carro) {
        Carro newCarro = null;

        for (Carro oldCarro : carros)
        {
            if (oldCarro.getId() == id)
            {
                if (carro.getNome() != null) oldCarro.setNome(carro.getNome());
                if (carro.getFabricante() != null) oldCarro.setFabricante(carro.getFabricante());
                if (carro.getData() != null) oldCarro.setData(carro.getData());
                newCarro = new Carro(oldCarro.getId(), oldCarro.getNome(), oldCarro.getFabricante(), oldCarro.getData());
                newCarro = oldCarro;
                break;
            }
        }
        return newCarro;
    }

    public Carro delete(long id) {
        Carro delCarro = null;
        for (Carro carro : carros) {
            if (carro.getId() == id) {
                delCarro = carro;
                carros.remove(carro);
                break;
            }
        }
        return delCarro;
    }
}
