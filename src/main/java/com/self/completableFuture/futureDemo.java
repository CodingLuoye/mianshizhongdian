package com.self.completableFuture;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class futureDemo {
	public static void main(String[] args) {
		Runnable taskA = ()->System.out.println("task A");
		Runnable taskB = ()->System.out.println("task B");
		Runnable taskC = ()->System.out.println("task C");
		CompletableFuture.runAsync(taskA).thenRun(taskB).thenRun(taskC);
		
		Supplier<String> taskAA = ()->"hello";
		Function<String, String> taskBB = (t) ->t.toUpperCase();
		Consumer<String> taskCC = (t) ->System.out.println("consume: " + t);
		CompletableFuture.supplyAsync(taskAA).thenApply(taskBB).thenAccept(taskCC).join();
		
		Supplier<String> taskAAA = () -> "hello";
		Function<String,CompletableFuture<String>> taskBBB = (t)->CompletableFuture.supplyAsync(()->t.toUpperCase());
		Consumer<String> taskCCC = (t) ->System.out.println("consume: " + t);
		CompletableFuture.supplyAsync(taskAAA).thenCompose(taskBBB).thenAccept(taskCCC).join();
		
		Supplier<String> task1 = () -> "task1";
		CompletableFuture<String> task2 = CompletableFuture.supplyAsync(()->"task2");
		BiFunction<String, String, String> task3 = (a,b) ->a+","+b;
		String ret = CompletableFuture.supplyAsync(task1).thenCombine(task2, task3).join();
		System.out.println(ret);
		
		Instant now = Instant.now();
		System.out.println(now);
		Instant now1 = Instant.ofEpochMilli(System.currentTimeMillis());
		System.out.println(now1);
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		LocalDateTime ldt2 = LocalDateTime.of(2018, 8,3,20,59,59);
		System.out.println(ldt2);
		
		LocalDate ld = ldt.toLocalDate();
		LocalTime lt = ldt.toLocalTime();
		LocalDateTime ldt3 = ld.atTime(21,18,39);
		LocalDateTime ldt4 = lt.atDate(LocalDate.of(2018, 8, 3));
		
		System.out.println(ldt3+":" + ldt4);
		
//		LocalDate ld = LocalDate.of(2018, 8, 3);
//		LocalDate now2 = LocalDate.now();
//		LocalTime lt = LocalTime.of(21, 10,9);
//		LocalTime time = LocalTime.now();
		
		
	}
}
