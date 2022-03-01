package othmen.test.openapigenerator.springdoc.demo.app4.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CoffeeOrder
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-01T17:18:18.345104400+01:00[Europe/Paris]")
public class CoffeeOrder   {

  @JsonProperty("coffeeId")
  private String coffeeId;

  @JsonProperty("whenOrdered")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime whenOrdered;

  public CoffeeOrder coffeeId(String coffeeId) {
    this.coffeeId = coffeeId;
    return this;
  }

  /**
   * Get coffeeId
   * @return coffeeId
  */
  
  @Schema(name = "coffeeId", required = false)
  public String getCoffeeId() {
    return coffeeId;
  }

  public void setCoffeeId(String coffeeId) {
    this.coffeeId = coffeeId;
  }

  public CoffeeOrder whenOrdered(OffsetDateTime whenOrdered) {
    this.whenOrdered = whenOrdered;
    return this;
  }

  /**
   * Get whenOrdered
   * @return whenOrdered
  */
  @Valid 
  @Schema(name = "whenOrdered", required = false)
  public OffsetDateTime getWhenOrdered() {
    return whenOrdered;
  }

  public void setWhenOrdered(OffsetDateTime whenOrdered) {
    this.whenOrdered = whenOrdered;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CoffeeOrder coffeeOrder = (CoffeeOrder) o;
    return Objects.equals(this.coffeeId, coffeeOrder.coffeeId) &&
        Objects.equals(this.whenOrdered, coffeeOrder.whenOrdered);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coffeeId, whenOrdered);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CoffeeOrder {\n");
    sb.append("    coffeeId: ").append(toIndentedString(coffeeId)).append("\n");
    sb.append("    whenOrdered: ").append(toIndentedString(whenOrdered)).append("\n");
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

