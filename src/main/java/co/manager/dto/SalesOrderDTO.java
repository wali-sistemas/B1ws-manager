package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesOrderDTO implements Serializable {
    @JsonProperty("cardCode")
    private String cardCode;
    @JsonProperty("comments")
    private String comments;
    @JsonProperty("companyName")
    private String companyName;
    @JsonProperty("numAtCard")
    private String numAtCard;
    @JsonProperty("idTransport")
    private String idTransport;
    @JsonProperty("status")
    private String status;
    @JsonProperty("confirmed")
    private String confirmed;
    @JsonProperty("startDatePack")
    private String startDatePack;
    @JsonProperty("shipToCode")
    private String shipToCode;
    @JsonProperty("payToCode")
    private String payToCode;
    @JsonProperty("serialMDL")
    private String serialMDL;
    @JsonProperty("slpCode")
    private Long slpCode;
    @JsonProperty("discountPercent")
    private Double discountPercent;
    @JsonProperty("detailSalesOrder")
    private List<DetailSalesOrderDTO> detailSalesOrder;

    public SalesOrderDTO() {
        setDetailSalesOrder(new ArrayList<>());
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<DetailSalesOrderDTO> getDetailSalesOrder() {
        return detailSalesOrder;
    }

    public void setDetailSalesOrder(List<DetailSalesOrderDTO> detailSalesOrder) {
        this.detailSalesOrder = detailSalesOrder;
    }

    public String getNumAtCard() {
        return numAtCard;
    }

    public void setNumAtCard(String numAtCard) {
        this.numAtCard = numAtCard;
    }

    public String getIdTransport() {
        return idTransport;
    }

    public void setIdTransport(String idTransport) {
        this.idTransport = idTransport;
    }

    public Long getSlpCode() {
        return slpCode;
    }

    public void setSlpCode(Long slpCode) {
        this.slpCode = slpCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getStartDatePack() {
        return startDatePack;
    }

    public void setStartDatePack(String startDatePack) {
        this.startDatePack = startDatePack;
    }

    public String getShipToCode() {
        return shipToCode;
    }

    public void setShipToCode(String shipToCode) {
        this.shipToCode = shipToCode;
    }

    public String getPayToCode() {
        return payToCode;
    }

    public void setPayToCode(String payToCode) {
        this.payToCode = payToCode;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getSerialMDL() {
        return serialMDL;
    }

    public void setSerialMDL(String serialMDL) {
        this.serialMDL = serialMDL;
    }

    @Override
    public String toString() {
        return "SalesOrderDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", comments='" + comments + '\'' +
                ", companyName='" + companyName + '\'' +
                ", numAtCard='" + numAtCard + '\'' +
                ", idTransport='" + idTransport + '\'' +
                ", status='" + status + '\'' +
                ", confirmed='" + confirmed + '\'' +
                ", startDatePack='" + startDatePack + '\'' +
                ", shipToCode='" + shipToCode + '\'' +
                ", payToCode='" + payToCode + '\'' +
                ", serialMDL='" + serialMDL + '\'' +
                ", slpCode=" + slpCode +
                ", discountPercent=" + discountPercent +
                ", detailSalesOrder=" + detailSalesOrder +
                '}';
    }
}