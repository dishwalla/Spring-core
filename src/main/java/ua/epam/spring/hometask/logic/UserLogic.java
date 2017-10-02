package ua.epam.spring.hometask.logic;

import ua.epam.spring.hometask.IdGenerator;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dish on 01.10.17.
 */
public class UserLogic {
    private UserServiceImpl userService;
    private IdGenerator idGenerator;
    
    public UserServiceImpl getUserService() {
        return userService;
    }
    
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
    
    public IdGenerator getIdGenerator() {
        return idGenerator;
    }
    
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
    
    public void showUsersMenu() {
        System.out.println("1. Register" );
        System.out.println("2. View events" );
        System.out.println("3. Get ticket prices" );
        System.out.println("4. Buy tickets " );
        System.out.println("5. Exit " );
    }
    
    public void showAdminsMenu() {
        System.out.println("1. View purchased tickets" );
        System.out.println("2. Enter events" );
        System.out.println("3. Exit " );
    }
    public void processUser() throws NumberFormatException {
        String choice = "";
        List<String> options = new ArrayList<>();
        options.add("1");
        options.add("2");
        options.add("3");
        options.add("4");
        options.add("5");
        Scanner sc = new Scanner(System.in);
        while (!choice.equals("5")){
            showUsersMenu();
            choice = sc.nextLine();
            if (!options.contains(choice)){
                System.out.println("There's no such item, try again");
            }
            switch (choice) {
                case "1":
                    registerUser();
                    break;
                case "2":
                    viewEvents();
                    break;
                case "3":
                    getTicketPrices();
                    break;
                case "4":
                    buyTickets();
                    break;
            }
        }
        
    }
    
    public void processAdmin() {
        String choice = "";
        List<String> options = new ArrayList<>();
        options.add("1");
        options.add("2");
        options.add("3");
        Scanner sc = new Scanner(System.in);
        while (!choice.equals("3")){
            showAdminsMenu();
            choice = sc.nextLine();
            if (!options.contains(choice)){
                System.out.println("There's no such item, try again");
            }
            switch (choice) {
                case "1":
                    viewPurchasedTickets();
                    break;
                case "2":
                    enterEvents();
                    break;
            }
        }
    }
    
    public void registerUser(){
        User user = new User();
        String fisrtName = "";
        String lastName = "";
        String email = "";
    
        System.out.printf("Write your name: ");
        Scanner sc_name = new Scanner(System.in);
        if (sc_name != null){
            fisrtName = sc_name.nextLine();
            user.setFirstName(fisrtName);
        }
        System.out.printf("Write your surname: ");
        Scanner sc_lastName = new Scanner(System.in);
        if (sc_lastName != null){
            lastName = sc_lastName.nextLine();
            user.setLastName(lastName);
        }
        System.out.printf("Write your email: ");
        Scanner sc_email = new Scanner(System.in);
        if (sc_name != null){
            email = sc_email.nextLine();
            user.setEmail(email);
        }
        user.setId((long) IdGenerator.getNextUserId());
        userService.save(user);
    }
    
    
    public void viewEvents(){}
    public void getTicketPrices(){}
    public void buyTickets(){}
    public void viewPurchasedTickets(){}
    public void enterEvents(){}
    
}
