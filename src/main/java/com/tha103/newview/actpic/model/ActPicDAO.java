package com.tha103.newview.actpic.model;

import java.util.List;

import com.tha103.newview.actcategory.model.ActCategory;

public interface ActPicDAO {
	 void insert(ActPic actPic);
	 void update(ActPic act);
     void delete(Integer actPicID);
     ActPic findByPrimaryKey(Integer actPicID);
     List<ActPic> getAll();
}
