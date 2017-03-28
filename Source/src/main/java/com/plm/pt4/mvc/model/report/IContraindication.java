package com.plm.pt4.mvc.model.report;

import java.util.List;

import com.plmlatina.model.ActiveSubstanceContraindication_;
import com.plmlatina.model.ContraindicationComment__;
import com.plmlatina.model.HypersensibilityContraindication__;
import com.plmlatina.model.ICDContraindication__;
import com.plmlatina.model.OtherContraindication__;
import com.plmlatina.model.PharmacologicalGroupContraindication__;
import com.plmlatina.model.PhysiologicalContraindication__;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class IContraindication {
	private String description;
	private List<ICDContraindication__> icdContraindication;
	private List<PharmacologicalGroupContraindication__>  pharmaGroup;
	private List<PhysiologicalContraindication__> physiological;
	private List<HypersensibilityContraindication__> hypersensibility;
	private List<ActiveSubstanceContraindication_> activeSubstance;
	private List<OtherContraindication__> other;
	private List<ContraindicationComment__> comment;
	
	public IContraindication(){
		
	}
	
	public IContraindication(String description, List<ICDContraindication__> icdContraindication,
			List<PharmacologicalGroupContraindication__> pharmaGroup,
			List<PhysiologicalContraindication__> physiological,
			List<HypersensibilityContraindication__> hypersensibility,
			List<ActiveSubstanceContraindication_> activeSubstance, List<OtherContraindication__> other,
			List<ContraindicationComment__> comment) {
		this.description = description;
		this.icdContraindication = icdContraindication;
		this.pharmaGroup = pharmaGroup;
		this.physiological = physiological;
		this.hypersensibility = hypersensibility;
		this.activeSubstance = activeSubstance;
		this.other = other;
		this.comment = comment;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<ICDContraindication__> getIcdContraindication() {
		return icdContraindication;
	}
	public void setIcdContraindication(List<ICDContraindication__> icdContraindication) {
		this.icdContraindication = icdContraindication;
	}
	public List<PharmacologicalGroupContraindication__> getPharmaGroup() {
		return pharmaGroup;
	}
	public void setPharmaGroup(List<PharmacologicalGroupContraindication__> pharmaGroup) {
		this.pharmaGroup = pharmaGroup;
	}
	public List<PhysiologicalContraindication__> getPhysiological() {
		return physiological;
	}
	public void setPhysiological(List<PhysiologicalContraindication__> physiological) {
		this.physiological = physiological;
	}
	public List<HypersensibilityContraindication__> getHypersensibility() {
		return hypersensibility;
	}
	public void setHypersensibility(List<HypersensibilityContraindication__> hypersensibility) {
		this.hypersensibility = hypersensibility;
	}
	public List<ActiveSubstanceContraindication_> getActiveSubstance() {
		return activeSubstance;
	}
	public void setActiveSubstance(List<ActiveSubstanceContraindication_> activeSubstance) {
		this.activeSubstance = activeSubstance;
	}
	public List<OtherContraindication__> getOther() {
		return other;
	}
	public void setOther(List<OtherContraindication__> other) {
		this.other = other;
	}
	public List<ContraindicationComment__> getComment() {
		return comment;
	}
	public void setComment(List<ContraindicationComment__> comment) {
		this.comment = comment;
	}

	//JASPER REPORT
	public JRDataSource getIcdContraindicationsDS() {
		return new JRBeanCollectionDataSource(icdContraindication, false);
	}

	public JRDataSource getPharmaGroupDS() {
		return new JRBeanCollectionDataSource(pharmaGroup, false);
	}

	public JRDataSource getPhysiologicalDS() {
		return new JRBeanCollectionDataSource(physiological, false);
	}

	public JRDataSource getHypersensibilityDS() {
		return new JRBeanCollectionDataSource(hypersensibility, false);
	}

	public JRDataSource getActiveSubstanceDS() {
		return new JRBeanCollectionDataSource(activeSubstance, false);
	}

	public JRDataSource getOtherDS() {
		return new JRBeanCollectionDataSource(other, false);
	}

	public JRDataSource getCommentDS() {
		return new JRBeanCollectionDataSource(comment, false);
	}
	

}
