package com.ethionews.service.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ethionews.dao.RecordDao;
import com.ethionews.model.Media;
import com.ethionews.model.Record;
import com.ethionews.service.RecordService;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

@Service("recordService")
@Transactional
public class RecordServiceImpl implements RecordService {
	@Autowired
	private RecordDao recordDao;

	@Override
	public long createRecord(Media media) throws IOException, IllegalArgumentException, FeedException {
		Document doc = null;
		Record record = null;
		URL url = new URL("http://feeds.bbci.co.uk/news/world/rss.xml?edition=uk#");
		HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
		// Reading the feed
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(httpcon));
		@SuppressWarnings("unchecked")
		List<SyndEntry> entries = feed.getEntries();
		Iterator<SyndEntry> itEntries = entries.iterator();
		Date today = Calendar.getInstance().getTime();
		List<Record> records = new ArrayList<>();
		// getting all records
		List<Record> drRecords = recordDao.getAllRecords();
		List<String> links = new ArrayList<>();
		for (int i = 0; i < drRecords.size(); i++) {
			links.add(drRecords.get(i).getLink());
		}

		while (itEntries.hasNext()) {
			SyndEntry entry = itEntries.next();

			if (!links.contains(entry.getLink())) {
				record = new Record();
				record.setTitle(entry.getTitle());
				record.setLink(entry.getLink());
				record.setDescription(entry.getDescription().toString());
				record.setDate(today);

				/*
				 * doc = Jsoup.connect(entry.getLink()).ignoreContentType(true).
				 * timeout(10 * 1000).get(); record.setContent(doc.text());
				 */
				record.setContent(entry.getTitle());

				record.setMedia(media);
				records.add(record);
			}
		}
		return recordDao.createRecord(records);
	}

	public long createRecord(Record record) {
		// return recordDao.createRecord(record);
		return 1;
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

	public List<Record> getRecords(Integer offset, Integer maxResults) {
		return recordDao.getRecords(offset, maxResults);
	}

	public Long count() {
		return recordDao.count();
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
