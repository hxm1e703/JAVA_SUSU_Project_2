import java.lang.String;
public class ProductSlot {
    //ПОЛЯ СЛОТА
    private int solar;
    private String name;
    private int count;
    private int id;
    //ИНИЦИАЛИЗАЦИЯ
    public ProductSlot(String name, int solar, int count, int id) {
        this.solar = solar;
        this.name = name;
        this.count = count;
        this.id = id;
    }
    
    public String getName() { return this.name; }
    public int getSolar() { return this.solar; }
    public int getCount() { return this.count; }
    public int getId() { return this.id; }

    public void sent() { this.count--; }

    @Override 
    public String toString() {
        return "ProductSlot: " + this.name 
        + "\nЦена: " + this.solar +
        "\nКол-во: " + this.count +
        "\nid: " + this.id + "\n";
    }
}
