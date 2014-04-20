package de.scheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trainingrequirements")
public class TrainingRequirements {
	
	@Id
	@Column(name = "ResidentName")
	private String residentName; //Suppose it's nickname of residents
	
	@Column(name = "SPeriod")
	private Integer startPeriod;
	
	@Column(name = "EPeriod")
	private Integer endPeriod;
	
	@Column(name = "S1")
	private Integer surgeryNo1;
	
	@Column(name = "S2")
	private Integer surgeryNo2;
	
	@Column(name = "S3")
	private Integer surgeryNo3;
	
	@Column(name = "S4")
	private Integer surgeryNo4;
	
	@Column(name = "S5")
	private Integer surgeryNo5;
	
	@Column(name = "S6")
	private Integer surgeryNo6;
	
	@Column(name = "S7")
	private Integer surgeryNo7;
	
	@Column(name = "S8")
	private Integer surgeryNo8;
	
	@Column(name = "S9")
	private Integer surgeryNo9;
	
	@Column(name = "S10")
	private Integer surgeryNo10;
	
	@Column(name = "S11")
	private Integer surgeryNo11;
	
	@Column(name = "S12")
	private Integer surgeryNo12;
	
	@Column(name = "S13")
	private Integer surgeryNo13;
	
	@Column(name = "S14")
	private Integer surgeryNo14;
	
	@Column(name = "P0")
	private Integer p0;
	
	@Column(name = "P1")
	private Integer p1; //period1
	
	@Column(name = "P2")
	private Integer p2;
	
	@Column(name = "P3")
	private Integer p3;
	
	@Column(name = "P4")
	private Integer p4;
	
	@Column(name = "P5")
	private Integer p5;
	
	@Column(name = "P6")
	private Integer p6;
	
	@Column(name = "P7")
	private Integer p7;
	
	@Column(name = "P8")
	private Integer p8;
	
	@Column(name = "P9")
	private Integer p9;
	
	@Column(name = "P10")
	private Integer p10;
	
	@Column(name = "P11")
	private Integer p11;
	
	@Column(name = "P12")
	private Integer p12;
	
	@Column(name = "P13")
	private Integer p13;
	
	@Column(name = "P14")
	private Integer p14;
	
	@Column(name = "P15")
	private Integer p15;
	
	@Column(name = "P16")
	private Integer p16;
	
	@Column(name = "P17")
	private Integer p17;
	
	@Column(name = "P18")
	private Integer p18;
	
	@Column(name = "P19")
	private Integer p19;

	public String getResidentName() {
		return residentName;
	}

	public void setResidentName(String residentName) {
		this.residentName = residentName;
	}

	public Integer getStartPeriod() {
		return startPeriod;
	}

	public void setStartPeriod(Integer startPeriod) {
		this.startPeriod = startPeriod;
	}

	public Integer getEndPeriod() {
		return endPeriod;
	}

	public void setEndPeriod(Integer endPeriod) {
		this.endPeriod = endPeriod;
	}

	public Integer getSurgeryNo1() {
		return surgeryNo1;
	}

	public void setSurgeryNo1(Integer surgeryNo1) {
		this.surgeryNo1 = surgeryNo1;
	}

	public Integer getSurgeryNo2() {
		return surgeryNo2;
	}

	public void setSurgeryNo2(Integer surgeryNo2) {
		this.surgeryNo2 = surgeryNo2;
	}

	public Integer getSurgeryNo3() {
		return surgeryNo3;
	}

	public void setSurgeryNo3(Integer surgeryNo3) {
		this.surgeryNo3 = surgeryNo3;
	}

	public Integer getSurgeryNo4() {
		return surgeryNo4;
	}

	public void setSurgeryNo4(Integer surgeryNo4) {
		this.surgeryNo4 = surgeryNo4;
	}

	public Integer getSurgeryNo5() {
		return surgeryNo5;
	}

	public void setSurgeryNo5(Integer surgeryNo5) {
		this.surgeryNo5 = surgeryNo5;
	}

	public Integer getSurgeryNo6() {
		return surgeryNo6;
	}

	public void setSurgeryNo6(Integer surgeryNo6) {
		this.surgeryNo6 = surgeryNo6;
	}

	public Integer getSurgeryNo7() {
		return surgeryNo7;
	}

	public void setSurgeryNo7(Integer surgeryNo7) {
		this.surgeryNo7 = surgeryNo7;
	}

	public Integer getSurgeryNo8() {
		return surgeryNo8;
	}

	public void setSurgeryNo8(Integer surgeryNo8) {
		this.surgeryNo8 = surgeryNo8;
	}

	public Integer getSurgeryNo9() {
		return surgeryNo9;
	}

	public void setSurgeryNo9(Integer surgeryNo9) {
		this.surgeryNo9 = surgeryNo9;
	}

	public Integer getSurgeryNo10() {
		return surgeryNo10;
	}

	public void setSurgeryNo10(Integer surgeryNo10) {
		this.surgeryNo10 = surgeryNo10;
	}

	public Integer getSurgeryNo11() {
		return surgeryNo11;
	}

	public void setSurgeryNo11(Integer surgeryNo11) {
		this.surgeryNo11 = surgeryNo11;
	}

	public Integer getSurgeryNo12() {
		return surgeryNo12;
	}

	public void setSurgeryNo12(Integer surgeryNo12) {
		this.surgeryNo12 = surgeryNo12;
	}

	public Integer getSurgeryNo13() {
		return surgeryNo13;
	}

	public void setSurgeryNo13(Integer surgeryNo13) {
		this.surgeryNo13 = surgeryNo13;
	}

	public Integer getSurgeryNo14() {
		return surgeryNo14;
	}

	public void setSurgeryNo14(Integer surgeryNo14) {
		this.surgeryNo14 = surgeryNo14;
	}

	public Integer getP0() {
		return p0;
	}

	public void setP0(Integer p0) {
		this.p0 = p0;
	}

	public Integer getP1() {
		return p1;
	}

	public void setP1(Integer p1) {
		this.p1 = p1;
	}

	public Integer getP2() {
		return p2;
	}

	public void setP2(Integer p2) {
		this.p2 = p2;
	}

	public Integer getP3() {
		return p3;
	}

	public void setP3(Integer p3) {
		this.p3 = p3;
	}

	public Integer getP4() {
		return p4;
	}

	public void setP4(Integer p4) {
		this.p4 = p4;
	}

	public Integer getP5() {
		return p5;
	}

	public void setP5(Integer p5) {
		this.p5 = p5;
	}

	public Integer getP6() {
		return p6;
	}

	public void setP6(Integer p6) {
		this.p6 = p6;
	}

	public Integer getP7() {
		return p7;
	}

	public void setP7(Integer p7) {
		this.p7 = p7;
	}

	public Integer getP8() {
		return p8;
	}

	public void setP8(Integer p8) {
		this.p8 = p8;
	}

	public Integer getP9() {
		return p9;
	}

	public void setP9(Integer p9) {
		this.p9 = p9;
	}

	public Integer getP10() {
		return p10;
	}

	public void setP10(Integer p10) {
		this.p10 = p10;
	}

	public Integer getP11() {
		return p11;
	}

	public void setP11(Integer p11) {
		this.p11 = p11;
	}

	public Integer getP12() {
		return p12;
	}

	public void setP12(Integer p12) {
		this.p12 = p12;
	}

	public Integer getP13() {
		return p13;
	}

	public void setP13(Integer p13) {
		this.p13 = p13;
	}

	public Integer getP14() {
		return p14;
	}

	public void setP14(Integer p14) {
		this.p14 = p14;
	}

	public Integer getP15() {
		return p15;
	}

	public void setP15(Integer p15) {
		this.p15 = p15;
	}

	public Integer getP16() {
		return p16;
	}

	public void setP16(Integer p16) {
		this.p16 = p16;
	}

	public Integer getP17() {
		return p17;
	}

	public void setP17(Integer p17) {
		this.p17 = p17;
	}

	public Integer getP18() {
		return p18;
	}

	public void setP18(Integer p18) {
		this.p18 = p18;
	}

	public Integer getP19() {
		return p19;
	}

	public void setP19(Integer p19) {
		this.p19 = p19;
	}

}
