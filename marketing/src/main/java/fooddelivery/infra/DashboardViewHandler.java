package fooddelivery.infra;

import fooddelivery.config.kafka.KafkaProcessor;
import fooddelivery.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DashboardViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setId(orderPlaced.getId());
            dashboard.setCookStatus("준비중");
            dashboard.setDeliveryStatus("준비중");
            // view 레파지 토리에 save
            dashboardRepository.save(dashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCooked_then_UPDATE_1(@Payload Cooked cooked) {
        try {
            if (!cooked.validate()) return;
            // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findById(
                cooked.getOrderId()
            );

            if (dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setCookStatus("조리완료");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDelivered_then_UPDATE_2(@Payload Delivered delivered) {
        try {
            if (!delivered.validate()) return;
            // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findById(
                Long.valueOf(delivered.getOrderId())
            );

            if (dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setDeliveryStatus("배송완료");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
