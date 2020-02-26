import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yunus Gedik
 */
class GraphSimplified {
    private final int numV;
    private final int numE;
    private final boolean[][] the_matrix;

    /**
     * Opens file ,constructs graph by using adjacency matrix method.
     * 
     * @param filename input.txt
     * @throws FileNotFoundException
     */
    GraphSimplified(final String filename) throws FileNotFoundException {
        final File file = new File(filename);
        final Scanner scanner = new Scanner(file);
        numV = scanner.nextInt();
        numE = scanner.nextInt();
        the_matrix = new boolean[numV][numV];

        for (int i = 0; i < numE; ++i) {
            int i1, i2;
            i1 = scanner.nextInt();
            i2 = scanner.nextInt();
            the_matrix[i1 - 1][i2 - 1] = true;
        }
    }

    /**
     * Calculates how much people are famous among all other people.
     * 
     * @return number of famous person
     */
    int celebrities() {
        int famous_count = 0;
        for (int i = 1; i <= numV; ++i) {
            if (isPopular(i)) {
                ++famous_count;
            }
        }
        return famous_count;
    }

    /**
     * Checks if a person is famous among all other people.
     * 
     * @param j vertex to be searched if it is famous or not
     * @return t/f
     */
    private boolean isPopular(final int j) {
        final boolean[] visited = new boolean[numV];
        final boolean[] fans = new boolean[numV];
        Arrays.fill(fans, false);

        for (int i = 0; i < numV; ++i) {
            Arrays.fill(visited, false);
            if (isPopular(i, j - 1, visited)) {
                fans[i] = true;
            }
        }

        for (int i = 0; i < numV; ++i) {
            // You do not have to be a fan of yourself.
            if (i != j - 1 && !fans[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if a person is a fan of another person.
     * 
     * @param i       vertex to search if he/she is a fan of j
     * @param j       vertex to be searched if it is famous or not
     * @param visited keep track of visited nodes to get rid of loops
     * @return t/f
     */
    private boolean isPopular(final int i, final int j, final boolean[] visited) {

        //Direct fan
        if(the_matrix[i][j]){
            return true;
        }

        //Indirect fan
        else {
            for(int k =0 ; k < numV ; ++k){
                if(the_matrix[i][k] && !visited[k]){
                    visited[k] = true;
                    if(isPopular(k,j,visited)) {
                        return true;
                    }
                }
            }
        }

        //Not a fan
        return false;
    }

}