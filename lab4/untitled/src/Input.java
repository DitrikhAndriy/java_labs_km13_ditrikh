import java.util.Scanner;

public class Input {
    int n, m, flag;
    public Input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть кількість векторів: ");
        this.n = sc.nextInt();
        System.out.print("Введіть розмірність векторів: ");
        this.m = sc.nextInt();

        System.out.println("1 - отримати лише результат");
        System.out.println("2 - отримати список кроків що привели до результату");
        System.out.print("Ваш вибір: ");
        this.flag = sc.nextInt();
    }
}
