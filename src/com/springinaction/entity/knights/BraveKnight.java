package com.springinaction.entity.knights;

import com.springinaction.entity.minstrel.Minstrel;
import com.springinaction.entity.quest.Quest;

public class BraveKnight implements Knight{
	private Quest quest;
	//private Minstrel minstrel;
	public BraveKnight() {
		super();
	}
	
//	public BraveKnight(Quest quest, Minstrel minstrel) {
//		this.quest = quest;
//		this.minstrel = minstrel;
//	}
	
	public BraveKnight(Quest quest) {
		this.quest = quest;
	}
	
	public void embarkOnQuest() {
		//minstrel.singBeforeQuest();
		quest.embark();
		//minstrel.singAfterQuest();
	}
}
