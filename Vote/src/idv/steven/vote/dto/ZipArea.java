package idv.steven.vote.dto;

import org.springframework.stereotype.Component;

/**
 * 郵遞區號
 * @author Steven
 */
@Component
public class ZipArea {
	private String zipCode;
	private String name;
	
	/**
	 * @return 郵遞區號
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * @param zipCode 郵遞區號
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * @return 地名
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name 地名
	 */
	public void setName(String name) {
		this.name = name;
	}
}
