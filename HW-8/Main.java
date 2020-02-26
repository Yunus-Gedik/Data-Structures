import java.io.FileNotFoundException;

public class Main {

    public static void main(final String[] args) throws FileNotFoundException {
        final GraphSimplified gs = new GraphSimplified("input.txt");
        System.out.printf("%d\n",gs.celebrities());
    }
}
