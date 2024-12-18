package fooddelivery.domain;

import fooddelivery.RiderApplication;
import fooddelivery.external.Order;
import fooddelivery.external.OrderService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Delivery_table")
@Data
//<<< DDD / Aggregate Root
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerPhoneNumber;

    private String orderId;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Embedded
    private Address address;

    @PostPersist
    public void onPostPersist() {}

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    //<<< Clean Arch / Port Method
    public void confirmDelivered() {
        setStatus(Status.DELIVERED);

        Delivered delivered = new Delivered(this);
        delivered.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void accept(AcceptCommand acceptCommand) {
        setStatus(Status.STARTED);

        DeliveryAccepted deliveryAccepted = new DeliveryAccepted(this);
        deliveryAccepted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void 배달목록에추가(Cooked cooked) {
        //implement business logic here:

        /** Example 1:  new item        */
        Delivery delivery = new Delivery();

        OrderService orderService = RiderApplication.applicationContext.getBean(OrderService.class);
        Order order = orderService.getOrder(cooked.getOrderId());
        Address address = new Address();
        address.setCity(order.getAddress());
        delivery.setAddress(address);

        repository().save(delivery);

 

        /** Example 2:  finding and process
        
        repository().findById(cooked.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
