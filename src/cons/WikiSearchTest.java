package cons;
/**
 *
 */

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author
 *
 */
public class WikiSearchTest {

    private WikiSearch search1;
    private WikiSearch search2;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        map1.put("Page1", 1);
        map1.put("Page2", 2);
        map1.put("Page3", 3);
        search1 = new WikiSearch(map1);

        Map<String, Integer> map2 = new HashMap<String, Integer>();
        map2.put("Page2", 4);
        map2.put("Page3", 5);
        map2.put("Page4", 7);
        search2 = new WikiSearch(map2);
    }

    /**
     */
    @Test
    public void testOr() {
        WikiSearch search = search1.or(search2);
        assertThat(search.getRelevance("Page1"), is(1));
        assertThat(search.getRelevance("Page2"), is(6));
        assertThat(search.getRelevance("Page3"), is(8));
        assertThat(search.getRelevance("Page4"), is(7));
        assertThat(search.getRelevance("Page5"), is(0));
    }

    /**
     */
    @Test
    public void testAnd() {
        WikiSearch search = search1.and(search2);
        assertThat(search.getRelevance("Page1"), is(0));
        assertThat(search.getRelevance("Page2"), is(6));
        assertThat(search.getRelevance("Page3"), is(8));
        assertThat(search.getRelevance("Page4"), is(0));
        assertThat(search.getRelevance("Page5"), is(0));
    }

    /**
     */
    @Test
    public void testMinus() {
        WikiSearch search = search1.minus(search2);
        assertThat(search.getRelevance("Page1"), is(1));
        assertThat(search.getRelevance("Page2"), is(0));
        assertThat(search.getRelevance("Page3"), is(0));
        assertThat(search.getRelevance("Page4"), is(0));
        assertThat(search.getRelevance("Page5"), is(0));
    }

    /**
     */
    @Test
    public void testSort() {
        List<Entry<String, Integer>> list = search2.sort();
        assertThat(list.get(0).getValue(), is(4));
        assertThat(list.get(1).getValue(), is(5));
        assertThat(list.get(2).getValue(), is(7));
    }
}
