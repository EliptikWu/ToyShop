package service;

import dtos.ToyDto;
import model.Category;

import java.util.List;
import java.util.Map;

public interface ToyService {
    List<ToyDto> addToy(Long id, String name, double price, Integer amount, Category category);

    List<ToyDto> listToyByCategory(Category category);

    Map<Category, Integer> showByType() throws Exception;

    List<ToyDto> listAllToy();

    Map.Entry<Category, Long> maxToy() throws Exception;
    Category minToy() throws Exception;

    Object allPriceToy();

    List<ToyDto> expensiveToy();

    List<ToyDto> toyOrdered();

    Boolean verifyExist(String name);

    ToyDto toySearch(String name) throws Exception;

    List<ToyDto> toyDecrease(String toyName, int amount)throws Exception;
    List<ToyDto> toyIncrease(String toyName, int amount) throws Exception;



}
