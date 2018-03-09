/**
 * 
 */
package com.springinaction.entity.minstrel;

import java.io.PrintStream;

/**
 * @author MonkGirl
 *
 */
public final class Minstrel {

	private PrintStream stream;
	
	public Minstrel() {
		
	}
	
	public Minstrel(PrintStream stream) {
		this.stream = stream;
	}
	
	public void singBeforeQuest() {
		stream.println("Fa la la, the knight is so brave!");
	}
	
	public void singAfterQuest() {
		stream.println("Tee hee hee, the brave knight did embark on a quest!");
	}
}
