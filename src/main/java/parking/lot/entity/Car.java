package parking.lot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    Long id;
    Long ownerId;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                '}';
    }
}
