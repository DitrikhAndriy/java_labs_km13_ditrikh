import java.util.Scanner;

public class Vectors {
    double[][] vectors;
    int n;
    int m;

    public Vectors(int n, int m) {
        Scanner sc = new Scanner(System.in);
        VectorsInit(n, m);
        System.out.println("Задайте систему векторів:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("vectors[" + i + "]" + "[" + j + "] = ");
                this.vectors[i][j] = sc.nextDouble();
            }
        }
    }

    public Vectors(Vectors vectorsToOrt) {
        this.n = vectorsToOrt.n;
        this.m = vectorsToOrt.m;
        this.vectors = new double[n][m];

        for (int i = 0; i < n; i++) {
            double[] res = vectorsToOrt.vectors[i];
            for (int j = 0; j < i; j++) {
                double[] temp = multi(mult(vectorsToOrt.vectors[i], vectors[j])/mult(vectors[j], vectors[j]), vectors[j]);
                res = ret(res, temp);
            }
            this.vectors[i] = res;
        }
    }

    private void VectorsInit(int n, int m) {
        this.n = n;
        this.m = m;
        this.vectors = new double[n][m];
    }

    public double mult(double[] first, double[] second) {
        double result = 0;
        for (int i = 0; i < first.length; i++)
            result += first[i] * second[i];
        return result;
    }

    public double[] multi(double num, double[] array) {
        double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++)
            result[i] = array[i] * num;
        return result;
    }

    public double[] ret(double[] first, double[] second) {
        double[] result = new double[first.length];
        for (int i = 0; i < first.length; i++) {
            result[i] = first[i] - second[i];
        }
        return result;
    }



    public void vectorsGet() {
        System.out.println("\nЗадана система векторів:");
        for (int i = 0; i < this.n; i++) {
            System.out.print("v1 = (");
            for (int j = 0; j < this.m - 1; j++) {
                System.out.print(this.vectors[i][j] + ", ");
            }
            System.out.print(this.vectors[i][this.m - 1]);
            System.out.print(")");
            System.out.println();
        }
    }

    public void ortVectorsGet() {
        System.out.println("\nОртогоналізована система векторів:");
        for (int i = 0; i < this.n; i++) {
            System.out.print("u1 = (");
            for (int j = 0; j < this.m - 1; j++) {
                System.out.print(this.vectors[i][j] + ", ");
            }
            System.out.print(this.vectors[i][this.m - 1]);
            System.out.print(")");
            System.out.println();
        }
    }
}
