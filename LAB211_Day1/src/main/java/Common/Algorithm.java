
package Common;


public class Algorithm {
    public void bubbleSort(int[] array) {
        for(int i = 0;  i < array.length; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    
    public int partition(int[] array, int left, int right) {
        int i = left, j = right;
        int piv = array[(left + right) / 2];
        int temp;
        while(i <= j) {
            while (array[i] < piv) {
                i++;
            }
            while (array[j] > piv) {
                j--;
            }
            if (i <= j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        };
        return i;
            
    }
    
    public void quickSort(int[] array, int left, int right) {
        int index = partition(array, left, right);
        if(left < index - 1) {
            quickSort(array, left, index - 1);
        } if (index < right) {
            quickSort(array, left, right);
        }
    }
}
