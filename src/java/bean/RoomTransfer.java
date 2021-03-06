
package bean;


public class RoomTransfer {
    private String t_id=null;
    private String bno=null;
    private String n_room=null;
    private String p_room=null;
    private String t_date=null;
    private String t_reason=null;

    public RoomTransfer(String id,String bno,String p_room,String n_room,String t_date,String t_reason) {
        
        this.t_id=id;
        this.bno=bno;
        this.p_room=p_room;
        this.n_room=n_room;
        this.t_date=t_date;
        this.t_reason=t_reason;
        
    }

    public String getT_id() {
        return t_id;
    }

    public String getBno() {
        return bno;
    }

    public String getN_room() {
        return n_room;
    }

    public String getP_room() {
        return p_room;
    }

    public String getT_date() {
        return t_date;
    }

    public String getT_reason() {
        return t_reason;
    }

   
    
    
    
}
