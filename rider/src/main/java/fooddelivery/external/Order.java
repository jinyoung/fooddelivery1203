package fooddelivery.external;

import java.util.Date;
import lombok.Data;

@Data
public class Order {

    private Long id;
    private Long itemId;
    private String customerId;
    private String address;
}
