package com.self.lambda;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * lambadDemo测试
 * @author cl
 *
 */
public class lambadDemo {
	static class Student{
		String name;
		double score;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getScore() {
			return score;
		}
		public void setScore(double score) {
			this.score = score;
		}
		public Student(String name, double score) {
			super();
			this.name = name;
			this.score = score;
		}
	}
	
	/**Predicate*/ 
	public static<E> List<E> filter (List<E> list,Predicate<E> pred){
		List<E> retList = new ArrayList<>();
		for (E e : list) {
			if(pred.test(e)){
				retList.add(e);
			}
		}
		return retList;
	}
	/**Function*/
	public static<T,R> List<R> map(List<T> list,Function<T,R> mapper){
		List<R> retList = new ArrayList<>(list.size());
		for (T e : list) {
			retList.add(mapper.apply(e));
		}
		return retList;
	}
	/**Consumer*/
	public static <E> void foreach(List<E> list,Consumer<E> consumer){
		for (E e : list) {
			consumer.accept(e);
		}
	}
	public static void main(String[] args) {
//		File f = new File(".");
//		File[] files = f.listFiles((File dir,String name) -> {
//			if(name.endsWith(".txt")){
//				return true;
//			}
//			return false;
//		});
//		
//		File[] files2 = f.listFiles((File dir,String name)->{return name.endsWith(".txt");});
//		File[] files3 = f.listFiles((dir,name) ->name.endsWith(".txt"));
//		Arrays.sort(files,(f1,f2)->f1.getName().compareTo(f2.getName()));
//		
//		FileFilter filter = path->path.getName().endsWith(".txt");
//		FilenameFilter fileNameFilter = (dir,name) ->name.endsWith(".txt");
//		Comparator<File> comparator = (f1,f2)->f1.getName().compareTo(f2.getName());
//		Runnable task = ()->System.out.println("hello world");
		
		List<Student> students = Arrays.asList(new Student[]{
				new Student("zhangsan",88d),
				new Student("lisi",89d),
				new Student("wangwu",98d)
		});
		students = filter(students,t->t.getScore()>90);
		students.stream().forEach(s->System.out.println(s.getName()+" "+s.getScore()));
		List<String> names = map(students,t->t.getName()); 
		List<String> names2 = map(students,Student::getName);
		names.stream().forEach(s->System.out.println(s));
		names2.stream().forEach(s->System.out.println(s));
		students = map(students, t->new Student(t.getName().toUpperCase(),t.getScore()));
		students.stream().forEach(s->System.out.println(s.getName()+" "+s.getScore()));
		
		foreach(students, t->t.setName(t.getName().toUpperCase()));
		
	}

}
