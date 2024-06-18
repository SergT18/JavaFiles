import java.util.Scanner;

public class Main {

    static Scanner console = new Scanner(System.in);


    public static void main(String[] args) throws Exception {

        boolean cycleIndicator = true;
        TextFile tfile = new TextFile(".\\files\\text.txt");


        while (cycleIndicator){
            printMenu();

            switch (inputMenuHandler()){
                case 1:
                    System.out.println("Считанные данные из файла:");
                    System.out.println(tfile.getReadingFromFileData());
                    break;
                case 2:
                    System.out.println("Отсортированные данные:");
                    System.out.println(tfile.sortData());
                    break;
                case 3:
                    System.out.println("Введите строку для записи\n");
                    String strForWriting = console.nextLine();
                    tfile.writeDataToFile(strForWriting);
                    break;
                case 4:
                    System.out.println("Выход из программы");
                    cycleIndicator = false;
                    break;
                default:
                    System.out.println("Пожалуйстай укажите правильный пункт меню!");

            }

        }

    }


    static void printMenu() {
        System.out.println("------------------------------");
        System.out.println("Выберите пункт меню");
        System.out.println("------------------------------");
        System.out.println("1. Прочитать данные из файла");
        System.out.println("2. Выполнить сортировку данных");
        System.out.println("3. Записать введенные данные в файл");
        System.out.println("4. Выход");
    }

    static int inputMenuHandler(){
        String selectedOption = console.nextLine();
        boolean isDigit = selectedOption.matches("[-+]?\\d+");

        if(!isDigit) {
            System.out.println("Вы ввели не число!");
            return 50;
        }

        return Integer.parseInt(selectedOption);
    }



}