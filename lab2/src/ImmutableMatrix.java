import java.util.Arrays;
import java.util.Objects;

final class ImmutableMatrix {
    private final double[][] matrix;
    private final int n, m;

    public ImmutableMatrix() {
        this(0, 0);
    }

    public ImmutableMatrix(int n) {
        this(n, n);
    }

    public ImmutableMatrix(int n, int m) {
        this.n = n;
        this.m = m;
        this.matrix = new double[n][m];
    }

    public ImmutableMatrix(double[][] mtr) {
        this(mtr.length, mtr[0].length);
        matCopy(mtr);
    }

    public ImmutableMatrix(Matrix mtr) {
        this(mtr.n, mtr.m);
        matCopy(mtr.matrix);
    }

    public ImmutableMatrix(ImmutableMatrix mtr) {
        this(mtr.n, mtr.m);
        matCopy(mtr.matrix);
    }




    public void matCopy(double[][] mat) {
        if (mat != null)
            for (int i = 0; i < mat.length; i++)
                for (int j = 0; j < mat[0].length; j++)
                    this.matrix[i][j] = mat[i][j];
    }

    public void matCopy(Matrix mat) {
        matCopy(mat.matrix);
    }

    public void matCopy(ImmutableMatrix mat) {
        matCopy(mat.matrix);
    }




    public double[][] matGetImmutableMatrix() {
        return this.matrix;
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
            res += this.matrix[i][j];
        return res;
    }

    public String matGetColumn(int j) {
        if (j >= this.m || j < 0)
            throw new RuntimeException("Invalid index");
        String res = "";
        for (int i = 0; i < this.n; i++)
            res += this.matrix[i][j];
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
        ImmutableMatrix mx = (ImmutableMatrix) o;
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