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
    public static int longestSharedSubstring(String doc1, String doc2)
    {
        // Creates a dynamic programming table where memory[i][j] returns the number of identical characters up to index i in
        // doc1 and up to index j in doc2 between the two strings
        // The table has (n + 1) rows and columns because we need to represent where a string of length 0 is an option.
        int n1 = doc1.length();
        int n2 = doc2.length();
        int[][] memory = new int[n1 + 1][n2 + 1];

        return (int) (tabulateFunc(memory, n1 , n2 , doc1, doc2));
    }
    public static long tabulateFunc(int[][] memory, int index, int index2, String doc1, String doc2)
    {
        // There is exactly 0 identical characters between two strings where at least one is of length 0
        for(int i = 0; i < memory.length; i++)
        {
            memory[i][0] = 0;
        }
        for(int j = 0; j < memory[0].length; j++)
        {
            memory[0][j] = 0;
        }
        int result = 0;
        // i represents the current index in doc1
        // j represents the current index in doc 2
        for (int i = 1; i < memory.length; i++)
        {
            for(int j = 1; j < memory[0].length; j++)
            {
                // Goes - 1 since the for loops start at 1
                if(doc1.charAt(i - 1) == doc2.charAt(j - 1))
                {
                    // If the current characters match, add one to the previous LCS
                    result = 1 + memory[i - 1][j - 1];
                }
                else
                {
                    // If the characters don't match, take the maximum of the strings previous to the current and make that the length
                    result = Math.max(memory[i - 1][j], memory[i][j - 1]);
                }
                memory[i][j] = result;
            }
        }
        return memory[index][index2];
    }

}
