package idv.steven.vote.dto;

import org.springframework.stereotype.Component;

/**
 * �l���ϸ�
 * @author Steven
 */
@Component
public class ZipArea {
	private String zipCode;
	private String name;
	
	/**
	 * @return �l���ϸ�
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * @param zipCode �l���ϸ�
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * @return �a�W
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name �a�W
	 */
	public void setName(String name) {
		this.name = name;
	}
}
