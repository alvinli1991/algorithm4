package section1;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Exercise1345 Tester.
 *
 * @author Alvin Li
 * @version 1.0
 * @since <pre>Mar 25, 2020</pre>
 */
public class Exercise1345Test {


    /**
     * Method: isOverflow(String[] input)
     */
    @Test
    public void testIsOverflow() throws Exception {
        String[] input1 = "0 1 2 - - -".split("\\s");
        assertThat(Exercise1345.isOverflow(input1), equalTo(false));

        String[] input2 = "0 1 2 - - - 3 4 5 - - 6 - - -".split("\\s");
        assertThat(Exercise1345.isOverflow(input2), equalTo(true));

        String[] input3 = "0 - - 1 2 -".split("\\s");
        assertThat(Exercise1345.isOverflow(input3), equalTo(true));
    }

    /**
     * Method: canPermutationGenerated(String[] input)
     */
    @Test
    public void testCanPermutationGenerated() throws Exception {
        String[] input1 = "4 3 2 1 0 9 8 7 6 5".split("\\s");
        assertThat(Exercise1345.canPermutationGenerated(input1), equalTo(true));

        String[] input2 = "4 6 8 7 5 3 2 9 0 1".split("\\s");
        assertThat(Exercise1345.canPermutationGenerated(input2), equalTo(false));

        String[] input3 = "2 5 6 7 4 8 9 3 1 0".split("\\s");
        assertThat(Exercise1345.canPermutationGenerated(input3), equalTo(true));

        String[] input4 = "4 3 2 1 0 5 6 7 8 9".split("\\s");
        assertThat(Exercise1345.canPermutationGenerated(input4), equalTo(true));

        String[] input5 = "0 4 3 2 1 9 8 7 6 5".split("\\s");
        assertThat(Exercise1345.canPermutationGenerated(input5), equalTo(true));

        String[] input6 = "0 4 6 5 3 8 1 7 2 9".split("\\s");
        assertThat(Exercise1345.canPermutationGenerated(input6), equalTo(false));

        String[] input7 = "1 4 7 9 8 6 5 3 0 2".split("\\s");
        assertThat(Exercise1345.canPermutationGenerated(input7), equalTo(false));

    }


} 
