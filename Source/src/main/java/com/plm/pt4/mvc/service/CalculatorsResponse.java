
package com.plm.pt4.mvc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.plm.pt4.mvc.model.Calculator;
import com.plm.pt4.mvc.model.CalculatorsByCategory;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "calculatorsByCategories"
})
public class CalculatorsResponse {

    @JsonProperty("calculatorsByCategories")
    private List<CalculatorsByCategory> calculatorsByCategories = new ArrayList<CalculatorsByCategory>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CalculatorsResponse() {
    }

    /**
     * 
     * @param calculatorsByCategories
     */
    public CalculatorsResponse(List<CalculatorsByCategory> calculatorsByCategories) {
        this.calculatorsByCategories = calculatorsByCategories;
    }

    /**
     * 
     * @return
     *     The calculatorsByCategories
     */
    @JsonProperty("calculatorsByCategories")
    public List<CalculatorsByCategory> getCalculatorsByCategories() {
    	
    	List<CalculatorsByCategory> calculatorsByCategories = new ArrayList<CalculatorsByCategory>();
    	CalculatorsByCategory calculatorsByCategory1 = new CalculatorsByCategory();
    	
    	//Categorias
    	calculatorsByCategory1.setShowBycategory(false);
    	calculatorsByCategory1.setCategoryActive(true);
    	calculatorsByCategory1.setCategoryName("");
    	calculatorsByCategory1.setCategoryId(1);
    	calculatorsByCategory1.setCategotyPath("");
    	List<Calculator> calculators = new ArrayList<Calculator>();
    	
    	//calculadoras
    	Calculator calculator1 = new Calculator();
    	calculator1.setActive(true);
    	calculator1.setId(1);
    	calculator1.setName("Indice de Masa Corporal (IMC)");
    	calculator1.setPath("indice-de-masa-corporal");
    	Calculator calculator2 = new Calculator();
    	calculator2.setActive(true);
    	calculator2.setId(2);
    	calculator2.setName("Osmolaridad Plasmática");
    	calculator2.setPath("osmolaridad-plasmatica");
    	Calculator calculator3 = new Calculator();
    	calculator3.setActive(true);
    	calculator3.setId(3);
    	calculator3.setName("Conversión microgotas a mililitros");
    	calculator3.setPath("conversion-microgotas-a-mililitros");
    	Calculator calculator4 = new Calculator();
    	calculator4.setActive(true);
    	calculator4.setId(4);
    	calculator4.setName("Conversión mililitros a microgotas");
    	calculator4.setPath("conversion-mililitros-a-microgotas");
    	Calculator calculator5 = new Calculator();
    	calculator5.setActive(true);
    	calculator5.setId(5);
    	calculator5.setName("Conversión mililitros/minuto a microgotas/hora");
    	calculator5.setPath("conversion-mililitros-minuto-a-microgotas-hora");
    	Calculator calculator6 = new Calculator();
    	calculator6.setActive(true);
    	calculator6.setId(6);
    	calculator6.setName("Superficie Corporal");
    	calculator6.setPath("superficie-corporal");
    	Calculator calculator7 = new Calculator();
    	calculator7.setActive(true);
    	calculator7.setId(7);
    	calculator7.setName("Aclaramiento de Creatinina");
    	calculator7.setPath("aclaramiento-de-creatinina");
    	Calculator calculator8 = new Calculator();
    	calculator8.setActive(true);
    	calculator8.setId(8);
    	calculator8.setName("Excreción de Creatinina");
    	calculator8.setPath("excrecion-de-creatinina");
    	Calculator calculator9 = new Calculator();
    	calculator9.setActive(true);
    	calculator9.setId(9);
    	calculator9.setName("Conversión de g/l a mg/dl");
    	calculator9.setPath("conversion-de-g-l-a-mg-dl");
    	Calculator calculator10 = new Calculator();
    	calculator10.setActive(true);
    	calculator10.setId(10);
    	calculator10.setName("Conversión de mg/dl a g/l");
    	calculator10.setPath("conversion-de-mg-dl-a-g-l");
    	Calculator calculator11 = new Calculator();
    	calculator11.setActive(true);
    	calculator11.setId(11);
    	calculator11.setName("Fracción de Excreción de Sodio (FENa) en %");
    	calculator11.setPath("fraccion-de-excrecion-de-sodio");
    	Calculator calculator12 = new Calculator();
    	calculator12.setActive(true);
    	calculator12.setId(12);
    	calculator12.setName("Gradiente Transtubular de Potasio (TTKG) en %");
    	calculator12.setPath("gradiente-transtubular-de-potasio");
    	Calculator calculator13 = new Calculator();
    	calculator13.setActive(true);
    	calculator13.setId(13);
    	calculator13.setName("Tasa de Metabolismo Basal (Fórmula Harris-Benedict)");
    	calculator13.setPath("tasa-de-metabolismo-basal");
    	Calculator calculator14 = new Calculator();
    	calculator14.setActive(true);
    	calculator14.setId(14);
    	calculator14.setName("Presion Arterial Media");
    	calculator14.setPath("presion-arterial-media");
    	Calculator calculator15 = new Calculator();
    	calculator15.setActive(true);
    	calculator15.setId(15);
    	calculator15.setName("Concentración Total del Calcio corregida (mg/dl)");
    	calculator15.setPath("concentracion-total-del-calcio-corregida");
    	Calculator calculator16 = new Calculator();
    	calculator16.setActive(true);
    	calculator16.setId(16);
    	calculator16.setName("Curvas de crecimiento y desarrollo en Pediatría");
    	calculator16.setPath("curvas-de-crecimiento-y-desarrollo-en-pediatria");
    	
    	
    	//Agregar calculadoras
    	calculators.add(calculator1);
    	calculators.add(calculator2);
    	calculators.add(calculator3);
    	calculators.add(calculator4);
    	calculators.add(calculator5);
    	calculators.add(calculator6);
    	calculators.add(calculator7);
    	calculators.add(calculator8);
    	calculators.add(calculator9);
    	calculators.add(calculator10);
    	calculators.add(calculator11);
    	calculators.add(calculator12);
    	calculators.add(calculator13);
    	calculators.add(calculator14);
    	calculators.add(calculator15);
    	calculators.add(calculator16);
    	
    	
    	calculatorsByCategory1.setCalculators(calculators);
    	
    	//Agregar categorias
    	calculatorsByCategories.add(calculatorsByCategory1);
    	
        return calculatorsByCategories;
    }

    /**
     * 
     * @param calculatorsByCategories
     *     The calculatorsByCategories
     */
    @JsonProperty("calculatorsByCategories")
    public void setCalculatorsByCategories(List<CalculatorsByCategory> calculatorsByCategories) {
        this.calculatorsByCategories = calculatorsByCategories;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
