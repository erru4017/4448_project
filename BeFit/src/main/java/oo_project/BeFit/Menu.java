package oo_project.BeFit;
import java.util.Scanner;
/**
 * Menu class holds functions for the main menu
 */
public class Menu {
    /**Create a new trainer who is not in the database yet
    * @param trainerDB the trainer database*/
    public String newTrainer(TrainerDB trainerDB){
        Scanner input = new Scanner(System.in);
        System.out.println("Hello new trainer, enter your name.");
        String trainerName = input.nextLine();
        System.out.println("Enter a username.");
        String userName = input.nextLine();
        trainerDB.addTrainer(trainerName, userName);
        return userName;
    }
    /**Create a new member who is not in the database yet
    * @param memberDB the member database
    * */
    public String newMember(MemberDB memberDB){
        Scanner input = new Scanner(System.in);
        System.out.println("Hello new member, enter your name.");
        String memberName = input.nextLine();
        String userName;
        while(true) {
            System.out.println("Enter a username.");
            userName = input.nextLine();
            if (!memberDB.exists(userName)){
                memberDB.addMember(memberName, userName);
                break;
            }else{
                System.out.println("That username is taken.");
            }
        }
        return userName;
    }
    /**
     *Retrieve a trainer from the database
    * @param trainerDB the trainer database
    * @param trainerUsername the trainer's username
    * @return trainer object with that username
     */
    public Trainer returnTrainer(TrainerDB trainerDB, String trainerUsername){
        return trainerDB.retrieveTrainer(trainerUsername);

    }
    /**Retrieve a member from the database
    * @param memberDB the member database
    * @param memberUsername the member's username
    * @return member object with that username
     */
    public Member returnMember(MemberDB memberDB, String memberUsername){
        return memberDB.retrieveMember(memberUsername);
    }
    /**Print the logout text*/
    public void logout(){
        System.out.println("Goodbye");
    }
    /**Print the menu options for a trainer*/
    public void trainerMenu(){
        System.out.println("Would you like to ");
        System.out.println("1. View schedule ");
        System.out.println("2. Cancel session ");
        System.out.println("3. Logout");
    }
    /**Print the menu options for a member*/
    public void memberMenu(){
        System.out.println("Would you like to ");
        System.out.println("1. View punches ");
        System.out.println("2. Buy punches ");
        System.out.println("3. View schedule ");
        System.out.println("4. Book session ");
        System.out.println("5. Logout");
    }
    /**Function for a member to buy more punch passes
    * @param memberDB the member database
    * @param m Member object for current member who is booking a session
    * */
    public int memberBuyPunch(MemberDB memberDB, Member m){
        System.out.println("How many would you like to buy?");
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
        int toBuy = Integer.parseInt(number);
        m.buyPunchPass(m.getPunchPass(), toBuy);
        memberDB.updateMember(m);
        return m.getPunchPass();
    }
    /**Function for a member to book a private session
    * @param m Member object for current member who is booking a session
    * @param trainerDB the trainer database
    * @param sessionDB the session database
    * */
    public void memberBookSession(Member m, TrainerDB trainerDB, SessionDB sessionDB, SessionFactory f){
        Scanner input = new Scanner(System.in);
        System.out.println("Which type of class: (y)oga, (c)ycling, (k)ickboxing");
        String sessionType = input.nextLine();

        while(true) {
            System.out.println("Select a Trainer:");
            trainerDB.printAllTrainers();
            String trainerName = input.nextLine();

            System.out.println("Select a day: ");
            System.out.println("(Mon)day, (Tues)day, (Wed)nesday, (Thurs)day, (Fri)day, (Sat)urday, (Sun)day");
            String day = input.nextLine();

            System.out.println("Select a time: ");
            System.out.println("The earliest time is (6)am and latest time is (5)pm");
            String time = input.nextLine();
            if (!sessionDB.exists(trainerName+day+time)){
                Session s = f.getSession(sessionType, trainerName, m.getName(), day, time);
                sessionDB.addSession(s);
                break;
            }else{
                System.out.println(trainerName + " is unavailable at that time.");
            }
        }


    }
    /**Function for a trainer to cancel sessions
    * @param trainerDB the trainer database
    * @param sessionDB the session database
    * */
    public void trainerCancelSession(TrainerDB trainerDB, SessionDB sessionDB){
        Scanner input = new Scanner(System.in);

        System.out.println("Which session would you like to cancel?");
        System.out.println("Select a Trainer:");
        trainerDB.printAllTrainers();
        String trainerName = input.nextLine();

        System.out.println("Select a day: ");
        System.out.println("(Mon)day, (Tues)day, (Wed)nesday, (Thurs)day, (Fri)day, (Sat)urday, (Sun)day");
        String day = input.nextLine();
        System.out.println("Select a time: ");
        String time = input.nextLine();
        sessionDB.removeSession(trainerName+day+time);
    }
    /**Function for the menu for a trainer
     * @param trainerDB the trainer database
     * @param sessionDB the session database
     * @param f the session factory
     * @param trainerUsername the username of the trainer, to access their info from the database
     * */
    public void trainer(TrainerDB trainerDB, SessionDB sessionDB, SessionFactory f, String trainerUsername) {
        Scanner input = new Scanner(System.in);
        Trainer t = returnTrainer(trainerDB, trainerUsername);
        System.out.println("Hello " + t.getName());
        String userIn;
        while (true) {
            trainerMenu();
            userIn = input.nextLine();
            //view schedule
            if (userIn.equals("1")) {
                System.out.println("Current Schedule: ");
                sessionDB.printAllSessions();
            }
            //cancel session
            if (userIn.equals("2")) {
                trainerCancelSession(trainerDB, sessionDB);
            }
            if (userIn.equals("3")) {
                logout();
                return;
            }
        }
    }

    /**Function for the menu for a trainer
     * @param memberDB the trainer database
     * @param sessionDB the session database
     * @param f the session factory
     * @param memberUsername the username of the trainer, to access their info from the database
     * */
    public void member(TrainerDB trainerDB, MemberDB memberDB, SessionDB sessionDB, SessionFactory f, String memberUsername) {
        Scanner input = new Scanner(System.in);
        String userIn;
        Member m = returnMember(memberDB, memberUsername);
        System.out.println("Hello " + m.getName());
        while (true) {
            memberMenu();
            userIn = input.nextLine();
            //view punches
            if (userIn.equals("1")) {
                System.out.println("You have " + m.getPunchPass() + " punches.");
            }
            //buy punches
            if (userIn.equals("2")) {
                int punch = memberBuyPunch(memberDB, m);
                System.out.println("You now have " + punch + " punches.");
            }
            //view schedule
            if(userIn.equals("3")){
                System.out.println("Current Schedule: ");
                sessionDB.printAllSessions();
            }
            //book session
            if (userIn.equals("4")){
                if (m.getPunchPass() > 0){
                    memberBookSession(m, trainerDB, sessionDB, f);
                }else{
                    System.out.println("You do not have any punches left, please buy more.");
                }
            }
            if (userIn.equals("5")) {
                logout();
                return;
            }
        }
    }

    }
