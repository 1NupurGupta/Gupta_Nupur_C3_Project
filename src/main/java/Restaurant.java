import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        LocalTime currentTime = getCurrentTime();
        if (currentTime.compareTo(this.closingTime) < 0 && currentTime.compareTo(this.openingTime) > 0) {
                 return true;
        }
        return false;

    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
        return menu;

    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }
    public void setOpenTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }
    public void setCloseTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }
    public int getFoodCost(String foodItem) {
        int foodPrice = 0;
        for(Item item: menu) {
            if(item.getName().equals(foodItem)) {
                foodPrice = item.getCost();
            }
        }
        return foodPrice;
    }
    public int getTotalOrderCost(String[] foodItemList) {
        int totalCost = 0;
        for(String order:foodItemList) {
            int cost = getFoodCost(order);
            totalCost= totalCost + cost;
        }
        return totalCost;
    }




}
