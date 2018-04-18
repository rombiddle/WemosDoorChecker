package com.entreprise.davfou.projectporte.utilsRecyclerView;

public class DataDoor {
    int acy;
    int acx;
    int acz;
    float tmp;
    int gyx;
    int gyy;
    int light;
    String timestmp;
    int id_wemos;

    public DataDoor(int acy, int acx, int acz, float tmp, int gyx, int gyy, int light, String timestmp, int id_wemos) {
        this.acy = acy;
        this.acx = acx;
        this.acz = acz;
        this.tmp = tmp;
        this.gyx = gyx;
        this.gyy = gyy;
        this.light = light;
        this.timestmp = timestmp;
        this.id_wemos = id_wemos;
    }

    public int getAcy() {
        return acy;
    }

    public void setAcy(int acy) {
        this.acy = acy;
    }

    public int getAcx() {
        return acx;
    }

    public void setAcx(int acx) {
        this.acx = acx;
    }

    public int getAcz() {
        return acz;
    }

    public void setAcz(int acz) {
        this.acz = acz;
    }

    public float getTmp() {
        return tmp;
    }

    public void setTmp(float tmp) {
        this.tmp = tmp;
    }

    public int getGyx() {
        return gyx;
    }

    public void setGyx(int gyx) {
        this.gyx = gyx;
    }

    public int getGyy() {
        return gyy;
    }

    public void setGyy(int gyy) {
        this.gyy = gyy;
    }

    public int getLight() {
        return light;
    }

    public void setLight(int light) {
        this.light = light;
    }

    public String getTimestmp() {
        return timestmp;
    }

    public void setTimestmp(String timestmp) {
        this.timestmp = timestmp;
    }

    public int getId_wemos() {
        return id_wemos;
    }

    public void setId_wemos(int id_wemos) {
        this.id_wemos = id_wemos;
    }
}
