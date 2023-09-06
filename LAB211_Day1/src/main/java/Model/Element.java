

package Model;


public class Element {

    public int size_array;
    public int[] array;

    public Element(int size_array, int[] array) {
        this.size_array = size_array;
        this.array = array;
    }

    public int getSize_array() {
        return size_array;
    }

    public void setSize_array(int size_array) {
        this.size_array = size_array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
    
    
    
}
