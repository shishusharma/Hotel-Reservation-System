package hrs;

import bean.Cancel;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class HRSManager 
{
    
    //functions for login below
    
    public static String validateUser(String user_id, String password) {
        String msg = "unsuccess";
        Connection con = null;
        PreparedStatement ps;

        try {
            con = new MConnection().getConnection();
            ps = con.prepareStatement("SELECT user_id,name FROM user_profile where user_id=? and password=?");
            ps.setString(1, user_id);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                    String id = getId("id", "user_login");
                    ps = con.prepareStatement("insert into user_login values(?,?,sysdate)");
                    ps.setInt(1,new Integer(id));
                    ps.setString(2, user_id);
                    ps.executeUpdate();
                    msg = "success";
                

            }
        } catch (Exception e) {
            msg = String.valueOf(e);
        } finally {
            try {

                con.close();
            } catch (Exception e) {
            }
        }
        return msg;
    }
  public static String getUserName(String user_id) {
        String name=null;
        Connection con = null;

        try {
            con = new MConnection().getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT name FROM user_profile where user_id=?");
            ps.setString(1, user_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                    name=rs.getString(1);
            }
        } catch (Exception e) {
                } finally {
            try {

                con.close();
            } catch (Exception e) {
            }
        }
        return name;
    }
  public static boolean getExistUserid(String userid) {
        String puser_id = null;
        Connection con = null;
        boolean flag = false;
        try {
            String sql = "select * from user_profile where user_id=?";
            con = new MConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                flag = true;
            }

        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }
        return flag;
    }



    
    //function related to id below
    public static String getId(String col_name, String table_name) {
        String msg = null;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = new MConnection().getConnection();
            ps = con.prepareStatement("select nvl(max(" + col_name + " )+1,1) from " + table_name + "");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                msg = rs.getString(1);
            }
        } catch (Exception e) {
            msg = String.valueOf(e);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
        return msg;
    }

public static String getCount(String col_name, String table_name,String count_type) {
        
        Connection con = null;
        PreparedStatement ps = null;
        String ctype=count_type;
        int count=0;
        try {
            con = new MConnection().getConnection();
            ps = con.prepareStatement("select nvl(count(" + col_name + " ),0)+1 from " + table_name + "");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count=rs.getInt(1);
                if(count<10)ctype=ctype+"0"+count;
                else ctype=ctype+count;
            }
        } catch (Exception e) {
            ctype = String.valueOf(e);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
        return ctype;
    }



public static List<bean.Tariff> getTariffList() {

        ArrayList<bean.Tariff> list = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = new MConnection().getConnection();
            
            ps = con.prepareStatement("select * from tariff order by id");
           
            ResultSet rs = ps.executeQuery();
          
            while (rs.next()) {
              

                list.add(new bean.Tariff(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }

        } catch (Exception se) {
            System.out.println(se);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }

        return list;
    }

public static List<bean.Tariff> getTariff(String id) {

        ArrayList<bean.Tariff> list = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = new MConnection().getConnection();
            
            ps = con.prepareStatement("select * from tariff where id='"+id+"'");
           
            ResultSet rs = ps.executeQuery();
          
            while (rs.next()) {
              

                list.add(new bean.Tariff(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }

        } catch (Exception se) {
            System.out.println(se);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }

        return list;
    }

public static Map<String, String> getRoomtypePairList() {

        Map<String, String> list = new LinkedHashMap<String, String>();
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = new MConnection().getConnection();
            ps = con.prepareStatement("select id ,name from room_type");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                list.put(rs.getString(1), rs.getString(2));

            }

        } catch (Exception se) {
            System.out.println(se);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }

        return list;
    }
public static String saveTariff(String rtype, String btype,String tariff,String description) {
        String msg = null;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = new MConnection().getConnection();
            ps = con.prepareStatement("insert into tariff values(?,?,?,?,?)");
            String id=getId("id","tariff");
            ps.setInt(1, new Integer(id));
            ps.setString(2, rtype);
            ps.setString(3, btype);
            ps.setInt(4, new Integer(tariff));
            ps.setString(5, description);
            ps.executeUpdate();
            msg="Tariff record has been successfully added.";
        } catch (Exception e) {
            msg = String.valueOf(e);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
        return msg;
    }

public static String editTariff(String id,String rtype, String btype,String tariff,String description) {
        String msg = null;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = new MConnection().getConnection();
            ps = con.prepareStatement("update tariff set room_type=?,bed_type=?,tariff=?,description=? where id='"+id+"'");
            
            
            ps.setString(1, rtype);
            ps.setString(2, btype);
            ps.setInt(3, new Integer(tariff));
            ps.setString(4, description);
            //ps.setInt(5, new Integer(id));
            ps.executeUpdate();
            msg="Tariff record has been successfully updated..";
        } catch (Exception e) {
            msg = String.valueOf(e);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
        return msg;
    }


public static List<bean.Room> getRoomList() {

        ArrayList<bean.Room> list = new ArrayList();
        Connection con = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        ResultSet rs1;
        ResultSet rs2;
        int tid;
        try {

            con = new MConnection().getConnection();
            
            
            ps1 = con.prepareStatement("select * from room_master  order by room_no");
           
            rs1 = ps1.executeQuery();
          
           while( rs1.next()){ 
               tid= rs1.getInt(2);
              
            ps2=con.prepareStatement("select room_type,bed_type from tariff where id='"+tid+"'");
          
            rs2=ps2.executeQuery();
            
            while(rs2.next()){
                 list.add(new bean.Room(rs1.getString(1), rs2.getString(1), rs2.getString(2), rs1.getString(3)));
            }
           }
         }catch (Exception se) {
            System.out.println(se);
            
        } finally {
            try {
                ps1.close();
                ps2.close();
                con.close();
            } catch (Exception e) {
            }
        }

        return list;
    }

public static String saveRoom(String rn,String rtype, String btype) {
        String msg = null;
        Connection con = null;
        PreparedStatement ps = null;
        PreparedStatement ps1=null;
        ResultSet rs=null;
        int tid=0;
        String status="vaccant";
      try{
          con = new MConnection().getConnection();
          String sql="select id from tariff where room_type='"+rtype+"' and bed_type='"+btype+"'";
          ps=con.prepareStatement(sql);
       	  rs=ps.executeQuery();
          if(rs.next())
           tid=rs.getInt(1); 
          
          ps1=con.prepareStatement("insert into room_master values(?,?,?)");
          ps1.setString(1, rn);
          ps1.setInt(2, tid);
          ps1.setString(3, status);
          ps1.executeUpdate();
          msg="Room has been successfully created.";
        } catch (Exception e) {
            msg = String.valueOf(e);
        } finally {
            try {
                ps.close();
                ps1.close();
                con.close();
            } catch (Exception e) {
            }
        }
        return msg;
    }

public static List<bean.RoomBooking> getBookingList() {

        ArrayList<bean.RoomBooking> list = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = new MConnection().getConnection();
            
            ps = con.prepareStatement("select * from room_booking order by booking_no");
           
            ResultSet rs = ps.executeQuery();
          
            while (rs.next()) {
              

                list.add(new bean.RoomBooking(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
                         ,rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getString(12)));

            }

        } catch (Exception se) {
            System.out.println(se);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }

        return list;
    }

public static String getRno(String rtype,String btype){
    Connection con=null;
    PreparedStatement ps1=null;
    PreparedStatement ps2=null;
    ResultSet rs=null;
    int id=0;
    String rn=null;
   
    try{
      con = new MConnection().getConnection(); 
      ps1=con.prepareStatement("select id from tariff where room_type='"+rtype+"' and bed_type='"+btype+"'");
      rs=ps1.executeQuery();
      if(rs.next())id=rs.getInt(1);
      ps2=con.prepareStatement("select room_no from room_master where tariff_id='"+id+"' and status='vaccant'");
      rs=ps2.executeQuery();
      if(rs.next())rn=rs.getString(1);
     
    }catch(Exception e){}
    return rn;
}

public static String saveBooking(String bdate,String rno,String cname,String address,String gender,String contact,
                          String nationality,String purpose,int occupancy,int days,String status)
        {
        String msg = null;
        Connection con = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        
        try {
            con = new MConnection().getConnection();
            ps = con.prepareStatement("insert into room_booking values(?,to_date(?,'yyyy/mm/dd'),?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, getCount("booking_no","room_booking","B-0"));
            ps.setString(2, bdate);
            ps.setString(3, rno);
            ps.setString(4, cname);
            ps.setString(5, address);
            ps.setString(6, gender);
            ps.setString(7, contact);
            ps.setString(8, nationality);
            ps.setString(9, purpose);
            ps.setInt(10,occupancy);
            ps.setInt(11,days);
            ps.setString(12,status );
            ps.executeUpdate();
            ps2=con.prepareStatement("update room_master set status='occupied' where room_no='"+rno+"'");
            ps2.executeQuery();
            msg="Booking record has been successfully added.";
        } catch (Exception e) {
            msg = String.valueOf(e);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
        return msg;
    }

public static List<bean.RoomBooking> getBookingDetails(String bn) {

        ArrayList<bean.RoomBooking> list = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = new MConnection().getConnection();
            
            ps = con.prepareStatement("select * from room_booking where booking_no='"+bn+"'");
           
            ResultSet rs = ps.executeQuery();
          
            if (rs.next()) {
              
                 list.add(new bean.RoomBooking(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
                         ,rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getString(12)));

            }

        } catch (Exception se) {
            System.out.println(se);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }

        return list;
    }

public static String updateBooking(String bn,String name,String address,String contact,
                          int occupancy,int days,String gender,String nationality,String status,String purpose)
        {
        String msg = null;
        Connection con = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        
        try {
            con = new MConnection().getConnection();
            ps = con.prepareStatement("update room_booking set customer_name=?,present_address=?,contact_no=?,occupancy=?,days=?,gender=?,nationality=?,status=?,purpose=? where booking_no=? ");
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, contact);
            ps.setInt(4, occupancy);
            ps.setInt(5, days);
            ps.setString(6, gender);
            ps.setString(7, nationality);
            ps.setString(8, status);
            ps.setString(9,purpose );
            ps.setString(10,bn );
            ps.executeUpdate();
            msg="Booking record sucessfully updated.";
        } catch (Exception e) {
            msg = String.valueOf(e);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
        return msg;
    }

//FUNCTIONS RELATED TO TRANSFER BELOW...


public static List<bean.RoomTransfer> getTransferList() {

        ArrayList<bean.RoomTransfer> list = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = new MConnection().getConnection();
            
            ps = con.prepareStatement("select * from room_transfer order by transfer_date");
           
            ResultSet rs = ps.executeQuery();
          
            while (rs.next()) {
              
             list.add(new bean.RoomTransfer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6)));

            }

        } catch (Exception se) {
            System.out.println(se);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }

        return list;
    }

public static String getBookedRoom(String booking_num) {

        String rn=null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        String status=null;
        try {

            con = new MConnection().getConnection();
            ps = con.prepareStatement("select status from room_booking where booking_no='"+booking_num+"'");
             rs = ps.executeQuery();
             if(rs.next()) status=rs.getString(1);
            if(status.equalsIgnoreCase("Cancelled")|| status.equalsIgnoreCase("checked-out")){
                  if(status.equalsIgnoreCase("Cancelled"))rn="Cancelled";
                  if(status.equalsIgnoreCase("checked-out"))rn="checked-out";
              }
              else{
           
            ps = con.prepareStatement("select room_no from room_booking where booking_no=?");
            ps.setString(1, booking_num);
             rs = ps.executeQuery();
          
             if(rs.next()) rn=rs.getString(1);

        } 
        }catch (Exception se) {
            System.out.println(se);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }

        return rn;
    }

public static String transferRoom(String bn, String rn, String nrn,String date,String reason){
    String msg=null;
    Connection cn=null;
    PreparedStatement ps=null;
    
    try{
        cn=new MConnection().getConnection();
        ps=cn.prepareStatement("insert into room_transfer values(?,?,?,?,to_date(?,'yyyy/mm/dd'),?)");
        String rid=getId("id","room_transfer");
        ps.setString(1,rid);
        ps.setString(2, bn);
        ps.setString(3, rn);
        ps.setString(4,nrn);
        ps.setString(5, date);
        ps.setString(6,reason);
        ps.executeUpdate();
        ps=cn.prepareStatement("update room_master set status='vaccant' where room_no='"+rn+"'");
        ps.executeQuery();
        ps=cn.prepareStatement("update room_master set status='occupied' where room_no='"+nrn+"'");
        ps.executeQuery();
        ps=cn.prepareStatement("update room_booking set room_no='"+nrn+"' where room_no='"+rn+"' ");
         ps.executeQuery();
         msg="Room transfered sucessfully.";
    } catch(Exception e){
        msg = String.valueOf(e);
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (Exception e) {
            }
        }
        return msg;
}

//operations related to billing below

public static List<bean.Billing> getBillingList() {

        ArrayList<bean.Billing> list = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = new MConnection().getConnection();
            
            ps = con.prepareStatement("select * from billing ");
           
            ResultSet rs = ps.executeQuery();
          
            while (rs.next()) {
              
             list.add(new bean.Billing(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));

            }

        } catch (Exception se) {
            System.out.println(se);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }

        return list;
    }

public static int getDays(String booking_num) {
        String date=null;
        int days=0;
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = new MConnection().getConnection();
            
            ps = con.prepareStatement("select booking_date from room_booking where booking_no='"+booking_num+"'");
            ResultSet rs = ps.executeQuery();
            if(rs.next()) date=rs.getString(1);
             ps = con.prepareStatement("select to_date(SYSDATE)- to_date(?,'YYYY/MM/DD HH24:MI:SS')  from room_booking");
             ps.setString(1,date);
             rs=ps.executeQuery();
             if(rs.next()) days=rs.getInt(1);
             if(days==0)days=1;
        } catch (Exception se) {
            System.out.println(se);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }

        return days;
    }

public static String getAmount(String booking_num) {
        
        String amount=null;
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = new MConnection().getConnection();
            
            ps = con.prepareStatement("select tariff from tariff where id=(select tariff_id from room_master where room_no=(select room_no from room_booking where booking_no=?))");
           
            ps.setString(1,booking_num);
           
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) amount=rs.getString(1);
            
             
             
        } catch (Exception se) {
            System.out.println(se);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }

        return amount;
    }


public static String getCustName(String booking_num) {
        
        String name=null;
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = new MConnection().getConnection();
            
            ps = con.prepareStatement("select customer_name from room_booking where booking_no=?");
           
            ps.setString(1,booking_num);
           
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) name=rs.getString(1);
            
             
             
        } catch (Exception se) {
            System.out.println(se);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }

        return name;
    }

public static String getStatus(String booking_num) {
        
        String status=null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try {
           con = new MConnection().getConnection();
             ps = con.prepareStatement("select status from room_booking where booking_no='"+booking_num+"'");
             rs = ps.executeQuery();
             rs.next();
              if(rs.getString(1).equalsIgnoreCase("Cancelled")){
                  status="Cancelled";
                 
              }
              if(rs.getString(1).equalsIgnoreCase("checked-out")){
                 status="checked-out";
              }
           
        } catch (Exception se) {
            System.out.println(se);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }

        return status;
    }


public static String roomBilling(String bn,String date,int days,int amt,String ptype, String card, String name,String remarks){
    String msg=null;
    Connection cn=null;
    PreparedStatement ps=null;
    int id=Integer.parseInt(getId("id","billing"));
    
    
    try{
        cn=new MConnection().getConnection();
        ps=cn.prepareStatement("insert into billing values(?,?,sysdate,?,?,?,?,?,?)");
        ps.setInt(1,id);
        ps.setString(2, bn);
//      ps.setString(3, date);
        ps.setInt(3, days);
        ps.setInt(4, amt);
        ps.setString(5, ptype);
        ps.setString(6, card);
        ps.setString(7, name);
        ps.setString(8, remarks);
        ps.executeUpdate();
        ps=cn.prepareStatement("update room_booking set status='checked-out' where booking_no='"+bn+"'");
        ps.executeQuery();
        ps=cn.prepareStatement("update room_master set status='vaccant' where room_no=(select room_no from room_booking where booking_no='"+bn+"')");
        ps.executeQuery();
        msg="Billing Sucessfull.";
    }catch(Exception e){
        msg = String.valueOf(e);
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (Exception e) {
            }
        }
    return msg;
}

//functions related to cancellation below..

public static List<bean.Cancel> getRoomCancelList() {
      
        
        ArrayList<bean.Cancel> list1 = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        ResultSet rs=null;
        ResultSet rs1=null;
        String Bookingno =null;
        try {
             con = new MConnection().getConnection();
             ps = con.prepareStatement("select * from room_cancellation order by id");
              rs = ps.executeQuery();
             while(rs.next()){
              Bookingno=(rs.getString(2));
             
             ps1 = con.prepareStatement("select room_no,customer_name from room_booking where booking_no='"+Bookingno+"'");
             rs1= ps1.executeQuery();
             while (rs1.next()) {
               list1.add(new Cancel(rs.getInt(1),rs.getString(2),rs1.getString(1),rs1.getString(2),rs.getString(3),rs.getString(4)));
             }
             }
            } catch (Exception se) {
            System.out.println(se);
            } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) { 
            }
         }

        return list1;
    }

 public static String fetchDetail(String bno) {
       
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        String s1=null;
        String msg=null;
        try {
             con = new MConnection().getConnection();
             ps = con.prepareStatement("select status from room_booking where booking_no='"+bno+"'");
             rs = ps.executeQuery();
             rs.next();
              if(rs.getString(1).equalsIgnoreCase("Cancelled")||rs.getString(1).equalsIgnoreCase("checked-out")){
                  if(rs.getString(1).equalsIgnoreCase("Cancelled"))msg="This Booking is already cancelled.";
                  if(rs.getString(1).equalsIgnoreCase("checked-out"))msg="This Booking is Checked-out.";
              }
              else{
             ps = con.prepareStatement("select room_no from room_booking where booking_no='"+bno+"'");
             rs = ps.executeQuery();
             if(rs.next()) {
              msg=rs.getString(1);
             }
              }
            } catch (Exception se) {
            System.out.println(se);
            } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {}
         }

        return msg;
    }
 
 public static String cancelRoom(String bno, String cdate,String roomno,String reason) {
        String msg = null;
        Connection con = null;
        PreparedStatement ps = null;
       
        try {
            con = new MConnection().getConnection();
           
            ps = con.prepareStatement("insert into room_cancellation values(?,?,to_date(?,'dd-mm-yyyy'),?)");
            String id=getId("id","room_cancellation");
            ps.setInt(1, new Integer(id));
            ps.setString(2, bno);
            ps.setString(3,cdate);
            ps.setString(4,reason);
            
            ps.executeUpdate();
             ps = con.prepareStatement("update room_booking set status='Cancelled' where Booking_no='"+bno+"'");
            ps.executeQuery();
            ps = con.prepareStatement("update room_master set status='vaccant' where room_no='"+roomno+"'");
            ps.executeQuery();
            msg="Room has been successfully Cancelled.";
        } catch (Exception e) {
            msg = String.valueOf(e);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
        return msg;
    }

 
 //REPORTING OF ROOM-TARIFF 
 
public static List<bean.TariffReportBean> getTariffRoomReport(String r_type,String b_type,String crit,String price,String status){
     ArrayList<bean.TariffReportBean> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        ResultSet rs1=null;
        String sql1=null;
        String sql=null;
        int id;
        
        try
        {
            con=new MConnection().getConnection();
            if(r_type.equalsIgnoreCase("-1")&&b_type.equalsIgnoreCase("-1")&&crit.equalsIgnoreCase("-1"))
            {
                sql="select*from room_master where status='"+status+"'";
                ps=con.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next())
                {
                    id=rs.getInt(2);
                    sql1="select room_type,bed_type,tariff from tariff where id="+id;
                    ps=con.prepareStatement(sql1);
                    rs1=ps.executeQuery();
                    while(rs1.next())
                    {
                       // System.out.println(rs.getString(1)+" "+rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs.getString(3));
                       list.add(new bean.TariffReportBean(rs.getString(1),rs1.getString(1),rs1.getString(2),rs1.getString(3),rs.getString(3)));
                    }
                }
                     
            }
            else
            {
 ////////////////////////////////creating condition of tariff table///////////////////
                String QCondition="";
//********************For RoomType selected**********                
                
                if (!r_type.equalsIgnoreCase("-1"))
                {
                 if (QCondition.length() > 0) 
                 QCondition += " And room_type = '" + r_type + "'";
                 else 
                 QCondition = "room_type = '" + r_type + "'";
                }
//*******************For BedType selected***********                
                if (!b_type.equalsIgnoreCase("-1"))
                {
                    if (QCondition.length() > 0)
                    QCondition += " And bed_type = '" + b_type + "'";
                    else 
                    QCondition = "bed_type = '" + b_type + "'";
                 }
////////////////For Criteria selected********
              if (!crit.equalsIgnoreCase("-1")) {
                if (crit.equalsIgnoreCase("lt")) {
                    if (QCondition.length() > 0) {
                        QCondition += " And tariff<  " + price ;
                    } else {
                        QCondition = "tariff < " + price ;
                    }
                }else if (crit.equalsIgnoreCase("mt")) {
                    if (QCondition.length() > 0) {
                        QCondition += " And tariff >  " + price ;
                    } else {
                        QCondition = "tariff > "+ price ;
                    }  
                
                 } else if (crit.equalsIgnoreCase("eq")) {
                    if (QCondition.length() > 0) {
                        QCondition += " And tariff =  " + price ;
                    } else { 
                        QCondition = "tariff = " + price ;
                    }  
                
                 }else if (crit.equalsIgnoreCase("le")) {
                    if (QCondition.length() > 0) {
                        QCondition += " And tariff <=  "+ price ;
                    } else {
                        QCondition = "tariff <= "+ price ;
                    }  
                
                 }else if (crit.equalsIgnoreCase("me")) {
                    if (QCondition.length() > 0) {
                        QCondition += " And tariff >=  " + price ;
                    } else {
                        QCondition = "tariff >= "+ price ;
                    }  
                
                 }           
              }
//*****************Codition created and Stored in  "QCondition"***             
              sql="select * from tariff where "+QCondition;
              ps=con.prepareStatement(sql);
              rs=ps.executeQuery();
              while(rs.next())
              {
                id=rs.getInt(1);
                if(status.equalsIgnoreCase("-1"))sql1="select room_no ,status from room_master where Tariff_id="+id;
                else sql1="select room_no ,status from room_master where status='"+status+"' and Tariff_id="+id;
                
                ps=con.prepareStatement(sql1);
                rs1=ps.executeQuery();
                while(rs1.next())
                {
                 //System.out.println(rs1.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs1.getString(2));
                 list.add(new bean.TariffReportBean(rs1.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs1.getString(2)));
                }
              
              }
              
                 }
        } catch (Exception e)
        {
            
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
  return list;   
 }



    public static void main(String[] args) {
            getTariffRoomReport("Delux","Single","-1","0","-1");
          }
       
 }

    
    

