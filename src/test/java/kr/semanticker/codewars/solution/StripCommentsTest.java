package kr.semanticker.codewars.solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StripCommentsTest {

    @Test
    public void stripComments() throws Exception {
        assertEquals(
                "apples, pears\ngrapes\nbananas",
                StripComments.stripComments( "apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" } )
        );

       /* assertEquals(
                "a\nc\nd",
                StripComments.stripComments( "a #b\nc\nd $e f g", new String[] { "#", "$" } )
        );


        assertEquals(
                "a\n b\nc",
                StripComments.stripComments( "a \n b\nc ", new String[] { "#", "$" } )
        );*/

        /*assertEquals(
                "e\nb\n",
                StripComments.stripComments( "e\nb\n#\n", new String[] { "#", "$" } )
        );*/
        // <a[
        // b
        //c]
        /*assertEquals(
                "a[\nb\nc]",
                StripComments.stripComments( "<a[\nb\nc]  ", new String[] { "<", "$" } )
        );*/

    }
}
