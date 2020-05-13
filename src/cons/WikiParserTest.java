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
        String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
        String href = findFirstLink(url);
        assertThat(href, is("/wiki/Programming_language"));
    }

    /**

     */
    @Test
    public void testFindFirstLink2() throws IOException {
        String url = "https://en.wikipedia.org/wiki/Mathematics";
        String href = findFirstLink(url);
        assertThat(href, is("/wiki/Quantity"));
    }

    /**
     * Uses WikiParser to find the first link in the given URL.

     */
    private String findFirstLink(String url) throws IOException {
        Elements paragraphs = wf.readWikipedia(url);
        WikiParser wp = new WikiParser(paragraphs);
        Element elt = wp.findFirstLink();
        String href = elt.attr("href");
        return href;
    }

}
