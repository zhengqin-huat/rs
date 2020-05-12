package cons;


import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


/**
 */
public class WikiSearch {

    // map from URLs that contain the term(s) to relevance score
    private Map<String, Integer> map;

    /**
     */
    public WikiSearch(Map<String, Integer> map) {
        this.map = map;
    }

    /**
     */
    public Integer getRelevance(String url) {
        Integer relevance = map.get(url);
        return relevance==null ? 0: relevance;
    }

    /**
     */
    private  void print() {
        List<Entry<String, Integer>> entries = sort();
        for (Entry<String, Integer> entry: entries) {
            System.out.println(entry);
        }
    }

    /**
     */
    public WikiSearch or(WikiSearch that) {
        // TODO: FILL THIS IN!
        return null;
    }

    /**
     */
    public WikiSearch and(WikiSearch that) {
        // TODO: FILL THIS IN!
        return null;
    }

    /**
     */
    public WikiSearch minus(WikiSearch that) {
        // TODO: FILL THIS IN!
        return null;
    }

    /**
     */
    protected int totalRelevance(Integer rel1, Integer rel2) {
        // simple starting place: relevance is the sum of the term frequencies.
        return rel1 + rel2;
    }

    /**
     */
    public List<Entry<String, Integer>> sort() {
        // TODO: FILL THIS IN!
        return null;
    }


    /**

     */
    public static WikiSearch search(String term, JedisIndex index) {
        Map<String, Integer> map = index.getCounts(term);
        return new WikiSearch(map);
    }

    public static void main(String[] args) throws IOException {

        // make a JedisIndex
        Jedis jedis = JedisMaker.make();
        JedisIndex index = new JedisIndex(jedis);

        // search for the first term
        String term1 = "java";
        System.out.println("Query: " + term1);
        WikiSearch search1 = search(term1, index);
        search1.print();

        // search for the second term
        String term2 = "programming";
        System.out.println("Query: " + term2);
        WikiSearch search2 = search(term2, index);
        search2.print();

        // compute the intersection of the searches
        System.out.println("Query: " + term1 + " AND " + term2);
        WikiSearch intersection = search1.and(search2);
        intersection.print();
    }
}
