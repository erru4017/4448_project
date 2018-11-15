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
					Trainer t = menu.returnTrainer(trainerDB, trainerUsername);
					System.out.println("Hello " + t.getName());
					while (true) {
						menu.trainerMenu();
						userIn = input.nextLine();
						//view schedule
						if(userIn.equals("1")){
							System.out.println("Current Schedule: ");
							sessionDB.printAllSessions();
						}
						//cancel session
						if(userIn.equals("2")){
							//TODO cancel a session by deleting from the database
							System.out.println("cancel");
						}
						if (userIn.equals("3")) {
							menu.logout();
							return;
						}
					}
				}if (userIn.equals("m")) {
					String memberusername = menu.newMember(memberDB);
					Member m = menu.returnMember(memberDB, memberusername);
					System.out.println("Hello " + m.getName());
					while (true) {
						menu.memberMenu();
						userIn = input.nextLine();
						//view punches
						if (userIn.equals("1")) {
							System.out.println("You have " + m.getPunchPass() + " punches.");
						}
						//buy punches
						if (userIn.equals("2")) {
							int punch = menu.memberBuyPunch(memberDB, m);
							System.out.println("You now have " + punch + " punches.");
						}
						//view schedule
						if (userIn.equals("3")){
							System.out.println("Current Schedule: ");
							sessionDB.printAllSessions();
						}
						//book session
						if (userIn.equals("4")){
							System.out.println("Which type of class: (y)oga, (c)ycling, (k)ickboxing");
							String sessionType = input.nextLine();
							System.out.println("Select a Trainer:");
							//print out trainer names
							String trainerName = input.nextLine();
							System.out.println("Select a day: ");
							//print out days of the week
							String day = input.nextLine();
							System.out.println("Select a time: ");
							String _time = input.nextLine();
							int time = Integer.parseInt(_time);
							Session s = f.getSession(sessionType, trainerName, m.getName(), day, time);
							sessionDB.addSession(s.getType(), s.getTrainer(), m.getName(), s.getDay(), s.getTime());

						}

						if (userIn.equals("5")) {
							menu.logout();
							return;
						}

					}

				}
			} if (userIn.equals("r")) {//returning user
				System.out.println("Are you a (t)rainer or a (m)ember?");
				userIn = input.nextLine();
				if (userIn.equals("t")) {//returning trainer
					//access db
					System.out.println("Hello trainer, enter your username.");
					String trainerUsername = input.nextLine();
					Trainer t = menu.returnTrainer(trainerDB, trainerUsername);
					System.out.println("Hello " + t.getName());
					while (true) {
						menu.trainerMenu();
						userIn = input.nextLine();
						//view schedule
						if(userIn.equals("1")){
							System.out.println("Current Schedule: ");
							sessionDB.printAllSessions();

						}
						//cancel session
						if(userIn.equals("2")){
							//TODO cancel a session by deleting from the database
							System.out.println("cancel");

						}

						if (userIn.equals("3")) {
							menu.logout();
							return;
						}
					}


				} if (userIn.equals("m")) {//returning member
					//access db
					System.out.println("Hello member, enter your username.");
					String memberUsername = input.nextLine();
					Member m = menu.returnMember(memberDB, memberUsername);
					System.out.println("Hello " + m.getName());
					while (true) {
						menu.memberMenu();
						userIn = input.nextLine();
						//view punches
						if (userIn.equals("1")) {
							System.out.println("You have " + m.getPunchPass() + " punches.");
						}
						//buy punches
						if (userIn.equals("2")) {
							int punch = menu.memberBuyPunch(memberDB, m);
							System.out.println("You now have " + punch + " punches.");
						}
						//view schedule
						if(userIn.equals("3")){
							System.out.println("Current Schedule: ");
							sessionDB.printAllSessions();
						}
						//book session
						if (userIn.equals("4")){
							System.out.println("Which type of class: (y)oga, (c)ycling, (k)ickboxing");
							String sessionType = input.nextLine();
							System.out.println("Select a Trainer:");
							//print out trainer names
							String trainerName = input.nextLine();
							System.out.println("Select a day: ");
							//print out days of the week
							String day = input.nextLine();
							System.out.println("Select a time: ");
							String _time = input.nextLine();
							int time = Integer.parseInt(_time);
							Session s = f.getSession(sessionType, trainerName, m.getName(), day, time);
							sessionDB.addSession(s.getType(), s.getTrainer(), m.getName(), s.getDay(), s.getTime());
						}
						if (userIn.equals("5")) {
							menu.logout();
							return;
						}
					}
				}
			}
			if (userIn.equals("e")) {//exit
				menu.logout();
				return;
			}
		}
	}
}