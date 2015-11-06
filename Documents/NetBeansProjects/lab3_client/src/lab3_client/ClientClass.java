
package lab3_client;

import com.sun.xml.internal.ws.api.message.Packet;
import java.io.*;
import java.net.*;
 


public class ClientClass 
{

   public  ClientClass Client ;
        public static void main(String[] args) throws Exception
        {
        Client_gui.main(args);
 
        }
       
        
        
    static   public void run(String Adress,String n1,String n2,int Port) throws Exception      
        {
            
          
              System.out.println("Client Running");
            Client_gui.status_area.setText("Client Running");
              
                   System.out.println("Connecting to server...");
                   print_gui("Connecting to server...");
            Socket SOCK = new Socket(Adress,Port);
            
            
        
            PrintStream PS = new PrintStream(SOCK.getOutputStream());
            PS.println(n1);
                        PS.println(n2);
           
              System.out.println("Messages sent");
              print_gui("Messages sent");
            InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
            BufferedReader BR = new BufferedReader(IR);
           
             System.out.println("Receiving from server:");
              print_gui("Receiving from server:");
              
              
            String MESSAGE = BR.readLine();
            System.out.println(MESSAGE);
            print_gui(MESSAGE);
            
        }
    
        static void print_gui(String s){
 Client_gui.status_area.setText(Client_gui.status_area.getText()+"\n"+ s);
}
    }

    