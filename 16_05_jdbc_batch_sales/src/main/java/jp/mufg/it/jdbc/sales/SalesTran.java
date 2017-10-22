package jp.mufg.it.jdbc.sales;

import java.util.Date;

public class SalesTran {
    private Integer salesId;
    private Date salesDate;
    private Date dueDate;
    private Integer branchId;
    private Integer customerId;
    private Integer staffInCharge;
    private Integer updateStockFlag;

    public Integer getSalesId() {
        return salesId;
    }

    public void setSalesId(Integer salesId) {
        this.salesId = salesId;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getStaffInCharge() {
        return staffInCharge;
    }

    public void setStaffInCharge(Integer staffInCharge) {
        this.staffInCharge = staffInCharge;
    }

    public Integer getUpdateStockFlag() {
        return updateStockFlag;
    }

    public void setUpdateStockFlag(Integer updateStockFlag) {
        this.updateStockFlag = updateStockFlag;
    }
}
