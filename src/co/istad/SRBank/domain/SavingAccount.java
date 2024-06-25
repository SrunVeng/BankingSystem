package co.istad.SRBank.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SavingAccount {

    private Long savingAccNum;
    private BigDecimal interest;
    private BigDecimal balance;
    private LocalDate createOnl;
    private int staffId;
    private int cifNumber;

    public SavingAccount() {
    }

    public Long getSavingAccNum() {
        return savingAccNum;
    }

    public void setSavingAccNum(Long savingAccNum) {
        this.savingAccNum = savingAccNum;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDate getCreateOnl() {
        return createOnl;
    }

    public void setCreateOnl(LocalDate createOnl) {
        this.createOnl = createOnl;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getCifNumber() {
        return cifNumber;
    }

    public void setCifNumber(int cifNumber) {
        this.cifNumber = cifNumber;
    }

    @Override
    public String toString() {
        return
                "Saving AccountNumber=" + savingAccNum +
                ", Interest=" + interest +
                ", Balance=" + balance +
                ", CreatedDate=" + createOnl +
                ", Staffid=" + staffId +
                ", CIFnumber=" + cifNumber
                ;
    }

}
