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
        setStatus("조리완료됨");

        Cooked cooked = new Cooked(this);
        cooked.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void 주문목록에추가(OrderPlaced orderPlaced) {
        
        Cook cook = new Cook();
        cook.setFoodId(orderPlaced.getItemId().toString()); // anti-corruption
        cook.setOrderId(orderPlaced.getId());
        cook.setStatus("수락됨");
        repository().save(cook);

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
