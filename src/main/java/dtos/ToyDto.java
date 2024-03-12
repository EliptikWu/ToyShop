package dtos;

import lombok.Builder;
import model.Category;
@Builder
public record ToyDto(Long id,
                     String name,
                     Double price,
                     Integer amount,
                     String category) {
}
