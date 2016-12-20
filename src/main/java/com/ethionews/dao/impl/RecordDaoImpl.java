package com.ethionews.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ethionews.dao.RecordDao;
import com.ethionews.model.User;
import com.ethionews.model.Record;
import com.ethionews.util.HibernateUtil;

@Repository("recordDao")
public class RecordDaoImpl implements RecordDao {
	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public long createRecord(List<Record> records) {
		long result = 1;
		Record record;
		for (int i = 0; i < records.size(); i++) {
			record = records.get(i);
			result = (Long) hibernateUtil.create(record);
		}

		return result;
	}

	@Override
	public Record updateRecord(Record record) {
		return hibernateUtil.update(record);
	}

	@Override
	public void deleteRecord(long id) {
		Record record = new Record();
		record.setId(id);
		User user = new User();
		user.setId(id);
		hibernateUtil.delete(id, User.class);
		hibernateUtil.delete(record);

	}

	@Override
	public List<Record> getAllRecords() {
		return hibernateUtil.fetchAll(Record.class);
	}

	@Override
	public Record getRecord(long id) {
		return hibernateUtil.fetchById(id, Record.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Record> getAllRecords(String roleType) {
		String query = "SELECT e.* FROM Record e WHERE e.roleType like '%" + roleType + "%'";
		List<Object[]> recordObjects = hibernateUtil.fetchAll(query);
		List<Record> records = new ArrayList<Record>();
		for (Object[] recordObject : recordObjects) {
			Record record = new Record();
			long roleId = ((long) recordObject[0]);
			String roleName = (String) recordObject[1];
			record.setId(roleId);
			// record.setRoleType(roleName);
			records.add(record);
		}
		System.out.println(records);
		return records;
	}

}
