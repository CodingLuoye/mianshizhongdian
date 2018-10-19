package com.self.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
class Student{
	String name;
	int age;
	double score;
	public Student(){
		
	}
	public Student(String name, int age, double score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
}
/**
 * 模拟基本的数据库
 * @author Administrator
 *
 */
public class BasicDB {

	/**
	 * 保存键值对,键为String 类型,值为byte数组
	 * public void put(String key,byte[] value) throws IOException
	 * 根据键获取值,如果键不存在,返回null
	 * public byte[] get(String key) throws IOException
	 * public void remove(String key)
	 * public void flush() throws IOException
	 * public void close() thorws IOException
	 */
	//补白字节
	private static final int MAX_DATA_LNGTH = 1020; 
	//数据文件扩展名
	private static final byte[] ZERO_BYTES = new byte[MAX_DATA_LNGTH]; 
	//数据文件扩展名
	private static final String DATA_SUFFIX = ".data";
	//元数据文件扩展名,包括索引和空白空间数据
	private static final String META_SUFFIX = ".meta"; 
	//索引信息,键->值在.data文件中的位置
	Map<String,Long> indexMap; 
	// 空白空间,值为.data文件中的位置
	Queue<Long> gaps;
	//值数据文件
	RandomAccessFile db;
	//元数据文件
	File metaFile;
	
	public BasicDB(String path,String name) throws IOException{
		File dataFile = new File(path + name + DATA_SUFFIX);
		metaFile = new File(path + name + META_SUFFIX);
		db = new RandomAccessFile(dataFile, "rw");
		if(metaFile.exists()){
			loadMeta();
		}else{
			indexMap = new HashMap<>();
			gaps = new ArrayDeque<>();
		}
	}
	
	private void loadMeta() throws IOException{
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(metaFile)));
		try {
			loadIndex(in);
			loadGaps(in);
		} finally {
			in.close();
		}
	}

	private void loadGaps(DataInputStream in) throws IOException {
		int size = in.readInt();
		gaps = new ArrayDeque<>(size);
		for(int i = 0;i<size;i++){
			long index = in.readLong();
			gaps.add(index);
		}
	}

	private void loadIndex(DataInputStream in) throws IOException {
		int size = in.readInt();
		indexMap = new HashMap<String,Long>((int)(size/0.75f)+1,0.75f);
		for(int i = 0; i <size;i++){
			String key = in.readUTF();
			long index = in.readLong();
			indexMap.put(key, index);
		}
	}

	public void put(String key,byte[] value) throws IOException{
		Long index = indexMap.get(key);
		if(index == null){
			index = nextAvailablePos();
			indexMap.put(key, index);
		}
		writeData(index,value);
	}
	
	private void writeData(Long pos, byte[] data) throws IOException {
		if(data.length>MAX_DATA_LNGTH){
			throw new IllegalArgumentException("maximum allowed length is"+MAX_DATA_LNGTH+", data length is" + data.length);
		}
		db.seek(pos);
		db.writeInt(data.length);
		db.write(data);
		db.write(ZERO_BYTES, 0, MAX_DATA_LNGTH-data.length);
	}

	//通过索引查找键是否存在,如果不存在为值找一个存储位置
	private long nextAvailablePos() throws IOException{
		if(!gaps.isEmpty()){
			return gaps.poll();
		}else{
			return db.length();
		}
	}
	
	public byte[] get(String key) throws IOException{
		Long index = indexMap.get(key);
		if(index != null){
			return getData(index);
		}
		return null;
	}

	private byte[] getData(Long pos) throws IOException {
		db.seek(pos);
		int length = db.readInt();
		byte[] data = new byte[length];
		db.readFully(data);
		return data;
	}
	
	public void remove(String key){
		Long index = indexMap.remove(key);
		if(index != null){
			gaps.offer(index);
		}
	}
	
	public void flush() throws IOException{
		saveMata();
		db.getFD().sync();
	}

	private void saveMata() throws IOException{
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(metaFile)));
		try {
			saveIndex(out);
			saveGaps(out);
		} finally {
			out.close();
		}
	}

	private void saveGaps(DataOutputStream out) throws IOException {
		out.writeInt(gaps.size());
		for(Long pos :gaps){
			out.writeLong(pos);
		}
	}

	private void saveIndex(DataOutputStream out) throws IOException {
		out.writeInt(indexMap.size());
		for (Map.Entry<String, Long> entry:indexMap.entrySet()) {
			out.writeUTF(entry.getKey());
			out.writeLong(entry.getValue());
		}
	}
	
	public void close() throws IOException{
		flush();
		db.close();
	}
	
	private static byte[] toBytes(Student student) throws IOException{
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		DataOutputStream dout = new DataOutputStream(bout);
		dout.writeUTF(student.getName());
		dout.writeInt(student.getAge());
		dout.writeDouble(student.getScore());
		return bout.toByteArray();
	}
	
	public static void saveStudents(Map<String,Student> students) throws IOException{
		BasicDB db = new BasicDB("./", "students");
		for (Map.Entry<String, Student> kv:students.entrySet()) {
			db.put(kv.getKey(), toBytes(kv.getValue()));
		}
		System.out.println(db.get("1"));
		System.out.println(db.get("2"));
		System.out.println(db.get("3"));
		db.close();
	}
	
	public static void main(String[] args) {
		Map<String,Student> students = new HashMap<>(3);
		students.put("1", new Student("张三", 14, 15.7f));
		students.put("2", new Student("李四", 18, 16.2f));
		students.put("3", new Student("王五", 20, 18.5f));
		try {
			saveStudents(students);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
