package ua.epam.spring.hometask;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.logic.EventLogic;
import ua.epam.spring.hometask.logic.TicketLogic;
import ua.epam.spring.hometask.logic.ApplicationLogic;

import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by dish on 01.10.17.
 */
public class App {
    
    private Event event;
    private ApplicationLogic applicationLogic;
    private TicketLogic ticketLogic;
    private EventLogic eventLogic;
    
    public App(ApplicationLogic applicationLogic, TicketLogic ticketLogic, EventLogic eventLogic){
        this.applicationLogic = applicationLogic;
        this.ticketLogic = ticketLogic;
        this.eventLogic = eventLogic;
    }
    
    public static void main(String[] args) throws ParseException {
        ConfigurableApplicationContext applicatonContext = new ClassPathXmlApplicationContext(new String[] { "application-context.xml"});
        App application = (App) applicatonContext.getBean("app");
        application.start();
    }
    
    public void start() throws ParseException {
        String choice = "";
        Scanner sc = new Scanner(System.in);
        boolean switcher = true;
        while (switcher) {
            System.out.println("Write your Admin(A)/User(U):");
            choice = sc.nextLine();
            switch (choice) {
                case "A":
                case "a":
                    applicationLogic.processAdmin();
                    switcher = false;
                    break;
                case "U":
                case "u":
                    applicationLogic.processUser();
                    switcher = false;
                    break;
            }
        }
    }
    

}
