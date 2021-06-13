package az.code.unisubapp.utils;

import az.code.unisubapp.models.AppUser;
import az.code.unisubapp.models.Subscription;
import az.code.unisubapp.repository.AppUserRepository;
import az.code.unisubapp.repository.SubscriptionRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Component
public class CheckRepo {

    SubscriptionRepository subscriptionRepository;
    AppUserRepository appUserRepository;
    MailSender mailSender;


    public CheckRepo(SubscriptionRepository subscriptionRepository, AppUserRepository appUserRepository, MailSender mailSender) {
        this.subscriptionRepository = subscriptionRepository;
        this.appUserRepository = appUserRepository;
        this.mailSender = mailSender;
    }

    public void checkDate() {
        LocalDate after3Days = LocalDate.now().plusDays(3);
        List<AppUser> appUserList = appUserRepository.findAll();
        List<Subscription> subscriptions = subscriptionRepository.findAll();
        for (Subscription subscription : subscriptions) {
            if (after3Days.equals(subscription.getRenewDate())) {
                for (AppUser user : appUserList) {
                    if (user.getId().equals(subscription.getUserId())) {
                        sendMail(user.getEmail(), subscription.getItem());
                    }
                }
            }
        }
    }

    private void sendMail(String email, String subsName) {
        mailSender.sendNotificationEmail(email, " " + subsName);
    }

}
