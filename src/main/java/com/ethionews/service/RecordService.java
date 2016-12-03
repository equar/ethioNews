package com.ethionews.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.ethionews.model.Media;
import com.ethionews.model.Record;
import com.sun.syndication.io.FeedException;

public interface RecordService {
	public long createRecord(Media media) throws IOException, IllegalArgumentException, FeedException;

	public long createRecord(Record record);

	public Record updateRecord(Record record);

	public void deleteRecord(long id);

	public List<Record> getAllRecords();

	public Record getRecord(long id);

	public List<Record> getAllRecords(String search);
}
