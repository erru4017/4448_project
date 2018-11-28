package oo_project.BeFit;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;


@SpringBootApplication
@EnableMongoRepositories
public class BeFitApplication {
	public static void main(String[] args) {
		SpringApplication.run(BeFitApplication.class, args);
	}
}
/**
 * Terminal command main menu*/
@ShellComponent
class terminalCmd{

	@Autowired
	@ShellMethod("MainMenu")
	/** Main menu
	 * @param trainerDB The trainer database
	 * @param memberDB The member database
	 * @param sessionDB The session database
	 */
	public void welcome(TrainerDB trainerDB, MemberDB memberDB, SessionDB sessionDB) {
		Menu menu = new Menu();
		SessionFactory f = new SessionFactory();
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("Welcome! Are you a (n)ew or (r)eturning user? Or (e)xit");
			String userIn = input.nextLine();
			if (userIn.equals("n")) { //new user
				System.out.println("Are you a (t)rainer or a (m)ember?");
				userIn = input.nextLine();
				if (userIn.equals("t")) {//new trainer
					String trainerUsername = menu.newTrainer(trainerDB);
					menu.trainer(trainerDB, sessionDB, f, trainerUsername);
				}if (userIn.equals("m")) {
					String memberUsername = menu.newMember(memberDB);
					menu.member(trainerDB, memberDB, sessionDB, f, memberUsername);
				}
			} if (userIn.equals("r")) {//returning user
				System.out.println("Are you a (t)rainer or a (m)ember?");
				userIn = input.nextLine();
				if (userIn.equals("t")) {//returning trainer
					//access db
					System.out.println("Hello trainer, enter your username.");
					String trainerUsername = input.nextLine();
					menu.trainer(trainerDB, sessionDB, f, trainerUsername);
				} if (userIn.equals("m")) {//returning member
					//access db
					System.out.println("Hello member, enter your username.");
					String memberUsername = input.nextLine();
					menu.member(trainerDB, memberDB, sessionDB, f, memberUsername);
				}
			}
			if (userIn.equals("e")) {//exit
				menu.logout();
				return;
			}
		}
	}
}