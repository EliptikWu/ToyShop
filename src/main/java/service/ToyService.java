package service;

import dtos.ToyDto;
import model.Toy;

import java.util.List;

public interface ToyService {

    boolean addToy(ToyDto toy);

    List<ToyDto> listToyByCategory(String category);

    List<ToyDto> listAllToy();

    ToyDto expensiveToy();

}
