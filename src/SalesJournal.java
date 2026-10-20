import java.util.ArrayList;

public class SalesJournal {
    private int cnt;
    private ArrayList<Integer> numberSlot;
    private ArrayList<String> nameSlot;
    private ArrayList<Integer> monetarySlot;
    private ArrayList<Integer> solarSlot;
    {
        cnt = 0;
        numberSlot = new ArrayList<>();
        nameSlot = new ArrayList<>();
        monetarySlot = new ArrayList<>();
        solarSlot = new ArrayList<>();
    }

    public void getSlot(String name, int num,int solar, int mon) {
        this.cnt++;
        this.numberSlot.add(num);
        this.nameSlot.add(name);
        this.solarSlot.add(solar);
        this.monetarySlot.add(mon);
    }

    @Override 
    public String toString() {
        String s = "\nНомер по порядку|Номер слота|Название слота|Цена слота|Возвращенная сдача\n";
        for (int i = 0; i < cnt; i++) {
            s = s + (cnt+1) + this.numberSlot.get(i) + "     " + this.nameSlot.get(i) + 
            "     " + this.solarSlot.get(i) +
            "     " + this.monetarySlot.get(i) + "\n";
        }
        return s;
    }
}
