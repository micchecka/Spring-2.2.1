package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Ferrari", 1);
      Car car2 = new Car("Buggati", 2);
      Car car3 = new Car("MсLarren", 3);
      Car car4 = new Car("Koenigsegg", 4);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru", car1);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru", car2);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru", car3);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru", car4);



      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);


      User user5 = userService.getUserByCar("Ferrari", 1);

         System.out.println("User by car:");
         System.out.println("Id = " + user5.getId());
         System.out.println("First Name = " + user5.getFirstName());
         System.out.println("Last Name = " + user5.getLastName());
         System.out.println("Email = " + user5.getEmail());

      context.close();
   }
}
