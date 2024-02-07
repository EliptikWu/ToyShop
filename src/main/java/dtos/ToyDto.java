package dtos;

import model.Category;

public record ToyDto(Long id,
                     String name,
                     Double price,
                     Integer amount,
                     Category category) {
}
