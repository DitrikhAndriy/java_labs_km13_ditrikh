import java.util.Scanner;
import java.util.regex.Pattern;

class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        String[] nums = transform(numbers);
        StringBuilder neg = new StringBuilder();
        int summa = 0;
        int n;
        for (String num : nums) {
            try {
                n = Integer.parseInt(num);
            }
            catch (Exception e) {
                throw new RuntimeException("Invalid input format");
            }
            if (n < 0)
                neg.append(n).append(" ");
            else if (n <= 1000)
                summa += n;
        }
        if (neg.length() > 0)
            throw new RuntimeException("Negative numbers are not allowed: " + neg);
        return summa;
    }

    private String[] transform(String numbers) {
        StringBuilder regex = new StringBuilder("\\\\n|,");
        if (numbers.startsWith("//")) {
            if (numbers.indexOf("\n") == numbers.length() - 1)
                return new String[]{"0"};
            String sym = "()[]{}+*.$?^|";
            if (numbers.charAt(3) == '\\' && numbers.charAt(4) == 'n') {
                regex.append("|").append(numbers.charAt(2));
                numbers = numbers.substring(5);
            }
            else {
                String[] delim = numbers.substring(3, numbers.indexOf("\\n") - 1).split("]\\[");
                regex.append("|");
                for (String d : delim){
                    for (int i = 0; i < d.length(); i++){
                        if (sym.contains(String.valueOf(d.charAt(i))))
                            regex.append("\\").append(d.charAt(i));
                        else
                            regex.append(d.charAt(i));
                    }
                    regex.append("|");
                }
                regex = new StringBuilder(regex.substring(0, regex.length() - 1));
                numbers = numbers.substring(numbers.indexOf("\\n") + 2);
            }
        }
        Pattern pattern = Pattern.compile(regex.toString());
        return pattern.split(numbers);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String str = sc.nextLine();
        StringCalculator calculator = new StringCalculator();
        try {
            System.out.println(calculator.add(str));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}