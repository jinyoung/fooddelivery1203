package fooddelivery.domain;

import fooddelivery.StoreownerApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cook_table")
@Data
//<<< DDD / Aggregate Root
public class Cook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String foodId;

    private String status;

    private Long orderId;

    @PostPersist
    public void onPostPersist() {}

    public static CookRepository repository() {
        CookRepository cookRepository = StoreownerApplication.applicationContext.getBean(
            CookRepository.class
        );
        return cookRepository;
    }

    //<<< Clean Arch / Port Method
    public void finishCook() {
        //implement business logic here:

        Cooked cooked = new Cooked(this);
        cooked.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void 주문목록에추가(OrderPlaced orderPlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
