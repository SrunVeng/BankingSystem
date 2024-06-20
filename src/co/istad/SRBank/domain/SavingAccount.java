package co.istad.SRBank.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SavingAccount {

    private int savingAccNum;
    private BigDecimal interest;
    private BigDecimal balance;
    private LocalDate createOnl;
    private Staff staffId;
    private CustomerCif cifNumber;

    public SavingAccount() {
    }

    public int getSavingAccNum() {
        return savingAccNum;
    }

    public void setSavingAccNum(int savingAccNum) {
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

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    public CustomerCif getCifNumber() {
        return cifNumber;
    }

    public void setCifNumber(CustomerCif cifNumber) {
        this.cifNumber = cifNumber;
    }

    @Override
    public String toString() {
        return
                "AccountNumber=" + savingAccNum +
                ", Interest=" + interest +
                ", Balance=" + balance +
                ", CreatedDate=" + createOnl +
                ", Staffid=" + staffId +
                ", CIFnumber=" + cifNumber
                ;
    }

}
