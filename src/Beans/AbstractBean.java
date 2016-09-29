package Beans;

import org.primefaces.model.LazyDataModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by AcMined on 9/22/2016.
 */
public class AbstractBean< T > implements Serializable {

    private T selected;
    private ArrayList<T> filtered;
    private Class<T> itemClass;
    private Collection<T> items;
    private LazyDataModel<T> lazyList;
    private ArrayList paramItems;
    private ArrayList<String> columnNameList;
    private ArrayList<String> manyToOneList;
    private ArrayList<String> searchColumnNameList;

    private ArrayList<Boolean> listVisible;
    private ArrayList<Integer> listWidth;

    public T getSelected( ){
        return selected;
    }
}
