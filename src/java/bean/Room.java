/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author HP
 */
public class Room {
    private String rno;
    private String rtype;
    private String btype;
    private String status;
    
    public Room(String rno,String rtype,String btype,String status){
        this.rno=rno;
        this.rtype=rtype;
        this.btype=btype;
        this.status=status;
    }

    public String getRno() {
        return rno;
    }

    public String getRtype() {
        return rtype;
    }

    public String getBtype() {
        return btype;
    }

    public String getStatus() {
        return status;
    }
    
    
}
