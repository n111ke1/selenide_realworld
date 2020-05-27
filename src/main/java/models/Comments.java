package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Comments {

    @JsonProperty
    private Long id;
    @JsonProperty
    private String createdAt;
    @JsonProperty
    private String updatedAt;
    @JsonProperty
    private String body;




}
