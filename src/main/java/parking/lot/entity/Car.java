package parking.lot.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Car {

    Long id;
    @NonNull
    Long carId;
    @NonNull
    String carName;
    @NonNull
    Long ownerId;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                '}';
    }
}
