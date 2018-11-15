package oo_project.BeFit;

import java.util.Scanner;

public class Menu {
    public String newTrainer(TrainerDB trainerDB){
        Scanner input = new Scanner(System.in);
        System.out.println("Hello new trainer, enter your name.");
        String trainerName = input.nextLine();
        System.out.println("Enter a username.");
        String userName = input.nextLine();
        trainerDB.addTrainer(trainerName, userName);
        return userName;
    }
    public String newMember(MemberDB memberDB){
        Scanner input = new Scanner(System.in);
        System.out.println("Hello new member, enter your name.");
        String memberName = input.nextLine();
        System.out.println("Enter a username.");
        String userName = input.nextLine();
        memberDB.addMember(memberName, userName);
        return userName;
    }
    public Trainer returnTrainer(TrainerDB trainerDB, String trainerUsername){
        return trainerDB.retrieveTrainer(trainerUsername);

    }
    public Member returnMember(MemberDB memberDB, String memberUsername){
        return memberDB.retrieveMember(memberUsername);
    }

    public void logout(){
        System.out.println("Goodbye");
    }
    public void memberMenu(){
        System.out.println("Would you like to ");
        System.out.println("1. View punches ");
        System.out.println("2. Buy punches ");
        System.out.println("3. View schedule ");
        System.out.println("4. Book session ");
        System.out.println("5. Logout");
    }
    public void trainerMenu(){
        System.out.println("Would you like to ");
        System.out.println("1. View schedule ");
        System.out.println("2. Cancel session ");
        System.out.println("3. Logout");
    }

    public  int memberBuyPunch(MemberDB memberDB, Member m){
        System.out.println("How many would you like to buy?");
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
        int toBuy = Integer.parseInt(number);
        m.buyPunchPass(m.getPunchPass(), toBuy);
        memberDB.updateMember(m);
        return m.getPunchPass();

    }


}
