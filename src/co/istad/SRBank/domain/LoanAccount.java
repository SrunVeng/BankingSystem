package co.istad.SRBank.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanAccount {
    private int loanAccNum;
    private BigDecimal interest;
    private BigDecimal amount;
    private BigDecimal outStanding;
    private int term;
    private LocalDate createOnl;
    private Staff staffId;
    private CustomerCif cifNumber;

    public LoanAccount() {

    }

    public int getLoanAccNum() {
        return loanAccNum;
    }

    public void setLoanAccNum(int loanAccNum) {
        this.loanAccNum = loanAccNum;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getOutStanding() {
        return outStanding;
    }

    public void setOutStanding(BigDecimal outStanding) {
        this.outStanding = outStanding;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
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
        return  "LoanAccountNumber" + loanAccNum +
                ", Interest=" + interest +
                ", Amount=" + amount +
                ", OutStanding=" + outStanding +
                ", Term=" + term +
                ", CreateOnl=" + createOnl +
                ", StaffId=" + staffId +
                ", CIFNumber=" + cifNumber
                ;
    }
}
