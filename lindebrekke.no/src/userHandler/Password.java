package userHandler;

import javax.persistence.Embeddable;

import utils.PwdUtil;


/**
 * Password class for creating a password
 * 
 * @author Mikael Lindebrekke
 */

@Embeddable
public class Password {
	
	private String pwd_hash;
	private String pwd_salt;
	
	private Password(String hash, String salt) {
		pwd_hash = hash;
		pwd_salt = salt;
	}
	
	public Password() {
		//Empty constructor
	}
	/**
	 * Encrypts a password
	 * 
	 * @param newPassword
	 * @return Password
	 */
	public static Password makePassword(String newPassword) {
		String salt = PwdUtil.generateRandomSalt();
		String hash = PwdUtil.hashWithSalt(newPassword, salt);
		return new Password(hash, salt);
	}

	public String getPwd_hash() {
		return pwd_hash;
	}

	public String getPwd_salt() {
		return pwd_salt;
	}
	
	
}
