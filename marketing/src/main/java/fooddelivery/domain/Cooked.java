package fooddelivery.domain;

import fooddelivery.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class Cooked extends AbstractEvent {

    private Long id;
    private String foodId;
    private String status;
    private Long orderId;
}
