/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author YOUR NAME HERE
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */
    public static int longestSharedSubstring(String doc1, String doc2) {

        // TODO Complete this function to return the length of the longest shared substring.
        int n1 = doc1.length();
        int n2 = doc2.length();
        int[][] array = new int[n1 + 1][n2 + 1];
        return recursiveFunc(array, (int) (0.5 * n1), (int) (0.5*n2));
        // Fill with 0s at index 0 for each
    }
    public static int recursiveFunc(int[][] array, int index, int index2)
    {
        if(index == 0 || index2 == 0)
        {
            return 0;
        }
    }
}
