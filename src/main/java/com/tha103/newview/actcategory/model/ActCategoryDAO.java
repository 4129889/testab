package com.tha103.newview.actcategory.model;

import java.util.List;

import com.tha103.newview.act.model.ActVO;

public interface ActCategoryDAO {
	 void insert(ActCategory actCategory);
	 void update(ActCategory act);
     void delete(Integer Act);
     ActCategory findByPrimaryKey(Integer actCategoryID);
     List<ActCategory> getAll();
}
