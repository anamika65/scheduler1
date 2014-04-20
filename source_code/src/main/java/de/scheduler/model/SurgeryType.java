package de.scheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Added from scheduler project of Claus
 * 
 * @author AnamikaChowdhury
 *
 */

@Entity
@Table(name = "surgerytype")
public class SurgeryType {
	
	@Id
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Type")
	private String type;
	
	@Column(name = "BlockSize")
	private Integer blockSize;
	
	@Column(name = "Mode")
	private Integer mode;
	
	@Column(name = "Easy")
	private Integer easy; //m0
	
	@Column(name = "Normal")
	private Integer normal; //m1 
	
	@Column(name = "Difficult")
	private Integer difficult; //m2
	
	@Column(name = "Phase")
	private String phase;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(Integer blockSize) {
		this.blockSize = blockSize;
	}

	public Integer getMode() {
		return mode;
	}

	public void setMode(Integer mode) {
		this.mode = mode;
	}

	public Integer getEasy() {
		return easy;
	}

	public void setEasy(Integer easy) {
		this.easy = easy;
	}

	public Integer getNormal() {
		return normal;
	}

	public void setNormal(Integer normal) {
		this.normal = normal;
	}

	public Integer getDifficult() {
		return difficult;
	}

	public void setDifficult(Integer difficult) {
		this.difficult = difficult;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
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
