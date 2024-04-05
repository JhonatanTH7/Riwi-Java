package Works.MockExam1.Utilities;

import java.util.List;

public class Util {
    public static <T> T[] listToArray(List<T> list) {
        T[] vector;
        vector = (T[]) new Object[list.size()];
        int i = 0;
        for (T element : list) {
            vector[i++] = element;
        }
        return vector;
    }
}
