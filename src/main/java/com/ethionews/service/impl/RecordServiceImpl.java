package com.ethionews.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ethionews.dao.RecordDao;
import com.ethionews.model.Record;
import com.ethionews.service.RecordService;

@Service("recordService")
@Transactional
public class RecordServiceImpl implements RecordService {
	@Autowired
	private RecordDao recordDao;

	@Override
	public long createRecord(Record record) {
		return recordDao.createRecord(record);
	}

	@Override
	public Record updateRecord(Record record) {
		return recordDao.updateRecord(record);
	}

	@Override
	public void deleteRecord(long id) {
		recordDao.deleteRecord(id);

	}

	@Override
	public List<Record> getAllRecords() {
		return recordDao.getAllRecords();
	}

	@Override
	public Record getRecord(long id) {
		return recordDao.getRecord(id);
	}

	@Override
	public List<Record> getAllRecords(String search) {
		return recordDao.getAllRecords(search);
	}

}
