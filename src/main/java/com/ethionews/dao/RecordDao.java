package com.ethionews.dao;

import java.util.List;

import com.ethionews.model.Record;

public interface RecordDao {
	public long createRecord(Record record);

	public Record updateRecord(Record record);

	public void deleteRecord(long id);

	public List<Record> getAllRecords();

	public Record getRecord(long id);

	public List<Record> getAllRecords(String search);
}
