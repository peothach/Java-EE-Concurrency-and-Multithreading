/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.rest;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.ws.rs.Path;

/**
 *
 * @author Ketkee Aryamane
 */
@Path("urlCheck")
public class URLHealthResource {
    
    @Resource(lookup = "java:comp/DefaultManagedScheduledExecutorService")
    private ManagedScheduledExecutorService scheduledExecutorService;
    
}
