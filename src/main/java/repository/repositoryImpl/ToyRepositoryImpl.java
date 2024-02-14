package repository.repositoryImpl;

import dtos.ToyDto;
import mapping.ToyMapper;
import model.Category;
import model.Toy;
import repository.ToyRepository;

import java.util.ArrayList;
import java.util.List;

public class ToyRepositoryImpl implements ToyRepository {
    private List<Toy> toys;

    public List<Toy> getToys() {
        return toys;
    }
    public void setToys(List<Toy> toys) {
        this.toys = toys;
    }
    public ToyRepositoryImpl() {
        toys = new ArrayList<>();

        toys.add(new Toy(1L, "Lego",30.0,1, Category.Unisex));
        toys.add(new Toy(2L, "Furby",300.0,5, Category.Unisex));
        toys.add(new Toy(3L, "Popsi",31.0,3, Category.Unisex));

    }
    @Override
    public List<ToyDto> getAllToys() {
        return ToyMapper.mapFrom(toys);
    }


}
