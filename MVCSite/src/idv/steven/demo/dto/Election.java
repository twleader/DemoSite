package idv.steven.demo.dto;

import org.springframework.stereotype.Component;

/**
 * 選舉場次
 * @author Steven
 */
@Component
public class Election {
	private int year;
	private String name;
	private String id;
	
	/**
	 * @return 選舉年度
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * @param year 選舉年度
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * @return 選舉名稱
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name 選舉名稱
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return 選舉編號
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id 選舉編號
	 */
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Election [year=" + year + ", name=" + name + ", id=" + id + "]";
	}
}
