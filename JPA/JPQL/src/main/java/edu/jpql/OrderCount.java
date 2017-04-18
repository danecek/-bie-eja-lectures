/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jpql;

public class OrderCount {
    private Long id;
    private Long orderCount;

    public OrderCount(Long id, Long orderCount) {
        this.id = id;
        this.orderCount = orderCount;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the orderCount
     */
    public Long getOrderCount() {
        return orderCount;
    }
    
}
