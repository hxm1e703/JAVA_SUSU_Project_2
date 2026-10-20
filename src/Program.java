public class Program {
    public static void main(String[] args) {

        var machine = new VendingMachine();
        machine.addNewSlot("Вода", 2, 15);

        machine.addNewSlot("Сок", 4, 20);
        machine.addNewSlot("Шоколад", 8, 30);
        machine.addNewSlot("Вода", 16, 15);
        while (true) {
            machine.toDoCommand();
            
        }
    }
}