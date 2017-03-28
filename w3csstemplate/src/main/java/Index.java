
import javax.enterprise.inject.Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author danecek
 */
@Model
public class Index {

    /**
     * @return the col
     */
    public Point[] getCol() {
        return col;
    }

    /**
     * @param col the col to set
     */
    public void setCol(Point[] col) {
        this.col = col;
    }


    private Point[] col = {new Point(1,2), new Point(3,4)};
}
