package service;

import dtos.ToyDto;
import model.Category;
import model.Toy;

import java.util.List;
import java.util.Map;

public interface ToyService {
    List<ToyDto> addToy(Long id, String name, double price, Integer amount, Category category);

    List<Toy> listToyByCategory(int category);

    List<ToyDto> listAllToy();
    Map.Entry<Category,Integer> maxToy() throws Exception;
    Map.Entry<Category,Integer> minToy() throws Exception;

    List<ToyDto> allPriceToy();

    List<ToyDto> expensiveToy();
    ToyDto toySearch(String name);
    List<ToyDto> toyOrdered();

    Boolean verifyExist(String name);

    List<Toy> toyDecrease(Toy toy, int amount);
    List<Toy> toyIncrease(Toy toy, int amount);

}
