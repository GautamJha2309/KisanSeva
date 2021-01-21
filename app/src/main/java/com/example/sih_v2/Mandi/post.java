package com.example.sih_v2.Mandi;

public class post {
    String arrival_date;
    String commodity;
    String district;
    String market;
    String max_price;
    String min_price;
    String modal_price;
    String state;
    String variety;

    public post() {
    }

    @Override
    public String toString() {
        return "post{" +
                "arrival_date='" + arrival_date + '\'' +
                ", commodity='" + commodity + '\'' +
                ", district='" + district + '\'' +
                ", market='" + market + '\'' +
                ", max_price='" + max_price + '\'' +
                ", min_price='" + min_price + '\'' +
                ", modal_price='" + modal_price + '\'' +
                ", state='" + state + '\'' +
                ", variety='" + variety + '\'' +
                '}';
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getMax_price() {
        return max_price;
    }

    public void setMax_price(String max_price) {
        this.max_price = max_price;
    }

    public String getMin_price() {
        return min_price;
    }

    public void setMin_price(String min_price) {
        this.min_price = min_price;
    }

    public String getModal_price() {
        return modal_price;
    }

    public void setModal_price(String modal_price) {
        this.modal_price = modal_price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }
}
