package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Cooked extends AbstractEvent {

    private Long id;
    private String foodId;
    private String status;
    private Long orderId;

    public Cooked(Cook aggregate) {
        super(aggregate);
    }

    public Cooked() {
        super();
    }
}
//>>> DDD / Domain Event
