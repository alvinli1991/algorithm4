package section1;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Exercise139 Tester.
 *
 * @author Alvin Li
 * @version 1.0
 * @since <pre>Mar 25, 2020</pre>
 */
public class Exercise139Test {


    /**
     * Method: recover(String input)
     */
    @Test
    public void testRecover() throws Exception {
        String input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        String result ="( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )";
        assertThat(Exercise139.recover(input),equalTo(result));
    }


} 
