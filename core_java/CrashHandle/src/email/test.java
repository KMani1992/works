/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *
 * @author mani
 */
public class test {
    
    public static void main(String args[])
    {
         String arr="RAJA";
         
      byte[] dd=Base64.getEncoder().encode(arr.getBytes(StandardCharsets.UTF_16BE));
         
         
         System.out.println(new String(dd));
         
         
         
    }
    
}
