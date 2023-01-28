package by.pakalo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

    private static final long serialVersionUID = -7458815776413099101L;

    private Long id;
    @JsonProperty("account_number")
    private Long accountNumber;
    @JsonProperty("account_owner")
    private String accountOwner;
    @JsonProperty("balance")
    private double balance;
}
