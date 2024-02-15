package test;

import dtos.ToyDto;
import model.Category;
import org.junit.Before;
import org.junit.Test;
import service.impl.ToyServiceImpl;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ToyServiceImplTest {
    private ToyServiceImpl service;

    @Before
    public void setup(){
        service = new ToyServiceImpl();
    }

    @Test
    public void addToy_test() throws Exception {
        Long id = Long.valueOf(1);
        String name = "Terreneitor";
        Double price = Double.valueOf(30.00);
        Integer amount = 4;
        Category category = Category.Unisex;
        ToyDto toyToAdd = new ToyDto(id,name,price,amount,category);
        List<ToyDto> expected = Collections.singletonList(toyToAdd);
        List<ToyDto> result = service.addToy(toyToAdd);
        assertEquals(expected,result);
    }
    @Test
    void listToyByCategory_test() throws Exception {
    }
    @Test
    void listAllToy() throws Exception {
    }
    @Test
    void maxToy() throws Exception {
    }
    @Test
    void minToy() throws Exception {
    }
    @Test
    void allPriceToy() throws Exception{
    }
    @Test
    void expensiveToy() throws Exception{
    }
    @Test
    void toyOrdered() throws Exception{
    }
    @Test
    void toySearch() throws Exception{
    }
    @Test
    void toyDecrease() throws Exception{
    }
    @Test
    void toyIncrease() throws Exception{
    }
}
