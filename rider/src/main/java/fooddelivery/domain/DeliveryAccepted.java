package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryAccepted extends AbstractEvent {

    private Long id;

    public DeliveryAccepted(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryAccepted() {
        super();
    }
}
//>>> DDD / Domain Event
