/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.asyncinvoke;

import java.util.concurrent.Future;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;


@Stateless
public class AsyncBean {
    
    @Asynchronous
    public Future<String> longEvaluation(){
        String result = "";
        return new AsyncResult<String>(result);
    }

}
