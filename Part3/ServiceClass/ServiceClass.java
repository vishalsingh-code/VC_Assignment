package VintageCircleAssignment.Part3.ServiceClass;

import VintageCircleAssignment.Part3.ModelClass.ModelClass;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ServiceClass {

    public HashMap<String, List<Integer>> CoconutValley = new HashMap<>();
    public HashMap<String, List<Integer>> AakulamLake = new HashMap<>();
    public  HashMap<String, List<Integer>> Velibeach = new HashMap<>();


    private static int CocountValleyRating;
    private static int AakulamLekeRating;
    private static int VelibeachRating;

    ModelClass modelClass=new ModelClass();

    public void SetHotels() {
        setCoconutValley();
        setAakulamLake();
        setVelibeach();
    }
//  Method to add data (price),(Rating) in HashMap for Regular & Reward user on the basis of Weekdays and Weekends.
    public void setCoconutValley() {
        List<Integer> CocountValleyRewords = new ArrayList<>();
        CocountValleyRewords.add(800);
        CocountValleyRewords.add(800);

        List<Integer> CocountValleyRegugar = new ArrayList<>();
        CocountValleyRegugar.add(1100);
        CocountValleyRegugar.add(900);


        CoconutValley.put("Rewards", CocountValleyRewords);
        CoconutValley.put("Regular", CocountValleyRegugar);
        CocountValleyRating = 3;



    }


    public void setAakulamLake() {
        List<Integer> AuakalamLakeRewords = new ArrayList<>();
        AuakalamLakeRewords.add(1100);
        AuakalamLakeRewords.add(500);

        List<Integer> AuakalamRewgular = new ArrayList<>();
        AuakalamRewgular.add(1600);
        AuakalamRewgular.add(600);

        AakulamLake.put("Rewards", AuakalamLakeRewords);
        AakulamLake.put("Regular", AuakalamRewgular);
        AakulamLekeRating = 4;

    }

    public void setVelibeach() {

        List<Integer> VelibeachRewaords = new ArrayList<>();
        VelibeachRewaords.add(1000);
        VelibeachRewaords.add(400);

        List<Integer> VelibeachRewgular = new ArrayList<>();
        VelibeachRewgular.add(2200);
        VelibeachRewgular.add(1500);

        Velibeach.put("Rewards", VelibeachRewaords);
        Velibeach.put("Regular", VelibeachRewgular);
        VelibeachRating=5;



    }

// Taking input from User and setting date & CustomerType.
    public String UserInput(String input) throws Exception {
        // Regular: 16Mar2009, 17Mar2009(tue), 18Mar2009(wed)
        String arr[] = input.split(",");
        String CustomerType = "";
        if (arr.length > 0) {
            String tempArray[] = arr[0].split(":");
            CustomerType = tempArray[0];
            arr[0] = tempArray[1];
        }
        String Hotels = minCostHotels(CustomerType, arr);
        return Hotels;

    }


// Calculating Number of weekdays, weekends, price and day on the basis of User input.
    private String minCostHotels(String customerType, String[] arr)throws Exception{
        int numweekdays = 0;
        int numweekends = 0;
        int CocountValleyCost=0;
        int AakulamLakeCost=0;
        int VelibeachCost=0;

        for (int i = 0; i < arr.length; i++) {
            String dates = arr[i];

            SimpleDateFormat formatter2=new SimpleDateFormat("ddMMMyyyy");
            Date date2=formatter2.parse(dates);

//            System.out.println(dates);
//            System.out.println("\t"+date2);

            String dayName=date2.toString();

            String arraysofday[]= dayName.split(" ");

            for (int j = 0; j <1; j++) {

                if (arraysofday[0].equalsIgnoreCase("Sat") ||arraysofday[0].equalsIgnoreCase("Sun")){
                    numweekends++;
                }else {
                    numweekdays++;
                }
            }
        }

        List<Integer> valueofCocountVelly = CoconutValley.get(customerType);
        List<Integer> valueofAakulamlake = AakulamLake.get(customerType);
        List<Integer> valuesofVeliBeach = Velibeach.get(customerType);
        try {
            CocountValleyCost = numweekdays *  valueofCocountVelly.get(0) + numweekends * valueofCocountVelly.get(1);
            AakulamLakeCost = numweekdays * valueofAakulamlake.get(0) + numweekends * valueofAakulamlake.get(1);
            VelibeachCost = numweekdays * valuesofVeliBeach.get(0) + numweekends * valuesofVeliBeach.get(1);
        }catch (Exception e){
            System.out.println(e);
        }

        String hotel = minCost(CocountValleyCost, AakulamLakeCost, VelibeachCost);

        System.out.println( "CocountvalleyPrice:"+CocountValleyCost+"\n" + "AakulamLakePrice:" + AakulamLakeCost +"\n"+ "VelibeachPrice:" + VelibeachCost);

        return hotel;
    }

// Selecting Hotel on Rating when Price is tie.
    private String minCost(int cocountValleyCost, int aakulamLakeCost, int velibeachCost) {

        int minCost = Math.min(cocountValleyCost, Math.min(aakulamLakeCost, velibeachCost));

        if (minCost == cocountValleyCost && minCost == aakulamLakeCost) {

            return aakulamLakeCost > cocountValleyCost ? "AakulamLake" : "cocountValley";
        }
        else if (minCost == cocountValleyCost && minCost == velibeachCost) {

            return cocountValleyCost > velibeachCost ? "CocountValley" : "VeliBeach";
        }
        else if (minCost == aakulamLakeCost && minCost == velibeachCost) {

            return aakulamLakeCost > velibeachCost ? "AakulamLake" : "Velibeach";
        }
        else {
//   Returning Cheapest Hotel
            if (minCost == cocountValleyCost) {
                int rating = CocountValleyRating;
                System.out.println(rating+"(rating)");

                return "CoconutValley is Cheapest" ;


            } else if (minCost == aakulamLakeCost) {

                int rating =AakulamLekeRating;
                System.out.println(rating+"(rating)");
                return "AakulamLake is Cheapest";

            } else {

                int rating = VelibeachRating;
                System.out.println(rating+"(rating)");
                return "VeliBeachCost is Cheapest";
            }
        }


    }

}
