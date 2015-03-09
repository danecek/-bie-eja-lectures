/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author danecek
 */
@ManagedBean
public class ColorBean {

    private int color1;
    private int color2;
    private int color3;
    private int color4;
    private int[] colors1;
    private int[] colors2;
    private int[] colors3;
    private int[] colors4;
    private boolean on;

    private String[] colors = {"Red", "Blue", "Green"};
    private final int[] values = {1, 2, 3};

    /**
     * @return the specialOffer
     */
    public boolean isOn() {
        return on;
    }

    /**
     * @param on the specialOffer to set
     */
    public void setOn(boolean on) {
        this.on = on;
    }

    public int getColor1() {
        return color1;
    }

    /**
     * @param color1 the color1 to set
     */
    public void setColor1(int color1) {
        this.color1 = color1;
    }

    /**
     * @return the colors
     */
    public String[] getColors() {
        return colors;
    }

    /**
     * @return the color2
     */
    public int getColor2() {
        return color2;
    }

    /**
     * @param color2 the color2 to set
     */
    public void setColor2(int color2) {
        this.color2 = color2;
    }

    /**
     * @return the color3
     */
    public int getColor3() {
        return color3;
    }

    /**
     * @param color3 the color3 to set
     */
    public void setColor3(int color3) {
        this.color3 = color3;
    }

    /**
     * @return the color4
     */
    public int getColor4() {
        return color4;
    }

    /**
     * @param color4 the color4 to set
     */
    public void setColor4(int color4) {
        this.color4 = color4;
    }

    /**
     * @return the colors1
     */
    public int[] getColors1() {
        return colors1;
    }

    /**
     * @param colors1 the colors1 to set
     */
    public void setColors1(int[] colors1) {
        this.colors1 = colors1;
    }

    /**
     * @return the colors2
     */
    public int[] getColors2() {
        return colors2;
    }

    /**
     * @param colors2 the colors2 to set
     */
    public void setColors2(int[] colors2) {
        this.colors2 = colors2;
    }

    /**
     * @return the colors3
     */
    public int[] getColors3() {
        return colors3;
    }

    /**
     * @param colors3 the colors3 to set
     */
    public void setColors3(int[] colors3) {
        this.colors3 = colors3;
    }

    /**
     * @return the colors4
     */
    public int[] getColors4() {
        return colors4;
    }

    /**
     * @param colors4 the colors4 to set
     */
    public void setColors4(int[] colors4) {
        this.colors4 = colors4;
    }

}
