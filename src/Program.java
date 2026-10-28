public class Program {
    public static void main(String[] args) {

        var machine = new VendingMachine();
        machine.addNewSlot("Вода", 2, 12);

        machine.addNewSlot("Сок", 4, 13);
        machine.addNewSlot("Шоколад", 8, 27);
        machine.addNewSlot("Вода", 16, 6);
        while (true) {
            machine.toDoCommand();
            
        }
    }
}