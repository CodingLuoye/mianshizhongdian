package com.self.enumconn;

public enum ConnEnum {
	connFactory;
	private Conn conn;
	
	private ConnEnum() {
		// url username password。。。
		conn = new Conn();
	}
	
	public Conn getConn() {
		return conn;
	}
}
