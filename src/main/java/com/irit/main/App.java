package com.irit.main;

import com.irit.upnp.IHMServer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new Thread(new IHMServer()).run();
    }
}
