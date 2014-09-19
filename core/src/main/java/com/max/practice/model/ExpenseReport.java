package com.max.practice.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mmukhanov on 04.09.2014.
 */
public class ExpenseReport {

    private List<Record> records;
    private BigDecimal totalMeals;
    private BigDecimal totalHotels;
    private BigDecimal totalTransport;
    private BigDecimal total;

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public BigDecimal getTotalMeals() {
        return totalMeals;
    }

    public void setTotalMeals(BigDecimal totalMeals) {
        this.totalMeals = totalMeals;
    }

    public BigDecimal getTotalHotels() {
        return totalHotels;
    }

    public void setTotalHotels(BigDecimal totalHotels) {
        this.totalHotels = totalHotels;
    }

    public BigDecimal getTotalTransport() {
        return totalTransport;
    }

    public void setTotalTransport(BigDecimal totalTransport) {
        this.totalTransport = totalTransport;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public static class Record {
        private String city;
        private List<Item> items = new ArrayList<Item>();
        private BigDecimal totalMeals;
        private BigDecimal totalHotels;
        private BigDecimal totalTransport;
        private BigDecimal total;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public List<Item> getItems() {
            return items;
        }

        public void addItem(Item item) {
            this.items.add(item);
        }

        public BigDecimal getTotalMeals() {
            return totalMeals;
        }

        public void setTotalMeals(BigDecimal totalMeals) {
            this.totalMeals = totalMeals;
        }

        public BigDecimal getTotalHotels() {
            return totalHotels;
        }

        public void setTotalHotels(BigDecimal totalHotels) {
            this.totalHotels = totalHotels;
        }

        public BigDecimal getTotalTransport() {
            return totalTransport;
        }

        public void setTotalTransport(BigDecimal totalTransport) {
            this.totalTransport = totalTransport;
        }

        public BigDecimal getTotal() {
            return total;
        }

        public void setTotal(BigDecimal total) {
            this.total = total;
        }
    }

    public static class Item {
        private Date date;
        private BigDecimal meals;
        private BigDecimal hotels;
        private BigDecimal transport;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public BigDecimal getMeals() {
            return meals;
        }

        public void setMeals(BigDecimal meals) {
            this.meals = meals;
        }

        public BigDecimal getHotels() {
            return hotels;
        }

        public void setHotels(BigDecimal hotels) {
            this.hotels = hotels;
        }

        public BigDecimal getTransport() {
            return transport;
        }

        public void setTransport(BigDecimal transport) {
            this.transport = transport;
        }
    }
}


