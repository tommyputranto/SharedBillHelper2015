package com.ericliudeveloper.sharedbillhelper.model;

import java.util.UUID;

public class PaymentInfo {

    public long getId() {
        return id;
    }

    private final long id;

    private final String serialNumber;

    private final String name;


    private String description;
    private final double totalAmount;
    private final int numberOfMembersPaid;
    private final int numberOfBillsPaid;
    private final String paidTime;

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    private int deleted = 0;


    public static class Builder {
        private long id = -100L;
        private String serialNumber;
        private String name;
        private String description;
        private double totalAmount;
        private int numberOfMembersPaid;
        private int numberOfBillsPaid;
        private String paidTime;
        private int deleted;

        public Builder() {

        }

        /**
         * only to be called when instantiating an instance from DB data
         * @param id
         * @return
         */
        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder totalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder numberOfMembersPaid(int number) {
            this.numberOfMembersPaid = number;
            return this;
        }

        public Builder numberOfBillsPaid(int number) {
            this.numberOfBillsPaid = number;
            return this;
        }

        public Builder paidTime(String time) {
            this.paidTime = time;
            return this;
        }


        /**
         * Add 1 to serial number everytime a new instance is created.
         *
         * @return
         */
        public PaymentInfo build() {
            // generate a unique identifier for every PaymentInfo instance
            this.serialNumber = UUID.randomUUID().toString();
            return new PaymentInfo(this);
        }

    }

    private PaymentInfo(Builder builder) {
        this.id = builder.id;
        this.serialNumber = builder.serialNumber;
        this.name = builder.name;
        this.description = builder.description;
        this.totalAmount = builder.totalAmount;
        this.numberOfMembersPaid = builder.numberOfMembersPaid;
        this.numberOfBillsPaid = builder.numberOfBillsPaid;
        this.paidTime = builder.paidTime;
        this.deleted = builder.deleted;

    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getNumberOfMembersPaid() {
        return numberOfMembersPaid;
    }

    public int getNumberOfBillsPaid() {
        return numberOfBillsPaid;
    }

    public String getPaidTime() {
        return paidTime;
    }


}
