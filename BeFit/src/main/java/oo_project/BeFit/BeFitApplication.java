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

@ShellComponent
class terminalCmd{

	@Autowired
	@ShellMethod("MainMenu")
	public void welcome(TrainerDB trainerDB, MemberDB memberDB) {
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("Welcome! Are you a (n)ew or (r)eturning user? Or (e)xit");
			String userIn = input.nextLine();
			if (userIn.equals("n")) { //new user
				System.out.println("Are you a (t)rainer or a (m)ember?");
				userIn = input.nextLine();
				if (userIn.equals("t")) {//new trainer
					System.out.println("Hello new trainer, enter your name.");
					String trainerName = input.nextLine();
					trainerDB.addTrainer(trainerName);

				} if (userIn.equals("m")) {
					System.out.println("Hello new member, enter your name.");
					String memberName = input.nextLine();
					memberDB.addMember(memberName);
				}
			} if (userIn.equals("r")) {//returning user
				System.out.println("Are you a (t)rainer or a (m)ember?");
				userIn = input.nextLine();
				if (userIn.equals("t")) {//returning trainer
					System.out.println("Hello trainer, enter your name.");
					String trainerName = input.nextLine();
					//access db

				} if (userIn.equals("m")) {//returning member
					System.out.println("Hello member, enter your name.");
					String memberName = input.nextLine();
					//access db

				}
			}
			if (userIn.equals("e")) {//exit
				System.out.println("Goodbye");
				return;
			}
		}

	}
}