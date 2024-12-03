package fooddelivery.domain;

import fooddelivery.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class Delivered extends AbstractEvent {

    private Long id;
    private String address;
    private String customerPhoneNumber;
    private String orderId;
}
