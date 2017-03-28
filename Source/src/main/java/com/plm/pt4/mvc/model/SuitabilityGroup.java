package com.plm.pt4.mvc.model;

import com.plmlatina.result.ContraindicationsByProductsResponse;
import com.plmlatina.result.IMDDIProductInteractionSubstancesResponse;
import com.plmlatina.result.InteractionsByEditionProductsResponse;
import com.plmlatina.result.MealInteractionsByProductsResponse;

public class SuitabilityGroup {
                private ContraindicationsByProductsResponse[] contraindicationsByProducts;
                private InteractionsByEditionProductsResponse[] interactionsByEditionProducts;
                private MealInteractionsByProductsResponse[] mealInteractionsByProducts;
                private IMDDIProductInteractionSubstancesResponse[] IMDDIProductInteractionSubstances;
                
                public SuitabilityGroup(){
                               
                }
                
                public SuitabilityGroup(ContraindicationsByProductsResponse[] contraindicationsByProducts,InteractionsByEditionProductsResponse[] interactionsByEditionProducts,MealInteractionsByProductsResponse[] mealInteractionsByProducts,IMDDIProductInteractionSubstancesResponse[] iMDDIProductInteractionSubstances) {
                               super();
                               this.contraindicationsByProducts = contraindicationsByProducts;
                               this.interactionsByEditionProducts = interactionsByEditionProducts;
                               this.mealInteractionsByProducts = mealInteractionsByProducts;
                               IMDDIProductInteractionSubstances = iMDDIProductInteractionSubstances;
                }

                public ContraindicationsByProductsResponse[] getContraindicationsByProducts() {
                               return contraindicationsByProducts;
                }

                public void setContraindicationsByProducts(ContraindicationsByProductsResponse[] contraindicationsByProducts) {
                               this.contraindicationsByProducts = contraindicationsByProducts;
                }

                public InteractionsByEditionProductsResponse[] getInteractionsByEditionProducts() {
                               return interactionsByEditionProducts;
                }

                public void setInteractionsByEditionProducts(InteractionsByEditionProductsResponse[] interactionsByEditionProducts) {
                               this.interactionsByEditionProducts = interactionsByEditionProducts;
                }

                public MealInteractionsByProductsResponse[] getMealInteractionsByProducts() {
                               return mealInteractionsByProducts;
                }

                public void setMealInteractionsByProducts(MealInteractionsByProductsResponse[] mealInteractionsByProducts) {
                               this.mealInteractionsByProducts = mealInteractionsByProducts;
                }

                public IMDDIProductInteractionSubstancesResponse[] getIMDDIProductInteractionSubstances() {
                               return IMDDIProductInteractionSubstances;
                }

                public void setIMDDIProductInteractionSubstances(
                                               IMDDIProductInteractionSubstancesResponse[] iMDDIProductInteractionSubstances) {
                                IMDDIProductInteractionSubstances = iMDDIProductInteractionSubstances;
                }
                
                
                
                

}
