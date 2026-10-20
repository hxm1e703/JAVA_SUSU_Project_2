import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Terminal {
    private static ArrayList<String> mainText; //ОСНОВНОЙ ТЕКСТ ТЕРМИНАЛА
    private int choosen; //ВЫБРАННЫЙ ПУНКТ
    private Scanner scanner = new Scanner(System.in); //СКАННЕР ДЛЯ СЧИТЫВАНИЯ КОМАНДЫ
    //ИНИЦИАЛИЗАЦИЯ
    {
        mainText = new ArrayList<>(List.of("Показать товары" , //
                        "Внести 1 рубль" , //
                        "Внести 2 рубля" , //
                        "Внести 5 рублей" , //
                        "Внести 10 рублей" , //
                        "Купить товар" , //
                        "Вернуть внесенные монеты" , //
                        "Показать состояние кассы" ,
                        "Посмотреть журнал продаж", //
                        "Завершить работу"));
        updateTerminal();
    }
    //ОБНОВЛЕНИЕ ТЕРМИНАЛА (ОСНОВНОЙ ТЕКСТ)
    public void updateTerminal() {
        for (int i = 0; i < 9; i++) {
            System.out.println(i+1 + " " + mainText.get(i));
        }
        System.out.println("0" + " " + mainText.getLast());
    }
    //ВВОД КОММАНДЫ
    public int getCommand() {
        try {
            choosen = scanner.nextInt();
        } 
        catch (InputMismatchException ex) {
            System.out.println("Error: " + ex);
        }
        return choosen;
    }
    //СОСТОЯНИЕ КАССЫ
    public void showCondition(CashBox c) {
        System.out.printf("%nМонет с номиналом 1: %d%n", c.retOneRuble());
        System.out.printf("Монет с номиналом 2: %d%n", c.retTwoRuble());
        System.out.printf("Монет с номиналом 5: %d%n", c.retFiveRuble());
        System.out.printf("Монет с номиналом 10: %d%n", c.retTenRuble());

        System.out.printf("Сумма внесённых монеты: %d%n%n", c.retSumNow());
        
    }
    //СПИСОК ПРОДУКТОВ|СЛОТОВ
    public void printList(ArrayList<ProductSlot> mainArr) {
        System.out.printf("%n%-5s %-20s %-12s %-10s%n",
            "№", "Название товара", "Цена, руб.", "Количество"
        );

        for (ProductSlot p : mainArr) {
            System.out.printf("%-5d %-20s %-12d %-10d%n",
                    p.getId(), p.getName(), p.getSolar(), p.getCount());
        }

        System.out.println();
    }

    public void returnedMoney(CashBox c) {
        System.out.printf("%nВозвращённые монеты: %n");
        System.out.println(c.getInfoMoneyNow());
    }
}