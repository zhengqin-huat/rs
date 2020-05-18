package cons;



import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import javax.lang.model.util.Elements;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class WikiParserTest {

    final static WikiFetcher wf = new WikiFetcher();

    /**

     */
    @Test
    public void testFindFirstLink1() throws IOException {
        String url = "https://";
        String href = findFirstLink(url);
        assertThat(href, is(""));
    }

    /**

     */
    @Test
    public void testFindFirstLink2() throws IOException {
        String url = "";
        String href = findFirstLink(url);
        assertThat(href, is("y"));
    }

    /**

     */
    private String findFirstLink(String url) throws IOException {
        Elements paragraphs = wf.readWikipedia(url);
        WikiParser wp = new WikiParser(paragraphs);
        Element elt = wp.findFirstLink();
        String href = elt.attr("href");
        return href;
    }

}
