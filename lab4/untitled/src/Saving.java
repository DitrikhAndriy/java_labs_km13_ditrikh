import java.io.FileWriter;
import java.io.IOException;

public class Saving {
    public Saving(double[][] vectors, double[][] ortVectors) {
        try {
            FileWriter data = new FileWriter("data.txt");
            for (double[] v: vectors) {
                for (double e: v) {
                    data.write(e + " ");
                }
                data.write("\n");
            }
            data.write("\n");
            for (double[] v: ortVectors) {
                for (double e: v) {
                    data.write(e + " ");
                }
                data.write("\n");
            }
            data.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}