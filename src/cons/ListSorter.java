package cons;


import java.util.*;

/**

 */
public class ListSorter<T> {

    /**
     */
    public void insertionSort(List<T> list, Comparator<T> comparator) {

        for (int i=1; i < list.size(); i++) {
            T elt_i = list.get(i);
            int j = i;
            while (j > 0) {
                T elt_j = list.get(j-1);
                if (comparator.compare(elt_i, elt_j) >= 0) {
                    break;
                }
                list.set(j, elt_j);
                j--;
            }
            list.set(j, elt_i);
        }
    }

    /**

     */
    public void mergeSortInPlace(List<T> list, Comparator<T> comparator) {
        List<T> sorted = mergeSort(list, comparator);
        list.clear();
        list.addAll(sorted);
    }

    /**

     */
    public List<T> mergeSort(List<T> list, Comparator<T> comparator) {
        int size = list.size();
        if (size <= 1) {
            return list;
        }
        // make two lists with half the elements each.
        List<T> first = mergeSort(new LinkedList<T>(list.subList(0, size/2)), comparator);
        List<T> second = mergeSort(new LinkedList<T>(list.subList(size/2, size)), comparator);

        return merge(first, second, comparator);
    }

    /**
     */
    private List<T> merge(List<T> first, List<T> second, Comparator<T> comparator) {
        // NOTE: using LinkedList is important because we need to
        // remove from the beginning in constant time
        List<T> result = new LinkedList<T>();
        int total = first.size() + second.size();
        for (int i=0; i<total; i++) {
            List<T> winner = pickWinner(first, second, comparator);
            result.add(winner.remove(0));
        }
        return result;
    }

    /**
     */
    private List<T> pickWinner(List<T> first, List<T> second, Comparator<T> comparator) {
        if (first.size() == 0) {
            return second;
        }
        if (second.size() == 0) {
            return first;
        }
        int res = comparator.compare(first.get(0), second.get(0));
        if (res < 0) {
            return first;
        }
        if (res > 0) {
            return second;
        }
        return first;
    }

    /**
     */
    public void heapSort(List<T> list, Comparator<T> comparator) {
        PriorityQueue<T> heap = new PriorityQueue<T>(list.size(), comparator);
        heap.addAll(list);
        list.clear();
        while (!heap.isEmpty()) {
            list.add(heap.poll());
        }
    }


    /**
     */
    public List<T> topK(int k, List<T> list, Comparator<T> comparator) {
        PriorityQueue<T> heap = new PriorityQueue<T>(list.size(), comparator);
        for (T element: list) {
            if (heap.size() < k) {
                heap.offer(element);
                continue;
            }
            int cmp = comparator.compare(element, heap.peek());
            if (cmp > 0) {
                heap.poll();
                heap.offer(element);
            }
        }
        List<T> res = new ArrayList<T>();
        while (!heap.isEmpty()) {
            res.add(heap.poll());
        }
        return res;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(3, 5, 1, 4, 2));

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer elt1, Integer elt2) {
                return elt1.compareTo(elt2);
            }
        };

        ListSorter<Integer> sorter = new ListSorter<Integer>();
        sorter.insertionSort(list, comparator);
        System.out.println(list);

        list = new ArrayList<Integer>(Arrays.asList(3, 5, 1, 4, 2));
        sorter.mergeSortInPlace(list, comparator);
        System.out.println(list);

        list = new ArrayList<Integer>(Arrays.asList(3, 5, 1, 4, 2));
        sorter.heapSort(list, comparator);
        System.out.println(list);

        list = new ArrayList<Integer>(Arrays.asList(6, 3, 5, 8, 1, 4, 2, 7));
        List<Integer> queue = sorter.topK(4, list, comparator);
        System.out.println(queue);
    }
}
