package com.self.thread.safe;

public class ALogin extends Thread{
	@Override
	public void run() {
		LoginServlet.doPost("a", "aa");
	}
}
