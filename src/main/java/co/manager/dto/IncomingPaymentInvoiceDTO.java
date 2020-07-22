package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncomingPaymentInvoiceDTO {
    private long docEntry;
    private Integer lineNum;
    private BigDecimal sumApplied;

    public IncomingPaymentInvoiceDTO() {
    }

    public IncomingPaymentInvoiceDTO(long docEntry, Integer lineNum, BigDecimal sumApplied) {
        this.docEntry = docEntry;
        this.lineNum = lineNum;
        this.sumApplied = sumApplied;
    }

    public long getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(long docEntry) {
        this.docEntry = docEntry;
    }

    public Integer getLineNum() {
        return lineNum;
    }

    public void setLineNum(Integer lineNum) {
        this.lineNum = lineNum;
    }

    public BigDecimal getSumApplied() {
        return sumApplied;
    }

    public void setSumApplied(BigDecimal sumApplied) {
        this.sumApplied = sumApplied;
    }

    @Override
    public String toString() {
        return "IncomingPaymentInvoiceDTO{" +
                "docEntry=" + docEntry +
                ", lineNum=" + lineNum +
                ", sumApplied=" + sumApplied +
                '}';
    }
}