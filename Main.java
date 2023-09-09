
package View;

import Common.Library;
import Controller.SearchProgram;
import Model.Element;

/**
 *
 * @author AN515-57
 */
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        
        int size = library.getInt("Enter the number of elements in the array", 1, 100);
         Element element = new Element();
         element.setArray(library.createArr(size));
         
         SearchProgram searchprogram = new SearchProgram(element);
         searchprogram.run();
    }
}
