
/*
    This Class contains only static methods which can be used to manipulate the receivers database.
    
    
    It provides methods like:
    getReceiver - this returns an object of the type  Receiver that has all the required details by grabbing the information from the  Receivers database using the name which
                        is unique.
    insertReceiver - this takes in an object of the type  Receiver and inserts this data into the Receivers database.
                           
    
    updateReceiver - this updates the details of the  receiver if his details are already there in the Receivers database and return true.
                         If this receiver is not there in the Receivers database, then this method returns false.
                         
    deleteReceiver - this method deletes a receiver and his details from the Receivers database and returns true.
                            If the receiver is not present in the Receivers database, it returns false.
             
     getAllReceivers - this method returns a list of all the receivers present in the Receivers database and their respective details, each in the form of Receiver object.
                         
    getCount - returns the total number of donars registered in our app
 
 */


package com.example.phase1;

import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ReceiverClass
{
    public static Receiver getReceiver(String name )
    {
        Connection connection = ConnectionClass.getConnection();
        Receiver d = new Receiver();
        if( connection == null )
        {
            return null;
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from ReceiverList where name = '" + name + "'");
            while( rs.next() )
            {
                d.setName(rs.getString("name"));
                d.setAddress(rs.getString("address"));
                d.setEmail(rs.getString("email"));
                d.setPhno(rs.getString("phone"));
                return d;
            }
            return null;
        }
        catch ( Exception e )
        {
            Log.e("Error is", e.getMessage());
        }
        return null;
    }

    public static boolean insertReceiver( Receiver receiver )
    {
        Connection connection = ConnectionClass.getConnection();
        String statement = "Insert into ReceiverList ( name, address, email, phone ) Values ( '"
                +receiver.getName()+"', '"+receiver.getAddress()+"', '"+receiver.getEmail()+"', '"+receiver.getPhno()+"' )";
        Log.d("Query", statement);
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(statement);
            return true;
        }
        catch (Exception e )
        {
            Log.e("Error in inserting the object", e.getMessage());
        }
        return false;
    }

    public static boolean updateReceiver( Receiver receiver )
    {
        Connection connection = ConnectionClass.getConnection();
        try
        {
            Statement st = connection.createStatement();
            String s = "update ReceiverList set address = '"+receiver.getAddress()+"', email = '"+receiver.getEmail()+"', phone = '"+receiver.getPhno()+"' where name = '"+receiver.getName()+"'";
            st.executeUpdate(s);
            return true;
        }
        catch(Exception e )
        {
            Log.e("Error while updating the data", e.getMessage());
        }
        return false;
    }

    public static ArrayList getAllReceivers()
    {
        ArrayList<Receiver> array = new ArrayList<>();

        Connection connection = ConnectionClass.getConnection();
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from ReceiverList");
            while(rs.next())
            {
                Receiver d = new Receiver();
                d.setName(rs.getString("name"));
                d.setAddress(rs.getString("address"));
                d.setEmail(rs.getString("email"));
                d.setPhno(rs.getString("phone"));
                array.add(d);
            }
        }
        catch(Exception e )
        {
            Log.e("Couldn't fetch donors list", e.getMessage());
        }
        return array;
    }

    public static int getCount()
    {
        Connection connection = ConnectionClass.getConnection();
        try{
            Statement s = connection.createStatement();
            ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM ReceiverList");
            r.next();
            int count = r.getInt("rowcount");
            r.close();
            return count;
        }
        catch(Exception e )
        {
            Log.e("Couldn't fetch receiver count", e.getMessage());
        }
        return -1;
    }
}
