package service.impl;

import dtos.ToyDto;
import mapping.ToyMapper;
import model.Category;
import model.Toy;
import repository.ToyRepository;
import repository.repositoryImpl.ToyRepositoryImpl;
import service.ToyService;

import java.util.*;
import java.util.stream.Collectors;

public class ToyServiceImpl implements ToyService {
    private List<ToyDto> toys;
    public ToyServiceImpl() {
        ToyRepository repoCustomer = new ToyRepositoryImpl();
        toys = repoCustomer.getAllToys();
    }

    @Override
    public List<ToyDto> addToy(Long id, String name, double price, Integer amount, Category category) {
        ToyDto newToy = new ToyDto(id, name, price, amount, category);
        toys.add(newToy);
        return toys;
    }
    @Override
    public List<Toy> listToyByCategory(int category) {
        return toys.stream()
                .filter(e->e.equals(Category.fromName(category)))
                .map(e-> ToyMapper.mapFrom(e))
                .toList();
    }
    @Override
    public Map.Entry<Category,Integer> maxToy() throws Exception {
        return sort().entrySet().stream().reduce((first,second)-> second).orElse(null);
    }
    @Override
    public Map.Entry<Category,Integer> minToy() throws Exception {
        return sort().entrySet().stream().findFirst().orElse(null);
    }

    @Override
    public List<ToyDto> listAllToy() {
        return toys;
    }

    @Override
    public List<ToyDto> allPriceToy(){
        return toys.stream()
                .mapToDouble(ToyMapper::getPrice)
                .sum().toList();
    }

    @Override
    public List<ToyDto> expensiveToy() {
        Map<String, ToyDto> expensiveProduct = new HashMap<>();
        for (ToyDto toy : toys) {
            expensiveProduct
                    .merge(String.valueOf(toy.category()), toy,
                            (e, r) -> e.price() > r.price() ? e : r);
        }
        return new ArrayList<>(expensiveProduct.values());
    }

    @Override
    public ToyDto toySearch(String name) {
        if(verifyExist(name)){
            List<ToyDto> list = toys.stream().filter(toyList-> Objects.equals(toy.getName(), name))
                    .findFirst().stream().map(ToyMapper::mapFrom).toList();
            return list.getFirst();
        }
    }
    @Override
    public Boolean verifyExist(String name) {
        return toys.stream().anyMatch(e -> e.getName().equalsIgnoreCase(name));
    }
    @Override
    public List<Toy> toyDecrease(Toy toy, int amount) {
        toys.stream().filter(toy1 -> Objects.equals(toy.getName(),toy.getName()))
                .peek(Toy -> {
                    if(toy.getAmount()>0){
                        toy.setAmount(toy.getAmount() - amount);
                    } else if (toy.getAmount()==0) {
                        toys.remove(toy);
                    }
                })
                .findFirst();
        return toys.stream().map(ToyMapper::mapFrom).toList();
    }

    @Override
    public List<Toy> increase(Toy toy, int amount) {
        toys.stream().filter(toy1 -> Objects.equals(toy.getName(),toy.getName()))
                .peek(Toy -> toy.setAmount(toy.getAmount()+amount))
                .findFirst();
        return toys.stream().map(ToyMapper::mapFrom).toList();
    }

    @Override
    public List<ToyDto> toyOrdered(){
        return toys.stream()
                .sorted(Comparator.comparingInt(ToyMapper::getAmount))
                .collect(Collectors.toList());
    }





}
