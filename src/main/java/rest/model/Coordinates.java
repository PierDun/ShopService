package rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Coordinates {
    long id;
    private float x;
    private Double y; //Максимальное значение поля: 144, Поле не может быть null
}