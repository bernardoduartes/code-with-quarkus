package br.com.bds.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Product extends PanacheEntity {
    public String name;
    public BigDecimal price;
    @CreationTimestamp
    public Date createAt;
    @UpdateTimestamp
    public Date updatedAt;
}
