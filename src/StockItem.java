/**
 * Created by dev on 16/02/2016.
 */
public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;  // initial stock amount 0
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setPrice(double price) {
        if(price > 0.0) {
            this.price = price;
        }
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if(newQuantity >=0) {
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if(obj == this) { //seems to start with referential equality of the object vs the field where it is checking
            // if the same object is being pointed to. This would mean the same memory location. In this scenario, the
            // field is checking for itself.
            return true;
        }

        if((obj == null) || (obj.getClass() != this.getClass())) {
            return false; //if object has no value or is not of the same class as field, then false
        }

        String objName = ((StockItem) obj).getName(); //if the object and field have the same name field
        // in addition to being on the same class, then return true, they are the same. This single field comparison
        // only works when there is no redundancy of product name. There are not two companies called pringles making
        // 'pizzalicious' flavored chips. But for people, we may need additional field checks so be certain the person
        // is the same, such as first name, last name, DOB or MRN
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    } //overriding of hashcode method. seems hashcode is
    // created based on value of name field + a prime number we've arbitrarily selected

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.compareTo");
        if(this == o) {
            return 0;
        }

        if(o != null) {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price;
    }
}
