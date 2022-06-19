package exam.model.laptop;

import exam.model.shop.ShopNameDto;
import org.yaml.snakeyaml.util.EnumUtils;

import java.math.BigDecimal;

public class LaptopImportDto {
    private String macAddress;
    private float cpuSpeed;
    private int ram;
    private int storage;
    private String description;
    private BigDecimal price;
    private String warrantyType;
    private ShopNameDto shop;

    public LaptopImportDto(String macAddress, float cpuSpeed, int ram, int storage, String description, BigDecimal price, String warrantyType, ShopNameDto shop) {
        this.macAddress = macAddress;
        this.cpuSpeed = cpuSpeed;
        this.ram = ram;
        this.storage = storage;
        this.description = description;
        this.price = price;
        this.warrantyType = warrantyType;
        this.shop = shop;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public float getCpuSpeed() {
        return cpuSpeed;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getWarrantyType() {
        return warrantyType;
    }

    public ShopNameDto getShop() {
        return shop;
    }

    public boolean valid() {
        if (getMacAddress().length() < 8) return false;
        if (getCpuSpeed() <= 0) return false;
        if (getRam() < 8 || getRam() > 128) return false;
        if (getStorage() < 128 || getStorage() > 1024) return false;
        if (getDescription().length() < 10) return false;
        if (getPrice().doubleValue() <= 0) return false;
        for (WarrantyType wt : WarrantyType.values()) {
            if (wt.name().equals(getWarrantyType())){
                return true;
            }
        }
        return false;
    }
}
