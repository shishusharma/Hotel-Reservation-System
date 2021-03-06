
package bean;

public class TariffReportBean {
    private String roomno=null;
    private String roomtype=null;
    private String bedtype=null;
    private String tariff=null;
    private String status=null;

    public TariffReportBean(String roomno,String roomtype,String bedtype,String tariff,String status) {
        
        this.roomno=roomno;
        this.roomtype=roomtype;
        this.bedtype=bedtype;
        this.tariff=tariff;
        this.status=status;
    }

    public String getRoomno() {
        return roomno;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public String getBedtype() {
        return bedtype;
    }

  
    public String getTariff() {
        return tariff;
    }

    public String getStatus() {
        return status;
    }
 }

   
    
    
    

