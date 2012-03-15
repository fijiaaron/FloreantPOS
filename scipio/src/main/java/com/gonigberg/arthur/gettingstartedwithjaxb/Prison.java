package com.gonigberg.arthur.gettingstartedwithjaxb;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Prison {
	private Cell cell;
	private Guard guard;
	
	public Cell getCell() {
		return cell;
	}
	public void setCell(Cell cell) {
		this.cell = cell;
	}
	public Guard getGuard() {
		return guard;
	}
	public void setGuard(Guard guard) {
		this.guard = guard;
	}
}
