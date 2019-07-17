package com.pagecge.practices.jsons;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class Csv2Json {
	/**
	 * 读取csv文件并转换为json
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			File inFile11 = new File("D:\\work\\test\\200_989_2019-07-11_2_afevent_2019-07-11-16-00_2019-07-11-17-00.csv");
			File infile22 = new File("D:\\work\\test\\200_1014_2019-07-08_2_afinstall_2019-07-08-13-00_2019-07-08-19-00.csv");
			File outFIle = new File("D:\\work\\test\\out.json");
			
			CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
			CsvMapper csvMapper = new CsvMapper();
			//read data from CSV file
			ObjectReader objectReader = csvMapper.readerFor(Map.class).with(csvSchema);
			
			List<Object> readAll = new ArrayList<Object>();
			readAll.addAll(objectReader.readValues(inFile11).readAll());//读取文件为json
			readAll.addAll(objectReader.readValues(infile22).readAll());//读取文件为json
			
			ObjectMapper mapper = new ObjectMapper();
//			ObjectWriter objectWriter = mapper.writerWithDefaultPrettyPrinter();//该方法是格式化后的json，文件稍大
			ObjectWriter objectWriter = mapper.writer();//该方法是压缩后的json,文件比较小
			
			// write to file
			objectWriter.writeValue(outFIle, readAll);
			// print to console
			System.out.println(objectWriter.writeValueAsString(readAll));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
