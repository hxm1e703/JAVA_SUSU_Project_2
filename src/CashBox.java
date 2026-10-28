import java.util.ArrayList;

public class CashBox {
    private int countOneRuble;
    private int countTwoRuble;
    private int countFiveRuble;
    private int countTenRuble;
    private int sum;
    private int sumNow;
    private int oneNow;
    private int twoNow;
    private int fiveNow;
    private int tenNow;
    private ArrayList<Integer> listMon;

    public CashBox() {
        countOneRuble = 1;
        countFiveRuble = 0;
        countTenRuble = 19;
        countTwoRuble = 1;

        listMon = new ArrayList<>();

        sum = countFiveRuble * 5 + 
        countOneRuble + 
        countTenRuble * 10 + 
        countTwoRuble * 2;
        sumNow = 0;
    }

    private void thisSum() {
        sumNow = oneNow + twoNow * 2 + fiveNow * 5 + tenNow * 10;
    }

    public void getOneRuble() { oneNow++; thisSum(); }
    public void getTwoRuble() { twoNow++; thisSum(); }
    public void getFiveRuble() { fiveNow++; thisSum(); }
    public void getTenRuble() { tenNow++; thisSum(); }

    public int retOneRuble() { return countOneRuble; }
    public int retTwoRuble() { return countTwoRuble; }
    public int retFiveRuble() { return countFiveRuble; }
    public int retTenRuble() { return countTenRuble; }

    public int retSum() { return sum; }
    public int retSumNow() { return sumNow; }

    public boolean checkSum(int ch, ArrayList<ProductSlot> mainArr) {
        return mainArr.get(ch-1).getSolar() <= sumNow;
    }

    public boolean Sent(int solar) {
        if (solar == sumNow) {
            sum += sumNow;
            sumNow = 0;
            countFiveRuble += fiveNow;
            countOneRuble += oneNow;
            countTenRuble += tenNow;
            countTwoRuble += twoNow;
            fiveNow = 0; twoNow = 0; tenNow = 0; oneNow = 0;
            listMon.add(0);
            // System.out.println("Successful");
            return true;
        } else {
            String ss = findMonetary(solar);
            if (!ss.isEmpty()) {
                System.out.println(ss);
                listMon.add(sumNow-solar);
                sumNow = 0;
                return true;
            } else {
                System.out.println("Сдачи нет.");
                return false;
            }
            
        }
    }

    public void returnMoney() {
        sumNow = 0;
        fiveNow = 0; twoNow = 0; tenNow = 0; oneNow = 0;
    }

    public void endProgram() {
        System.out.printf("Возвращаю номиналы монет%n1 - %d%n2 - %d%n5 - %d%n10 - %d%n",
            oneNow, twoNow, fiveNow, tenNow); 
        fiveNow = 0; twoNow = 0; tenNow = 0; oneNow = 0;
    }

    public String getInfoMoneyNow() {
        return new String("Монет с номиналом 1: " + oneNow + "\n" + 
            "Монет с номиналом 2: " + twoNow + "\n" + 
            "Монет с номиналом 5: " + fiveNow + "\n" + 
            "Монет с номиналом 10: " + tenNow + "\n"
        );
    }

    private void setNow(int solar) {
        sum += solar;
        countFiveRuble += fiveNow;
        countOneRuble += oneNow;
        countTenRuble += tenNow;
        countTwoRuble += twoNow;
        fiveNow = 0; twoNow = 0; tenNow = 0; oneNow = 0;
    }

    public String findMonetary(int solar) {
        int s = sumNow - solar;
        String ss = "";
        int need;
        if (s >= 10 && (countTenRuble + tenNow) >= (s/10)) {
            need = s / 10;
            
            if (tenNow >= need) { tenNow -= need; }
            else { countTenRuble -= tenNow; countTenRuble -= (need - tenNow); }
            s %= 10;
            ss += ("Возвращено номинал 10: " + need + "\n");
            System.out.println(tenNow);
            if (s == 0) { setNow(solar);return ss; }
        }
        if (s >= 5 && (countFiveRuble + fiveNow) >= (s/5)) {
            need = s / 5;
            if (fiveNow >= need) { fiveNow -= need; }
            else { countFiveRuble -= fiveNow; countFiveRuble -= (need - fiveNow); }
            s %= 5;
            ss += ("Возвращено номинал 5: " + need + "\n");
            if (s == 0) { setNow(solar);return ss; }
        } 
        if (s >= 2 && (countTwoRuble + twoNow) >= (s/2)) {
            need = s / 2;
            if (twoNow >= need) { twoNow -= need; }
            else { countTwoRuble -= twoNow; countTwoRuble -= (need - twoNow); }
            s %= 2;
            ss += ("Возвращено номинал 2: " + need + "\n");
            if (s == 0) { setNow(solar);return ss; }
        }
        if (s >= 1 && (countOneRuble + oneNow) >= (s)) {
            need = s;
            if (oneNow >= need) { oneNow -= need; }
            else { countOneRuble -= oneNow; countOneRuble -= (need - oneNow); }
            s %= 1;
            ss += ("Возвращено номинал 1: " + need + "\n");
            if (s == 0) { setNow(solar);return ss; }
        }
        if (s == 0) {
            System.out.println("Successful " + solar);
            setNow(solar);
            return ss;
        }
        else return "";
    }

    public int getLastMon() { return listMon.getLast(); }

    @Override 
    public String toString() {
        return "\nCashbox: " +
        "\nСумма внесённых монет: " + sumNow +
        "\nСумма в кассе: " + sum + 
        "\nНоминал 10: " + countTenRuble +
        "\nНоминал 5: " + countFiveRuble +
        "\nНоминал 2: " + countTwoRuble +
        "\nНоминал 1: " + countOneRuble;
        
    }

}