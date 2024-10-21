/*
 * OpenAPI definition
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import org.openapitools.client.model.OrdineDto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * BillDto
 */
@JsonPropertyOrder({
  BillDto.JSON_PROPERTY_ID,
  BillDto.JSON_PROPERTY_DATE_BILL,
  BillDto.JSON_PROPERTY_TOTAL_AMOUNT,
  BillDto.JSON_PROPERTY_ORD
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-10-18T14:37:22.823946236Z[Etc/UTC]", comments = "Generator version: 7.10.0-SNAPSHOT")
public class BillDto {
  public static final String JSON_PROPERTY_ID = "id";
  @jakarta.annotation.Nullable
  private Long id;

  public static final String JSON_PROPERTY_DATE_BILL = "dateBill";
  @jakarta.annotation.Nullable
  private OffsetDateTime dateBill;

  public static final String JSON_PROPERTY_TOTAL_AMOUNT = "totalAmount";
  @jakarta.annotation.Nonnull
  private Double totalAmount;

  public static final String JSON_PROPERTY_ORD = "ord";
  @jakarta.annotation.Nullable
  private OrdineDto ord;

  public BillDto() {
  }

  public BillDto id(@jakarta.annotation.Nullable Long id) {
    
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(@jakarta.annotation.Nullable Long id) {
    this.id = id;
  }

  public BillDto dateBill(@jakarta.annotation.Nullable OffsetDateTime dateBill) {
    
    this.dateBill = dateBill;
    return this;
  }

  /**
   * Get dateBill
   * @return dateBill
   */
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DATE_BILL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getDateBill() {
    return dateBill;
  }


  @JsonProperty(JSON_PROPERTY_DATE_BILL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDateBill(@jakarta.annotation.Nullable OffsetDateTime dateBill) {
    this.dateBill = dateBill;
  }

  public BillDto totalAmount(@jakarta.annotation.Nonnull Double totalAmount) {
    
    this.totalAmount = totalAmount;
    return this;
  }

  /**
   * Get totalAmount
   * minimum: 0
   * @return totalAmount
   */
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TOTAL_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Double getTotalAmount() {
    return totalAmount;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTotalAmount(@jakarta.annotation.Nonnull Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public BillDto ord(@jakarta.annotation.Nullable OrdineDto ord) {
    
    this.ord = ord;
    return this;
  }

  /**
   * Get ord
   * @return ord
   */
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ORD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OrdineDto getOrd() {
    return ord;
  }


  @JsonProperty(JSON_PROPERTY_ORD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOrd(@jakarta.annotation.Nullable OrdineDto ord) {
    this.ord = ord;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillDto billDto = (BillDto) o;
    return Objects.equals(this.id, billDto.id) &&
        Objects.equals(this.dateBill, billDto.dateBill) &&
        Objects.equals(this.totalAmount, billDto.totalAmount) &&
        Objects.equals(this.ord, billDto.ord);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, dateBill, totalAmount, ord);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    dateBill: ").append(toIndentedString(dateBill)).append("\n");
    sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
    sb.append("    ord: ").append(toIndentedString(ord)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
