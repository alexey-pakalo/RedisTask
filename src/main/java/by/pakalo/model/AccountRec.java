package by.pakalo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRec implements Serializable {

    private static final long serialVersionUID = -4528858434975515569L;
    
    @JsonProperty("accounts")
    List<Long> id;
}
