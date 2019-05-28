package test;

import java.io.Serializable;
import java.math.BigDecimal;

public class MemberBean implements Serializable {
	private static final long serialVersionUID = -705247169802028563L;
	private String statisticalItem;
	private String item;
	private Integer samples;
	private BigDecimal under2w;
	private BigDecimal over2w;
	private BigDecimal over3w;
	private BigDecimal over4w;
	private BigDecimal over5w;

	public MemberBean() {
	}

	public MemberBean(String statisticalItem, String item, Integer samples, BigDecimal under2w, BigDecimal over2w,
			BigDecimal over3w, BigDecimal over4w, BigDecimal over5w) {
		super();
		this.statisticalItem = statisticalItem;
		this.item = item;
		this.samples = samples;
		this.under2w = under2w;
		this.over2w = over2w;
		this.over3w = over3w;
		this.over4w = over4w;
		this.over5w = over5w;
	}

	@Override
	public String toString() {
		return "MemberBean [statisticalItem=" + statisticalItem + ", item=" + item + ", samples=" + samples
				+ ", under2w=" + under2w + ", over2w=" + over2w + ", over3w=" + over3w + ", over4w=" + over4w
				+ ", over5w=" + over5w + "]";
	}

	public String getStatisticalItem() {
		return statisticalItem;
	}

	public void setStatisticalItem(String statisticalItem) {
		this.statisticalItem = statisticalItem;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getSamples() {
		return samples;
	}

	public void setSamples(Integer samples) {
		this.samples = samples;
	}

	public BigDecimal getUnder2w() {
		return under2w;
	}

	public void setUnder2w(BigDecimal under2w) {
		this.under2w = under2w;
	}

	public BigDecimal getOver2w() {
		return over2w;
	}

	public void setOver2w(BigDecimal over2w) {
		this.over2w = over2w;
	}

	public BigDecimal getOver3w() {
		return over3w;
	}

	public void setOver3w(BigDecimal over3w) {
		this.over3w = over3w;
	}

	public BigDecimal getOver4w() {
		return over4w;
	}

	public void setOver4w(BigDecimal over4w) {
		this.over4w = over4w;
	}

	public BigDecimal getOver5w() {
		return over5w;
	}

	public void setOver5w(BigDecimal over5w) {
		this.over5w = over5w;
	}

}