package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Delivered extends AbstractEvent {

    private Long id;
    private String address;
    private String customerPhoneNumber;
    private String orderId;

    public Delivered(Delivery aggregate) {
        super(aggregate);
    }

    public Delivered() {
        super();
    }
}
//>>> DDD / Domain Event
