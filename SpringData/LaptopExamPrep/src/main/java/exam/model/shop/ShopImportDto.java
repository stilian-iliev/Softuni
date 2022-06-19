package exam.model.shop;


import exam.model.town.TownNameDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class ShopImportDto {
    @XmlElement
    private String address;

    @XmlElement(name = "employee-count")
    private int employeeCount;

    @XmlElement
    private BigDecimal income;

    @XmlElement
    private String name;

    @XmlElement(name = "shop-area")
    private double shopArea;

    @XmlElement(name = "town")
    private TownNameDto town;

    public ShopImportDto() {
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShopArea(double shopArea) {
        this.shopArea = shopArea;
    }

    public void setTown(TownNameDto town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public String getName() {
        return name;
    }

    public double getShopArea() {
        return shopArea;
    }

    public TownNameDto getTown() {
        return town;
    }

    public boolean validate() {
        if (name.length() < 4) {
            return false;
        }
        if (income.intValue() < 20000) {
            return false;
        }
        if (address.length() < 4) {
            return false;
        }
        if (employeeCount < 1 || employeeCount> 50) {
            return false;
        }
        if (shopArea < 150) {
            return false;
        }
        return true;
    }
}
