package fooddelivery.domain;

import fooddelivery.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String customerId;
    private Long itemId;
    private String address;
}
