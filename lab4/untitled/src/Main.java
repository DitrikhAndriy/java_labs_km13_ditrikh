public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        if (input.flag == 1) {
            Vectors vectors = new Vectors(input.n, input.m);
            Vectors ortVectors = new Vectors(vectors);

            vectors.vectorsGet();
            ortVectors.ortVectorsGet();
        }
        else {
            VectorsWithSteps vectors = new VectorsWithSteps(input.n, input.m);
            VectorsWithSteps ortVectors = new VectorsWithSteps(vectors);

            vectors.vectorsGet();
            ortVectors.ortVectorsGet();
        }
    }
}