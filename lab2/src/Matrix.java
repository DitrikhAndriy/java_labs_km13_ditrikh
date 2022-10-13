import java.util.Arrays;
import java.util.Scanner;

class Matrix {
    double[][] matrix;
    int n, m;

    public Matrix() {
        matInit(0, 0);
    }

    public Matrix(int n) {
        matInit(n, n);
    }

    public Matrix(int n, int m) {
        matInit(n, m);
    }

    public Matrix(double[][] mtr) {
        matCopy(mtr);
    }

    public Matrix(Matrix mtr) {
        matCopy(mtr.matrix);
    }

    public Matrix(ImmutableMatrix mtr) {
        this.matCopy(mtr.matGetImmutableMatrix());
    }




    private void matInit(int n, int m) {
        this.n = n;
        this.m = m;
        if (this.n == 0 || this.m == 0)
            this.matrix = null;
        else
            this.matrix = new double[n][m];
    }

    public void matCopy(double[][] mat) {
        if (mat == null)
            this.matrix = null;
        else {
            matInit(mat.length, mat[0].length);
            for (int i = 0; i < mat.length; i++)
                for (int j = 0; j < mat[0].length; j++)
                    this.matrix[i][j] = mat[i][j];
        }
    }




    public void matEnter(int n) {
        matEnter(n, n);
    }

    public void matEnter(int n, int m) {
        matInit(n, m);
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.matrix[i][j] = sc.nextInt();
            }
        }
    }

    public void matEnter() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.matrix[i][j] = sc.nextInt();
            }
        }
    }




    public void matGenColumn(int n) {
        matGen(n, 1);
    }

    public void matGenRow(int n) {
        matGen(1, n);
    }

    public void matGen(int n) {
        matGen(n, n);
    }

    public void matGen(int n, int m) {
        matInit(n, m);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                this.matrix[i][j] = Math.round(Math.random() * 21 - 10);
    }

    public void matGen() {
        for (int i = 0; i < this.n; i++)
            for (int j = 0; j < this.m; j++)
                this.matrix[i][j] = Math.round(Math.random() * 21 - 10);
    }




    public void matGet() {
        if (this.n != 0 && this.m != 0) {
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < this.m; j++)
                    System.out.print(this.matrix[i][j] + " ");
                System.out.println();
            }
        }
    }

    public String matGetElem(int i, int j) {
        if (i >= this.n || j >= this.m || i < 0 || j < 0)
            throw new RuntimeException("Invalid index");
        return Double.toString(this.matrix[i][j]);
    }

    public String matGetRow(int i) {
        if (i >= this.n || i < 0)
            throw new RuntimeException("Invalid index");
        String res = "";
        for (int j = 0; j < this.m; j++)
            res += this.matrix[i][j] + " ";
        return res;
    }

    public String matGetColumn(int j) {
        if (j >= this.m || j < 0)
            throw new RuntimeException("Invalid index");
        String res = "";
        for (int i = 0; i < this.n; i++)
            res += this.matrix[i][j] + " ";
        return res;
    }

    public String matGetSize() {
        return this.n + "x" + this.m;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Matrix mx = (Matrix) o;
        return n == mx.n && m == mx.m && Arrays.deepEquals(matrix, mx.matrix);
    }




    public Matrix matMultiply(double[][] mx) {
        Matrix res = new Matrix(this.n, mx[0].length);
        if (this.m != mx.length) {
            System.out.println("Number of columns of the first matrix is not equal to the rows of the second");
            return res;
        }
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < mx[0].length; j++) {
                for (int k = 0; k < this.m; k++)
                    res.matrix[i][j] += this.matrix[i][k] * mx[k][j];
            }
        }
        return res;
    }

    public Matrix matMultiply(Matrix mx) {
        return matMultiply(mx.matrix);
    }

    public Matrix matMultiply(ImmutableMatrix mx) {
        return matMultiply(mx.matGetImmutableMatrix());
    }
}