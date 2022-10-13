class Main {
    public static void main(String[] args) {
        Matrix A = new Matrix(3, 3);
        A.matGen();
        A.matGet();
        System.out.println();
        ImmutableMatrix B = new ImmutableMatrix(A);
        B.matGet();
        System.out.println();

        //A.matEnter(2, 5, 2);
        //A.matGet();

        //Matrix A = new Matrix();
        //A.matGen(3, 3);
        //A.matGet();
        //System.out.println();
        //Matrix B = new Matrix();
        //B.matGen(3, 3);
        //B.matGet();
        //System.out.println();
        //Matrix C = A.matMultiply(B);
        //C.matGet();
        //System.out.println();
    }
}
