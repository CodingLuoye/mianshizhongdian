package com.self.thread.channel;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

class PipeWriteData{
	public void writeMethod(PipedWriter out){
		try {
			System.out.println("write :");
			for (int i = 0; i < 300; i++) {
				String outData = "" +(i+1);
				out.write(outData);
				System.out.print(outData);
			}
			System.out.println();
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
class PipeReadData{
	public void readMethod(PipedReader input){
		try {
			System.out.println("read :");
			char[] byteArray = new char[20];
			int readLength = input.read(byteArray);
			while(readLength != -1){
				String newData = new String(byteArray,0,readLength);
				System.out.print(newData);
				readLength = input.read(byteArray);
			}
			System.out.println();
			input.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class ThreadPipeWrite extends Thread{
	private PipeWriteData write;
	private PipedWriter out;
	public ThreadPipeWrite(PipeWriteData write,PipedWriter out) {
		super();
		this.write = write;
		this.out = out;
	}
	
	@Override
	public void run() {
		write.writeMethod(out);
	}
}
class ThreadPipeRead extends Thread{
	private PipeReadData read;
	private PipedReader input;
	public ThreadPipeRead(PipeReadData read,PipedReader input) {
		super();
		this.read = read;
		this.input = input;
	}
	
	@Override
	public void run() {
		read.readMethod(input);
	}
}
/**
 * 使用PipeWriter进行
 * @author Administrator
 *
 */
public class PipeReaderWriter {
	public static void main(String[] args) {
		try {
			PipeWriteData writeData = new PipeWriteData();
			PipeReadData readData = new PipeReadData();
			
			PipedWriter outStream = new PipedWriter();
			PipedReader inputStream = new PipedReader();
			outStream.connect(inputStream);
			
			ThreadPipeRead threadRead = new ThreadPipeRead(readData, inputStream);
			threadRead.start();
			
			Thread.sleep(2000);
			
			ThreadPipeWrite threadWrite = new ThreadPipeWrite(writeData, outStream);
			threadWrite.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
