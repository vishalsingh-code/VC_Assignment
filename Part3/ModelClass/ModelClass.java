package VintageCircleAssignment.Part3.ModelClass;

public class ModelClass {
    int Bed;
    int Breakfast;
    int Rating;
    int Regprice;
    int RewPrice;
    String Hotelname;
    String Regular;
    String Rewards;

    public ModelClass() {
    }

    public ModelClass(int bed, int breakfast, String hotelname) {
        Bed = bed;
        Breakfast = breakfast;
        Hotelname = hotelname;
    }

    public int getBed() {
        return Bed;
    }

    public void setBed(int bed) {
        Bed = bed;
    }

    public int getBreakfast() {
        return Breakfast;
    }

    public void setBreakfast(int breakfast) {
        Breakfast = breakfast;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public int getRegprice() {
        return Regprice;
    }

    public void setRegprice(int regprice) {
        Regprice = regprice;
    }

    public int getRewPrice() {
        return RewPrice;
    }

    public void setRewPrice(int rewPrice) {
        RewPrice = rewPrice;
    }

    public String getHotelname() {
        return Hotelname;
    }

    public void setHotelname(String hotelname) {
        Hotelname = hotelname;
    }

    public String getRegular() {
        return Regular;
    }

    public void setRegular(String regular) {
        Regular = regular;
    }

    public String getRewards() {
        return Rewards;
    }

    public void setRewards(String rewards) {
        Rewards = rewards;
    }

}