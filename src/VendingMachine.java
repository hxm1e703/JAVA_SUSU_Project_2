import java.util.ArrayList;

public class VendingMachine {
    private ArrayList<ProductSlot> mainArr; //ОСНОВНОЙ СПИСОК СЛОТОВ В МАШИНЕ
    private CashBox cashBox; //КОМПОЗИЦИЯ | КАССА
    private Terminal terminal; //КОМПОЗИЦИЯ | ТЕРМИНАЛ
    private SalesJournal journal; //КОМПОЗИЦИЯ | ЖУРНАЛ ПРОДАЖ

    //ИНИЦИАЛИЗАЦИЯ
    {
        mainArr = new ArrayList<>();
        cashBox = new CashBox();
        terminal = new Terminal();
        journal = new SalesJournal();
    }

    //ДОБАВИТЬ СЛОТ
    public void addNewSlot(String name, int count, int solar) {
        mainArr.add(new ProductSlot(name,solar,count, getLen() + 1));
    }

    //ПОЛУЧИТЬ ДЛИНУ СПИСКА
    public int getLen() {
        return mainArr.size();
    }
    // private ArrayList<ProductSlot> getArr() { return mainArr; }
    
    //ВЫПОЛНЕНИЕ КОМАНД В ЗАВИСИМОСТИ ОТ ВЫБРАННОГО ПУНКТА
    public void toDoCommand() {
        System.out.print("Выберите действие: ");
        int choose = terminal.getCommand();
        switch (choose) {
            case 1:
                terminal.printList(mainArr);
                break;
            case 2:
                cashBox.getOneRuble();
                break;
            case 3:
                cashBox.getTwoRuble();;
                break;
            case 4:
                cashBox.getFiveRuble();
                break;
            case 5:
                cashBox.getTenRuble();
                break;
            case 6:
                terminal.printList(mainArr);
                System.out.print("Выберите товар: ");
                int ch = terminal.getCommand();
                var slot = mainArr.get(ch-1);
                if (!cashBox.checkSum(ch, mainArr)) { System.out.println("Не хватает средств. \n"); break; }
                else if (!(slot.getCount() > 0)) { System.out.println("Товар закончился.\n"); break; }
                
                if (cashBox.Sent(slot.getSolar())) {
                    journal.getSlot(slot.getName(), slot.getId(), slot.getSolar(), cashBox.getLastMon());
                    // System.out.println(cashBox.getLastMon());
                    slot.sent();
                    System.out.println("Успешная покупка: " + slot.getName());
                };
                break;
            case 7:
                terminal.returnedMoney(cashBox);
                cashBox.returnMoney();
                break;
            case 8:
                // terminal.showCondition(cashBox);
                System.out.println(toString());
                break;
            case 9:
                System.out.println(journal.toString());
                break;
            case 0:
                cashBox.endProgram();
                System.exit(0);
                break;
            default:
                System.out.print("\nНеизвестная команда\n");
                break;
        }

        terminal.updateTerminal();
    }

    @Override
    public String toString() {
        String s = "";
        s = s + "Кол-во слотов: " + mainArr.size() + "\n\n";
        for (var ss : mainArr) {
            s = s + ss.toString() + "\n";
        }
        s = s + cashBox.toString() + "\n\n";

        return s;
    }

}