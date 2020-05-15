package cons;



import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class ListSorterTest {

    private ListSorter<Integer> sorter;
    private Comparator<Integer> comparator;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

        comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer elt1, Integer elt2) {
                return elt1.compareTo(elt2);
            }
        };

        sorter = new ListSorter<Integer>();
    }

    /**
     *
     */
    @Test
    public void testInsertionSort() {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(3, 5, 1, 4, 2));
        sorter.insertionSort(list, comparator);
        isSorted(list);
    }

    /**
     * @param list
     *
     */
    private void isSorted(List<Integer> list) {
        assertThat(list.size(), is(5));
        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is(2));
        assertThat(list.get(2), is(3));
        assertThat(list.get(3), is(4));
        assertThat(list.get(4), is(5));
    }

    /**
     *
     */
    @Test
    public void testMergeSortInPlace() {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(3, 5, 1, 4, 2));
        sorter.mergeSortInPlace(list, comparator);
        isSorted(list);
    }

    /**
     *
     */
    @Test
    public void testMergeSort() {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(3, 5, 1, 4, 2));
        List<Integer> sorted = sorter.mergeSort(list, comparator);
        isSorted(sorted);
    }

    /**
     *
     */
    @Test
    public void testHeapSort() {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(3, 5, 1, 4, 2));
        sorter.heapSort(list, comparator);
        isSorted(list);
    }

    /**
     *
     */
    @Test
    public void testTopK() {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(6, 3, 5, 8, 1, 4, 2, 7));

        List<Integer> res = sorter.topK(4, list, comparator);
        assertThat(res.size(), is(4));
        assertThat(res.get(0), is(5));
        assertThat(res.get(1), is(6));
        assertThat(res.get(2), is(7));
        assertThat(res.get(3), is(8));
    }
}
