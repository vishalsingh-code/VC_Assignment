package VintageCircleAssignment.Part3;

import VintageCircleAssignment.Part3.ServiceClass.ServiceClass;

import java.util.Scanner;


public class MainClass {
    public static void main(String[] args) throws Exception {

//      Taking Input
        Scanner sc =new Scanner(System.in);
        System.out.println("Please Enter data in this format 'Rewards: 26Mar2009, 27Mar2009, 28Mar2009'");
        String input = sc.nextLine();

//      Creating Object of Service Class.
        ServiceClass service=new ServiceClass();
//      Data is added to HashMap
        service.SetHotels();

//
        String hotel =service.UserInput(input);
        System.out.println(hotel);
    }
}
