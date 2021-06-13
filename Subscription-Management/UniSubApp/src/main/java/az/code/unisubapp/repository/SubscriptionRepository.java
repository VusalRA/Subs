package az.code.unisubapp.repository;

import az.code.unisubapp.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

//    List<Subscription> getSubscriptionByRenewDate();

}
