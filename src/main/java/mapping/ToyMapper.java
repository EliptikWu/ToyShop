package mapping;

import dtos.ToyDto;
import model.Toy;

import java.util.List;

public class ToyMapper {
    public static ToyDto mapFrom(Toy source){
        return new ToyDto(source.getId(),
                source.getName(),
                source.getPrice(),
                source.getAmount(),
                source.getCategory());
    }

    public static Toy mapFrom(ToyDto source){
        return new Toy(source.id(),
                source.name(),
                source.price(),
                source.amount(),
                source.category());
    }


    public static List<ToyDto> mapFrom(List<Toy> source){
        return source.stream()
                .map(ToyMapper::mapFrom)
                .toList();

    }
    public static List<Toy> mapFromDto(List<ToyDto> source){
        return source.parallelStream()
                .map(ToyMapper::mapFrom)
                .toList();
    }


}
