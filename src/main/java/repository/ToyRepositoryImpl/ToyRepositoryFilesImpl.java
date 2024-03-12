package repository.ToyRepositoryImpl;

import model.Toy;
import repository.Repository;

import java.util.List;

public class ToyRepositoryFilesImpl implements Repository<Toy> {
    @Override
    public List<Toy> list() {
        System.out.println("listando desde archivos");
        return null;
    }

    @Override
    public Toy byId(int id) {
        return null;
    }

    @Override
    public void save(Toy toy) {
        System.out.println("Estoy llamando implementacion de archivos");
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Toy toy) {

    }
}
