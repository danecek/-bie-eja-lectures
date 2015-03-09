/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.Collection;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author danecek
 */
@ManagedBean
@ApplicationScoped
public class ItemsDB {

    Collection<Item> items = new ArrayList<>();
    private int beginOfCurrentPage = 0;
    private final int pageRows = 10;

    /**
     * Creates a new instance of ItemsBean
     */
    public ItemsDB() {
        for (int i = 1; i <= 100; i++) {
            items.add(new Item(i, Math.random()));
        }

    }

    private int beginOfLastPage() {
        return Math.max(items.size() - pageRows, 0);
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void nextPage() {
        beginOfCurrentPage = Math.min(beginOfCurrentPage + pageRows, beginOfLastPage());
    }

    public void prevPage() {
        beginOfCurrentPage = Math.max(beginOfCurrentPage - pageRows, 0);
    }

    public void begin() {
        beginOfCurrentPage = 0;
    }

    public void end() {
        beginOfCurrentPage = beginOfLastPage();
    }

    /**
     * @return the rows
     */
    public int getPageRows() {
        return pageRows;
    }

    /**
     * @return the beginOfCurrentPage
     */
    public int getBeginOfCurrentPage() {
        return beginOfCurrentPage;
    }

}
