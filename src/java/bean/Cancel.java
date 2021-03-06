package bean;
public class Cancel {
    private int id;
    private String Booking_no=null;
    private String Room_no=null;
    private String customer_name=null;
    private String Cancel_date=null;
    private String Reason=null;

    public Cancel(int id,String Booking_no,String Room_no,String customer_name,String Cancel_date,String Reason) {
        this.id=id;
        this.Booking_no= Booking_no;
        this.Room_no= Room_no;
        this.customer_name= customer_name;
        this.Cancel_date= Cancel_date;
        this.Reason= Reason;
    }

    public int getId() {
        return id;
    }

    public String getBooking_no() {
        return Booking_no;
    }

    public String getRoom_no() {
        return Room_no;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getCancel_date() {
        return Cancel_date;
    }

    public String getReason() {
        return Reason;
    }

   
    
    
    
    
    
}
