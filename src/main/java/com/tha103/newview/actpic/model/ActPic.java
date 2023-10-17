package com.tha103.newview.actpic.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.google.gson.annotations.Expose;
import com.tha103.newview.act.model.ActVO;
import com.tha103.newview.actcategory.model.ActCategory;

@Entity
@Table(name = "actpic")
// 配合 TestHQLWithParameter.java
@NamedQuery(name = "getAllActPics", query = "from ActPic where ActPicID > :ActPicID order by ActPicID desc")
public class ActPic {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actPicID", updatable = false)
	private Integer actPicID;

	
	@Expose
	@Column(name = "actPic", columnDefinition = "LONGBLOB")
	private byte[] actPic;


	@ManyToOne
	@JoinColumn(name = "actID",referencedColumnName = "actID")
	@Transient
	private ActVO actVO;


	public ActPic() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ActPic(Integer actPicID, byte[] actPic, ActVO actVO) {
		super();
		this.actPicID = actPicID;
		this.actPic = actPic;
		this.actVO = actVO;
	}


	public Integer getActPicID() {
		return actPicID;
	}


	public void setActPicID(Integer actPicID) {
		this.actPicID = actPicID;
	}


	public byte[] getActPic() {
		return actPic;
	}


	public void setActPic(byte[] actPic) {
		this.actPic = actPic;
	}


	public ActVO getActVO() {
		return actVO;
	}


	public void setActVO(ActVO actVO) {
		this.actVO = actVO;
	}


	@Override
	public String toString() {
		return "ActPic [actPicID=" + actPicID + ", actPic=" + Arrays.toString(actPic) + ", actVO=" + actVO + "]";
	}

}
