package com.example.pocFavorecido;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * Created by ricardo on 05/01/18.
 */
@Document
public class Favorecido {

    @NotNull(message = "Valor informado invalido!")
    private String idtUser;

    @NotNull(message = "Valor informado invalido!")
    private String featureName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String,Object> metaData;


    public String getIdtUser() {
        return idtUser;
    }

    public void setIdtUser(String idtUser) {
        this.idtUser = idtUser;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public Map<String, Object> getMetaData() {
        return metaData;
    }

    public void setMetaData(Map<String, Object> metaData) {
        this.metaData = metaData;
    }
}
