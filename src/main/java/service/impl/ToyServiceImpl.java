package service.impl;

import dtos.ToyDto;
import mapping.ToyMapper;
import model.Category;
import model.Toy;
import service.ToyService;

import java.util.Comparator;
import java.util.List;

public class ToyServiceImpl implements ToyService {
    static List<Toy> toys;

    @Override
    public boolean addToy(ToyDto toy) {
        return false;
    }

    @Override
    public List<ToyDto> listToyByCategory(String category) {
        return toys.stream()
                .filter(e->e.getCategory().equals(Category.fromName(category)))
                .map(e-> ToyMapper.mapFrom(e))
                .toList();
    }

    @Override
    public List<ToyDto> listAllToy() {
        return toys.stream().map(e-> ToyMapper.mapFrom(e)).toList();
    }

    @Override
    public ToyDto expensiveToy() {
        return toys.stream()
                .max(Comparator.comparing(Toy::getPrice))
                .map(e-> ToyMapper.mapFrom(e)).orElseThrow();
    }
}
