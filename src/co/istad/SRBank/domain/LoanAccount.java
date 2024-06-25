package co.istad.SRBank.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanAccount {
    private long loanAccNum;
    private BigDecimal interest;
    private BigDecimal amount;
    private BigDecimal outStanding;
    private int term;
    private LocalDate createOnl;
    private int staffId;
    private int cifNumber;

    public LoanAccount() {

    }

    public long getLoanAccNum() {
        return loanAccNum;
    }

    public void setLoanAccNum(long loanAccNum) {
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
        return  "Loan AccountNumber" + loanAccNum +
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
