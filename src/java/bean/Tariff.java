/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author JIPL1
 */
public class Tariff {
    
private String tariffid;
private String roomtype;
private String bedtype;
private String tariff;
private String description;

    public Tariff(String tariffid, String roomtype, String bedtype, String tariff, String description) {
        this.tariffid = tariffid;
        this.roomtype = roomtype;
        this.bedtype = bedtype;
        this.tariff = tariff;
        this.description = description;
    }

    public String getTariffid() {
        return tariffid;
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

    public String getDescription() {
        return description;
    }

}
