
package bean;


public class Billing {
     private String id=null;
    private String bno=null;
    private String bdate=null;
    private String days=null;
    private String amount=null;
    private String ptype=null;
    private String card=null;
    private String cname=null;
    private String remarks=null;

    public Billing(String id,String bno,String bdate,String days,String amount,String ptype,String card,String cname,String remarks) {
        this.id=id;
        this.bno=bno;
        this.bdate=bdate;
        this.days=days;
        this.amount=amount;
        this.ptype=ptype;
        this.card=card;
        this.cname=cname;
        this.remarks=remarks;
    }

    public String getId() {
        return id;
    }

    public String getBno() {
        return bno;
    }

    public String getBdate() {
        return bdate;
    }

    public String getDays() {
        return days;
    }

    public String getAmount() {
        return amount;
    }

    public String getPtype() {
        return ptype;
    }

    public String getCard() {
        return card;
    }

    public String getCname() {
        return cname;
    }

    public String getRemarks() {
        return remarks;
    }

   
    
}
