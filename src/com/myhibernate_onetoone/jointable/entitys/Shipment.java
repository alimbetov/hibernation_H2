package com.myhibernate_onetoone.jointable.entitys;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @NotNull
    protected Date createdOn = new Date();

    @NotNull
    protected ShipmentState shipmentState = ShipmentState.TRANSIT;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(
        name = "ITEM_SHIPMENT", // Required!
        joinColumns =
            @JoinColumn(name = "SHIPMENT_ID"),  // Defaults to ID
        inverseJoinColumns =
            @JoinColumn(name = "ITEM_ID",  // Defaults to AUCTION_ID
                        nullable = false,
                        unique = true)
    )
    protected Item auction;


    public Shipment() {
    }

    public Shipment(Item auction) {
        this.auction = auction;
    }

    public Long getId() {
        return id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public ShipmentState getShipmentState() {
        return shipmentState;
    }

    public void setShipmentState(ShipmentState shipmentState) {
        this.shipmentState = shipmentState;
    }

    public Item getAuction() {
        return auction;
    }

    public void setAuction(Item auction) {
        this.auction = auction;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                ", shipmentState=" + shipmentState +
                ", auction=" + auction +
                '}';
    }
}
