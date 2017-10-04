package ua.epam.spring.hometask;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.logic.EventLogic;
import ua.epam.spring.hometask.logic.TicketLogic;
import ua.epam.spring.hometask.logic.UserLogic;

import java.util.Scanner;

/**
 * Created by dish on 01.10.17.
 */
public class App {
    
    private Event event;
    private UserLogic userLogic;
    private TicketLogic ticketLogic;
    private EventLogic eventLogic;
    
    public App(UserLogic userLogic, TicketLogic ticketLogic, EventLogic eventLogic){
        this.userLogic = userLogic;
        this.ticketLogic = ticketLogic;
        this.eventLogic = eventLogic;
    }
    
    public static void main(String[] args) {
        ConfigurableApplicationContext applicatonContext = new ClassPathXmlApplicationContext(new String[] { "application-context.xml"});
        App application = (App) applicatonContext.getBean("app");
        application.start();
    }
    
    public void start(){
        String choice = "";
        Scanner sc = new Scanner(System.in);
        boolean switcher = true;
        while (switcher) {
            System.out.println("Write your Admin(A)/User(U):");
            choice = sc.nextLine();
            switch (choice) {
                case "A":
                case "a":
                    userLogic.processAdmin();
                    switcher = false;
                    break;
                case "U":
                case "u":
                    userLogic.processUser();
                    switcher = false;
                    break;
            }
        }
    }
    

}
